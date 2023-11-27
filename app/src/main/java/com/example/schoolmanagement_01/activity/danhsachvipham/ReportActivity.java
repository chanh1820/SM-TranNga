package com.example.schoolmanagement_01.activity.danhsachvipham;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.activity.danhsachvipham.adapter.ChooseClassRoomAdapter;
import com.example.schoolmanagement_01.activity.danhsachvipham.adapter.ChooseWeekAdapter;
import com.example.schoolmanagement_01.core.contants.DBConstants;
import com.example.schoolmanagement_01.core.contants.GoogleSheetConstant;
import com.example.schoolmanagement_01.core.dao.GeneralDAO;
import com.example.schoolmanagement_01.core.dto.ReportDTO;
import com.example.schoolmanagement_01.core.service.UltilService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportActivity extends AppCompatActivity {
    GeneralDAO generalDAO;
    ReportAdapter reportAdapter;
    ChooseWeekAdapter chooseWeekAdapter;
    ChooseClassRoomAdapter chooseClassRoomAdapter;

    Spinner spnChooseWeek, spnChooseClassRoom;
    Button btnSearchReport, btnBack;
    ListView lvReport;
    TextView tvNotify,tvNotify2;
    ProgressBar pgMain;

    List<ReportDTO> listReportDTO = new ArrayList<>();
    List<String> listWeek = DBConstants.listWeek;
    List<String> listClassRoom = DBConstants.listClassRoom;

    String week= "";
    String positionWeek = "";
    String classRoom = "";
    SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        //cache
        //cookie
        sharedPref = getSharedPreferences("week", MODE_PRIVATE);
        positionWeek = sharedPref.getString("position","2");
        week = listWeek.get(Integer.parseInt(positionWeek));
        Log.e("position",positionWeek);
        initView();
        action();
    }

    private void action() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnSearchReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSearchReport.setEnabled(false);
                btnSearchReport.setClickable(false);
                pgMain.setVisibility(View.VISIBLE);
                tvNotify2.setVisibility(View.VISIBLE);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, GoogleSheetConstant.END_POINT_URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        btnSearchReport.setEnabled(true);
                        btnSearchReport.setClickable(true);
                        pgMain.setVisibility(View.INVISIBLE);
                        tvNotify2.setVisibility(View.GONE);

                        Log.e("response", response);
                        ObjectMapper objectMapper = new ObjectMapper();
                        try {
                            listReportDTO = objectMapper.readValue(response, new TypeReference<List<ReportDTO>>() {
                            });
                            Map<String, Long> mapShortCut = listReportDTO.stream().collect(Collectors.groupingBy(e -> e.getRuleCode(), Collectors.counting()));
                            Log.e("mapShortCut", UltilService.converObjectToString(mapShortCut));
                            if (listReportDTO.size() == 0) {
                                tvNotify.setVisibility(View.VISIBLE);
                                reportAdapter = new ReportAdapter(getApplicationContext(), 1, new ArrayList<ReportDTO>());
                                lvReport.setAdapter(reportAdapter);
                            } else {
                                reportAdapter = new ReportAdapter(getApplicationContext(), 1, listReportDTO);
                                lvReport.setAdapter(reportAdapter);
                                tvNotify.setVisibility(View.GONE);
                                tvNotify2.setVisibility(View.GONE);

                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        btnSearchReport.setEnabled(true);
                        btnSearchReport.setClickable(true);
                        pgMain.setVisibility(View.INVISIBLE);
                        tvNotify2.setVisibility(View.GONE);

                        Toast.makeText(getApplicationContext(), "Bạn chưa bật kết nối Internet ?", Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("action", "GET_REPORT_BY_WEEK_AND_CLASS");
                        params.put("week", week);
                        params.put("classRoom", classRoom);
                        Log.e("params", UltilService.converObjectToString(params));
                        return params;
                    }
                };

                RetryPolicy retryPolicy = new DefaultRetryPolicy(
                        50000,
                        0,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                stringRequest.setRetryPolicy(retryPolicy);
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);
            }
        });
    }

    private void initView() {
        spnChooseClassRoom = findViewById(R.id.spn_choose_class_room);
        spnChooseWeek = findViewById(R.id.spn_choose_week);
        btnSearchReport = findViewById(R.id.btn_search_report);
        tvNotify = findViewById(R.id.tv_notify);
        tvNotify2 = findViewById(R.id.tv_notify_2);
        lvReport = findViewById(R.id.lv_report);
        btnBack = findViewById(R.id.btn_back_report);
        pgMain = findViewById(R.id.pg_main);

        generalDAO = new GeneralDAO(getApplicationContext());


        chooseWeekAdapter = new ChooseWeekAdapter(getApplicationContext(), listWeek);
        spnChooseWeek.setAdapter(chooseWeekAdapter);
        spnChooseWeek.setSelection(Integer.parseInt(positionWeek));
        spnChooseWeek.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                week = listWeek.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        if(!getIntent().getStringExtra("class").equals("")){
            listClassRoom = new ArrayList<String>() {{
                add(getIntent().getStringExtra("class"));
            }};
        }
        chooseClassRoomAdapter = new ChooseClassRoomAdapter(getApplicationContext(), listClassRoom);

        spnChooseClassRoom.setAdapter(chooseClassRoomAdapter);
        spnChooseClassRoom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                classRoom = listClassRoom.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}