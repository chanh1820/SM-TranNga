package com.example.schoolmanagement_01.activity.luuvipham;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
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
import com.example.schoolmanagement_01.activity.luuvipham.adapter.ChooseRuleChildAdapter;
import com.example.schoolmanagement_01.activity.luuvipham.adapter.ChooseRuleParentAdapter;
import com.example.schoolmanagement_01.activity.quanlytrucnhat.adapter.ChooseStudentAdapter;
import com.example.schoolmanagement_01.core.cache.AccountCache;
import com.example.schoolmanagement_01.core.contants.DBConstants;
import com.example.schoolmanagement_01.core.contants.GoogleSheetConstant;
import com.example.schoolmanagement_01.core.dao.GeneralDAO;
import com.example.schoolmanagement_01.core.dto.AccountDTO;
import com.example.schoolmanagement_01.core.dto.ReportDTO;
import com.example.schoolmanagement_01.core.dto.ResponseDTO;
import com.example.schoolmanagement_01.core.dto.RuleDTO;
import com.example.schoolmanagement_01.core.dto.StudentDTO;
import com.example.schoolmanagement_01.core.service.UltilService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SaveReportActivity extends AppCompatActivity {
    Spinner studentSpinner;
    Spinner chooseRuleParentSpinner;
    Spinner chooseRuleChildSpinner;
    ImageView imvInitImage, imvStudentImage;
    Button btnSaveReport, btnBack;
    TextView tvStaffName;
    LinearLayout lvLoaiViPham;
    private static final int CAMERA_REQUEST_CODE = 100;
    List<StudentDTO> studentDTOList = new ArrayList<>();
    List<RuleDTO> ruleDTOList = DBConstants.listRuleDTO;
    List<RuleDTO> ruleChildList = new ArrayList<>();
    List<RuleDTO> ruleParentList = new ArrayList<>();
    AccountDTO accountDTO = new AccountDTO();

    ChooseStudentAdapter chooseStudentAdapter;
    ChooseRuleParentAdapter chooseRuleParentAdapter;
    ChooseRuleChildAdapter chooseRuleChildAdapter;
    GeneralDAO generalDAO;
    ReportDTO reportDTO = new ReportDTO();
    SharedPreferences sharedPref;
    String weekCurrent = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_report);
        sharedPref = getSharedPreferences("week", MODE_PRIVATE);
        weekCurrent = sharedPref.getString("week", 0 + "");
        initView();
        action();

    }

    private void action() {
        imvInitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, CAMERA_REQUEST_CODE);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == CAMERA_REQUEST_CODE) {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                imvInitImage.setImageBitmap(bitmap);
                reportDTO.setPathImage(UltilService.BitMapToString(bitmap));
            }
        }
    }

    private void initView() {
        accountDTO = AccountCache.getCache(SaveReportActivity.this);
        studentSpinner = findViewById(R.id.spn_choose_student);
        chooseRuleChildSpinner = findViewById(R.id.spn_choose_rule_child);
        chooseRuleParentSpinner = findViewById(R.id.spn_choose_rule_parent);
        lvLoaiViPham = findViewById(R.id.ln_save_report_loai_vi_pham);
        imvInitImage = findViewById(R.id.imv_init_image);
        imvStudentImage = findViewById(R.id.imv_save_report_image_student);
        tvStaffName = findViewById(R.id.tv_save_report_nguoi_truc);
        btnSaveReport = findViewById(R.id.btn_save_report);
        btnBack = findViewById(R.id.btn_back_add_report);

        tvStaffName.setText(accountDTO.getDisplayName());

        reportDTO.setWeek(weekCurrent);
        Log.e("week", weekCurrent);
        btnSaveReport.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                btnSaveReport.setEnabled(false);
                btnSaveReport.setClickable(false);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
                LocalDateTime now = LocalDateTime.now();
                reportDTO.setCreatedDate(dtf.format(now));
//                generalDAO.saveReport(reportDTO);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, GoogleSheetConstant.END_POINT_URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("response", response);
                        ObjectMapper objectMapper = new ObjectMapper();
                        try {
                            ResponseDTO responseDTO = objectMapper.readValue(response, ResponseDTO.class);
                            if (responseDTO.getStatus().equals(GoogleSheetConstant.STATUS_SUCCESS)) {
                                Toast.makeText(getApplicationContext(), "Lưu thành công", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "Lưu thất bại", Toast.LENGTH_SHORT).show();
                            }
                            btnSaveReport.setEnabled(true);
                            btnSaveReport.setClickable(true);
                        } catch (IOException e) {
                            btnSaveReport.setEnabled(true);
                            btnSaveReport.setClickable(true);
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        btnSaveReport.setEnabled(true);
                        btnSaveReport.setClickable(true);
                        Toast.makeText(getApplicationContext(), "Bạn chưa bật kết nối Internet ?", Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("action", "SAVE_REPORT");
                        params.put("week", reportDTO.getWeek());
                        params.put("classRoom", reportDTO.getClassRoom());
                        params.put("ruleName", reportDTO.getRuleName());
                        params.put("ruleCode", reportDTO.getRuleCode());
                        params.put("collectionCode", reportDTO.getCollectionCode());
                        params.put("studentName", reportDTO.getStudentName());
                        params.put("minusPoint", reportDTO.getMinusPoint().toString());
                        params.put("pathImage", "");
                        params.put("createdDate", reportDTO.getCreatedDate());
                        params.put("ruleNameMore", reportDTO.getRuleName());
                        Log.e("params", UltilService.converObjectToString(params));
                        return params;
                    }
                };

                RetryPolicy retryPolicy = new DefaultRetryPolicy(
                        10000,
                        0,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                stringRequest.setRetryPolicy(retryPolicy);
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);
            }
        });


        Intent i = getIntent();
        reportDTO.setClassRoom(i.getStringExtra("class"));
        generalDAO = new GeneralDAO(getApplicationContext());

        studentDTOList = generalDAO.findStudentByClassRoom(reportDTO.getClassRoom());

        chooseStudentAdapter = new ChooseStudentAdapter(getApplicationContext(), studentDTOList);
        studentSpinner.setAdapter(chooseStudentAdapter);
        ///
        studentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                reportDTO.setStudentName(studentDTOList.get(i).getStudentName());
                Drawable drawableStudent = UltilService.loadDrawableFromAssets(
                        SaveReportActivity.this,
                        DBConstants.ASSET_PATH_LOP_11_1 + studentDTOList.get(i).getImageFile());
                if(drawableStudent !=null){
                    imvStudentImage.setImageDrawable(drawableStudent);
                }else {
                    imvStudentImage.setImageResource(R.drawable.ic_baseline_person_24);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        if (accountDTO.getRole().equals(GoogleSheetConstant.ROLE_HOC_SINH_TRUC)) {
            ruleParentList = UltilService.getRuleById(ruleDTOList, 1);
            ruleChildList = UltilService.getRules(ruleDTOList, ruleParentList.get(0).getId());
            updateRuleChildSpinner(ruleChildList);
            lvLoaiViPham.setVisibility(View.GONE);
        } else if (accountDTO.getRole().equals(GoogleSheetConstant.ROLE_BAO_VE)) {
            ruleParentList = UltilService.getRuleById(ruleDTOList, 2);
            ruleChildList = UltilService.getRules(ruleDTOList, ruleParentList.get(0).getId());
            updateRuleChildSpinner(ruleChildList);
            lvLoaiViPham.setVisibility(View.GONE);
        } else if (accountDTO.getRole().equals(GoogleSheetConstant.ROLE_CAN_BO_LOP)) {
            ruleParentList = UltilService.getRuleById(ruleDTOList, 3);
            ruleChildList = UltilService.getRules(ruleDTOList, ruleParentList.get(0).getId());
            updateRuleChildSpinner(ruleChildList);
            lvLoaiViPham.setVisibility(View.GONE);
        } else {
            ruleParentList = UltilService.getRules(ruleDTOList, 0);
        }
        chooseRuleParentAdapter = new ChooseRuleParentAdapter(getApplicationContext(), ruleParentList);
        chooseRuleParentSpinner.setAdapter(chooseRuleParentAdapter);
        chooseRuleParentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ruleChildList = UltilService.getRules(ruleDTOList, ruleParentList.get(i).getId());
                updateRuleChildSpinner(ruleChildList);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    private void updateRuleChildSpinner(List<RuleDTO> ruleChildList) {
        chooseRuleChildAdapter = new ChooseRuleChildAdapter(getApplicationContext(), ruleChildList);
        chooseRuleChildSpinner.setAdapter(chooseRuleChildAdapter);
        chooseRuleChildSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                RuleDTO ruleDTO = ruleChildList.get(i);
                reportDTO.setRuleName(ruleDTO.getRuleName());
                reportDTO.setRuleCode(ruleDTO.getRuleCode());
                reportDTO.setMinusPoint(ruleDTO.getMinusPoint());
                reportDTO.setRuleNameMore(ruleDTO.getRuleNameMore());
                reportDTO.setCollectionCode(ruleDTO.getCollectionCode());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}