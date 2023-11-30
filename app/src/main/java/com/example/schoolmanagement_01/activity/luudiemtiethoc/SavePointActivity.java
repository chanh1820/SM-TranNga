package com.example.schoolmanagement_01.activity.luudiemtiethoc;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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
import com.example.schoolmanagement_01.core.contants.DBConstants;
import com.example.schoolmanagement_01.core.contants.GoogleSheetConstant;
import com.example.schoolmanagement_01.core.dao.GeneralDAO;
import com.example.schoolmanagement_01.core.dto.BonusPointDTO;
import com.example.schoolmanagement_01.core.dto.PointDTO;
import com.example.schoolmanagement_01.core.dto.ResponseDTO;
import com.example.schoolmanagement_01.core.service.UltilService;
import com.example.schoolmanagement_01.core.util.TransformerUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SavePointActivity extends AppCompatActivity {
    Button btnSavePoint, btnDelete, btnBack;
    Spinner spnChooseClassRoomAddPoint,spnChooseWeekAddPoint;
    EditText edtTietTot, edtTietKha, edtTietTB,edtTietYeu, edtDiemCong;
    PointDTO pointDTO = new PointDTO();
    List<String> listWeek = DBConstants.listWeek;
    List<String> listClassRoom = DBConstants.listClassRoom;
    GeneralDAO generalDAO ;
    ChooseWeekAddPointAdapter chooseWeekAddPointAdapter;
    ChooseClassRoomAdapter chooseClassRoomAdapter;
    SharedPreferences sharedPreferences;
    String position = "1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_point);
        sharedPreferences = getSharedPreferences("week",MODE_PRIVATE);
        position = sharedPreferences.getString("position", "0");
        intiView();
        action();
    }

    private void action() {
        btnSavePoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<BonusPointDTO> bonusPointDTOList = new ArrayList<>();
                String pointTot = UltilService.exportNumberToString(edtTietTot.getText().toString().trim());
                String pointKha = UltilService.exportNumberToString(edtTietKha.getText().toString().trim());
                String pointTB= UltilService.exportNumberToString(edtTietTB.getText().toString().trim());
                String pointYeu= UltilService.exportNumberToString(edtTietYeu.getText().toString().trim());
                String diemCong = UltilService.exportNumberToString(edtDiemCong.getText().toString().trim());

                if(UltilService.isNumeric(pointTot)
                    && UltilService.isNumeric(pointKha)
                    && UltilService.isNumeric(pointTB)
                    && UltilService.isNumeric(pointYeu)
                    && UltilService.isNumeric(diemCong)
                ){

                    pointDTO.setTietTot(Integer.valueOf(pointTot));
                    pointDTO.setTietKha(Integer.valueOf(pointKha));
                    pointDTO.setTietTrungBinh(Integer.valueOf(pointTB));
                    pointDTO.setTietYeu(Integer.valueOf(pointYeu));
                    pointDTO.setDiemCong(Integer.valueOf(diemCong));

                    btnSavePoint.setEnabled(true);
                    btnSavePoint.setClickable(true);
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
                                btnSavePoint.setEnabled(true);
                                btnSavePoint.setClickable(true);
                            } catch (IOException e) {
                                btnSavePoint.setEnabled(true);
                                btnSavePoint.setClickable(true);
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            btnSavePoint.setEnabled(true);
                            btnSavePoint.setClickable(true);
                            Toast.makeText(getApplicationContext(), "Bạn chưa bật kết nối Internet ?", Toast.LENGTH_SHORT).show();
                        }
                    }) {
                        @Nullable
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            pointDTO.setId(0);
                            return TransformerUtils.dtoToPayload(pointDTO, GoogleSheetConstant.ACTION_SAVE_POINT);
                        }
                    };

                    RetryPolicy retryPolicy = new DefaultRetryPolicy(
                            50000,
                            0,
                            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                    stringRequest.setRetryPolicy(retryPolicy);
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);
                }else {
                    Toast.makeText(getApplicationContext(), "Xin mời nhập số", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("sa","as");
                generalDAO.clearPointByWeekAndClass(pointDTO.getWeek(),pointDTO.getClassRoom());
            Toast.makeText(getApplicationContext(),"Xóa thành công",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void intiView() {
        generalDAO = new GeneralDAO(getApplicationContext());
        btnSavePoint = findViewById(R.id.btn_save_point);
        spnChooseWeekAddPoint = findViewById(R.id.spn_choose_week_add_point);
        spnChooseClassRoomAddPoint = findViewById(R.id.spn_choose_class_room_add_point);
        edtTietTot = findViewById(R.id.edt_save_point_tiet_tot);
        edtTietKha = findViewById(R.id.edt_save_point_tiet_kha);
        edtTietTB = findViewById(R.id.edt_save_point_tiet_trung_binh);
        edtTietYeu = findViewById(R.id.edt_save_point_tiet_yeu);
        edtDiemCong = findViewById(R.id.edt_save_point_diem_cong);
        btnBack = findViewById(R.id.btn_back_add_point);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnDelete = findViewById(R.id.btn_clear_point_current);
        chooseWeekAddPointAdapter
                = new ChooseWeekAddPointAdapter(getApplicationContext(),listWeek);
        spnChooseWeekAddPoint.setAdapter(chooseWeekAddPointAdapter);
        spnChooseWeekAddPoint.setSelection(Integer.parseInt(position));
        spnChooseWeekAddPoint.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pointDTO.setWeek(listWeek.get(i));
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
        chooseClassRoomAdapter
                = new ChooseClassRoomAdapter(getApplicationContext(),listClassRoom);
        spnChooseClassRoomAddPoint.setAdapter(chooseClassRoomAdapter);
        spnChooseClassRoomAddPoint.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pointDTO.setClassRoom(listClassRoom.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}