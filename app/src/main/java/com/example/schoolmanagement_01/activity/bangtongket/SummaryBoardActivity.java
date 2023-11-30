package com.example.schoolmanagement_01.activity.bangtongket;

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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
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
import com.example.schoolmanagement_01.core.cache.AccountCache;
import com.example.schoolmanagement_01.core.contants.DBConstants;
import com.example.schoolmanagement_01.core.contants.GoogleSheetConstant;
import com.example.schoolmanagement_01.core.dao.GeneralDAO;
import com.example.schoolmanagement_01.core.dto.AccountDTO;
import com.example.schoolmanagement_01.core.dto.PointDTO;
import com.example.schoolmanagement_01.core.dto.ReportDTO;
import com.example.schoolmanagement_01.core.dto.SummaryDTO;
import com.example.schoolmanagement_01.core.dto.SummaryExportDTO;
import com.example.schoolmanagement_01.core.dto.SummaryRawDTO;
import com.example.schoolmanagement_01.core.engine.SumaryEngine;
import com.example.schoolmanagement_01.core.service.ExcelService;
import com.example.schoolmanagement_01.core.service.UltilService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SummaryBoardActivity extends AppCompatActivity {
    ListView lvSummary;
    TextView tvStaffName, tvWeek, tvYear; //khai báo năm học hiển thị trong texview
    Button btnExportExcel;
    ArrayList<SummaryDTO> summaryDTOList = new ArrayList<>();
    ArrayList<SummaryExportDTO> summaryExportDTOList = new ArrayList<>();
    AccountDTO accountDTO = new AccountDTO();

    GeneralDAO generalDAO;
    SummaryBoardAdapter summaryBoardAdapter;
    List<String> listSessionClass ;
    String week = "0";
    String year = "0";
   //String nam = "0";   //chuỗi năm học
    String staffName = "";
    int lastRank = 0;
    SharedPreferences sharedPreferences;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_board);
        Intent intent = getIntent();
        Integer session = intent.getIntExtra("session",0);
        switch (session){
            case 0:
                listSessionClass = DBConstants.listClassSang;
                break;
            case 1:
                listSessionClass = DBConstants.listClassChieu;
                break;
        }
        accountDTO = AccountCache.getCache(SummaryBoardActivity.this);
        lvSummary = findViewById(R.id.lvSummary);
        tvStaffName = findViewById(R.id.tv_summary_staff_name);
        tvWeek = findViewById(R.id.tv_summary_week);
        tvYear = findViewById(R.id.tv_summary_year);
                // tvNam = findViewById(R.id.tv_summary_nam); // Tìm đến textview để gán vào
        btnExportExcel = findViewById(R.id.btn_export_excel);
        btnExportExcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    if (!Environment.isExternalStorageManager()) {
                        Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                        startActivity(intent);
                    }
                }
                ActivityCompat.requestPermissions(SummaryBoardActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
                String absolutePath = ExcelService.exportExcel(summaryDTOList,
                        android.text.format.DateFormat.format("Tuần " + week +" (ss-mm-hh-ddMMyyyy)", new java.util.Date()).toString(),
                        week);
                Toast.makeText(getApplicationContext(), absolutePath, Toast.LENGTH_LONG).show();

            }
        });
        generalDAO = new GeneralDAO(getApplicationContext());
        sharedPreferences = getSharedPreferences("week",MODE_PRIVATE);
        week = sharedPreferences.getString("week",-1+"");

        sharedPreferences = getSharedPreferences("year",MODE_PRIVATE);
        year = sharedPreferences.getString("year",0+"");

        tvWeek.setText("Tuần: "+ week);
        tvYear.setText("Năm học: "+year);
        tvStaffName.setText("Người trực: "+accountDTO.getDisplayName());
        //Hiển thị số lớp đưa vào mảng trong bảng tổng kết

        StringRequest stringRequest = new StringRequest(Request.Method.POST, GoogleSheetConstant.END_POINT_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("response", response);
                float [] arr = new float[listSessionClass.size()];
                int position = 0;
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    SummaryRawDTO summaryRawDTO = objectMapper.readValue(response, SummaryRawDTO.class);
                    List<ReportDTO> listReportDTO = objectMapper.readValue(summaryRawDTO.getJsonListReport(), new TypeReference<List<ReportDTO>>(){});
                    List<PointDTO> listPointDTO = objectMapper.readValue(summaryRawDTO.getJsonListPoint(), new TypeReference<List<PointDTO>>(){});


                    for (String classRoom: listSessionClass){
                        PointDTO pointDTO = null;
                        List<ReportDTO> listReport = new ArrayList<>();

                        for (int i = 0; i<listReportDTO.size(); i++){
                            if(classRoom.equals(listReportDTO.get(i).getClassRoom())){
                                listReport.add(listReportDTO.get(i));
                            }
                        }

                        for (int i = listPointDTO.size() - 1; i>=0; i--){
                            if(classRoom.equals(listPointDTO.get(i).getClassRoom())){
                                if(classRoom.equals(listPointDTO.get(i).getClassRoom().toString())){
                                    pointDTO = listPointDTO.get(i);
                                    break;
                                }
                            }
                        }
                        //hiển thị trong app
                        SummaryDTO summaryDTO = SumaryEngine.calculatorSummary(classRoom, pointDTO, listReport);

                        //hiển thị trong excel
//                        SummaryExportDTO summaryExportDTO = UltilService.convertSummaryExportDTO(pointDTO, listReport);

                        summaryDTO.setClassRoom(classRoom);
//                        summaryExportDTO.setClassRoom(classRoom);

                        summaryDTOList.add(summaryDTO);
//                        summaryExportDTOList.add(summaryExportDTO);
                        arr[position] = Float.parseFloat(summaryDTO.getTongDiem());
                        position++;
                    }

                    float[] temp = Arrays.copyOfRange(arr, 0, arr.length);
                    Arrays.sort(temp);
                    UltilService.reverseArrayFloat(temp);
                    HashMap<Float, Integer> map = new HashMap<>();
                    int index = 1;
                    float prev = temp[0];
                    map.put(prev, index);

                    for(int i = 1; i<arr.length; i++){
                        if(prev!=temp[i])
                            index++;
                        map.put(temp[i], index);
                        prev=temp[i];
                        lastRank = index;
                    }

                    for(int i=0; i<arr.length; i++){
                        summaryDTOList.get(i).setHang(map.get(arr[i]));
//                        summaryExportDTOList.get(i).setXepHang(map.get(arr[i]).toString());
                    }
                    summaryBoardAdapter = new SummaryBoardAdapter(getApplicationContext(),0, summaryDTOList);
                    lvSummary.setAdapter(summaryBoardAdapter);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Bạn chưa bật kết nối Internet ?", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("action", "GET_SUMMARY_RAW_BY_WEEK");
                params.put("week", week);
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
}