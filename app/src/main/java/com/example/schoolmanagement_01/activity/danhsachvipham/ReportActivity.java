package com.example.schoolmanagement_01.activity.danhsachvipham;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
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
import androidx.core.app.ActivityCompat;

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
import com.example.schoolmanagement_01.activity.danhsachvipham.adapter.ChooseCollectionRuleAdapter;
import com.example.schoolmanagement_01.activity.danhsachvipham.adapter.ChooseWeekAdapter;
import com.example.schoolmanagement_01.core.contants.DBConstants;
import com.example.schoolmanagement_01.core.contants.GoogleSheetConstant;
import com.example.schoolmanagement_01.core.dao.GeneralDAO;
import com.example.schoolmanagement_01.core.dto.ReportDTO;
import com.example.schoolmanagement_01.core.dto.RuleCollectionDTO;
import com.example.schoolmanagement_01.core.sco.ReportSCO;
import com.example.schoolmanagement_01.core.service.ExcelService;
import com.example.schoolmanagement_01.core.util.NotifyUtils;
import com.example.schoolmanagement_01.core.util.TransformerUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportActivity extends AppCompatActivity {
    GeneralDAO generalDAO;
    ReportAdapter reportAdapter;
    ChooseWeekAdapter chooseWeekAdapter;
    ChooseClassRoomAdapter chooseClassRoomAdapter;

    ChooseCollectionRuleAdapter chooseCollectionRuleAdapter;

    Spinner spnChooseWeek, spnChooseClassRoom, spnChooseCollectionRule;
    Button btnSearchReport, btnBack, btnExportExcel;
    ListView lvReport;
    TextView tvNotify,tvNotify2;
    ProgressBar pgMain;

    static List<ReportDTO> listReportDTO = new ArrayList<>();
    List<String> listWeek = DBConstants.listWeek;
    List<String> listClassRoom = DBConstants.listClassRoom;

    String positionWeek = "";
    ReportSCO reportSCO = new ReportSCO();
    SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        //cache
        //cookie

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
        btnExportExcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    if (!Environment.isExternalStorageManager()) {
                        Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                        startActivity(intent);
                    }
                }
                ActivityCompat.requestPermissions(ReportActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
                if(CollectionUtils.isNotEmpty(listReportDTO)){
                    String absolutePath = ExcelService.exportReportExcel(listReportDTO,
                            android.text.format.DateFormat.format("danhsachviphamtuan " + reportSCO.getWeek() +" (ss-mm-hh-ddMMyyyy)", new java.util.Date()).toString(),
                            reportSCO.getWeek());
                    Toast.makeText(getApplicationContext(), absolutePath, Toast.LENGTH_LONG).show();
                }else {
                    NotifyUtils.defaultNotify(getApplicationContext(), "Danh sách trống");
                }
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
                        return TransformerUtils.dtoToPayload(reportSCO, GoogleSheetConstant.ACTION_GET_REPORT_BY_WEEK_AND_CLASS);
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
        sharedPref = getSharedPreferences("week", MODE_PRIVATE);
        positionWeek = sharedPref.getString("position","2");
        reportSCO.setWeek(listWeek.get(Integer.parseInt(positionWeek)));

        spnChooseClassRoom = findViewById(R.id.spn_choose_class_room);
        spnChooseCollectionRule = findViewById(R.id.spn_choose_collection_rule);
        spnChooseWeek = findViewById(R.id.spn_choose_week);
        btnSearchReport = findViewById(R.id.btn_search_report);
        tvNotify = findViewById(R.id.tv_notify);
        tvNotify2 = findViewById(R.id.tv_notify_2);
        lvReport = findViewById(R.id.lv_report);
        btnBack = findViewById(R.id.btn_back_report);
        pgMain = findViewById(R.id.pg_main);
        btnExportExcel = findViewById(R.id.btn_export_excel);

        generalDAO = new GeneralDAO(getApplicationContext());


        chooseWeekAdapter = new ChooseWeekAdapter(getApplicationContext(), listWeek);
        spnChooseWeek.setAdapter(chooseWeekAdapter);
        spnChooseWeek.setSelection(Integer.parseInt(positionWeek));
        spnChooseWeek.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                reportSCO.setWeek(listWeek.get(i));
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
                reportSCO.setClassRoom( listClassRoom.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        chooseCollectionRuleAdapter = new ChooseCollectionRuleAdapter(getApplicationContext(), DBConstants.RULE_COLLECTION_DTO_LIST);

        spnChooseCollectionRule.setAdapter(chooseCollectionRuleAdapter);
        spnChooseCollectionRule.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                RuleCollectionDTO ruleCollectionDTO = (RuleCollectionDTO) view.getTag();
                reportSCO.setCollectionRuleCode(ruleCollectionDTO.getCode());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}