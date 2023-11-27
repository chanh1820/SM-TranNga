package com.example.schoolmanagement_01.activity.luuvipham;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.activity.luuvipham.adapter.ChooseClassAdapter;
import com.example.schoolmanagement_01.activity.luuvipham.adapter.ChooseKhoiAdapter;
import com.example.schoolmanagement_01.core.contants.DBConstants;
import com.example.schoolmanagement_01.core.dto.ClassRoomDTO;
import com.example.schoolmanagement_01.core.service.UltilService;

import java.util.List;

public class ChooseClassActivity extends AppCompatActivity {
    ListView lvChooseClass;
    Button btnBack;
    Spinner spnKhoi;
    List<ClassRoomDTO> classRoomDTOS = DBConstants.classRoomDTOS;
    ChooseKhoiAdapter chooseKhoiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_class);
        initView();
        action();
    }

    private void initView() {
        lvChooseClass = findViewById(R.id.lv_choose_class_room);
        btnBack = findViewById(R.id.btn_back_choose_class);
        spnKhoi = findViewById(R.id.spn_choose_khoi);
        chooseKhoiAdapter = new ChooseKhoiAdapter(getApplicationContext(), DBConstants.listKhoi);
        spnKhoi.setAdapter(chooseKhoiAdapter);
        spnKhoi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("position",i+"");
                classRoomDTOS = UltilService.fillClassRoomByGroupId(DBConstants.classRoomDTOS, i);
                ChooseClassAdapter arrayAdapter
                        = new ChooseClassAdapter(getApplicationContext(), 0, classRoomDTOS);
                lvChooseClass.setAdapter(arrayAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }

    private void action() {
        lvChooseClass.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ChooseClassActivity.this, SaveReportActivity.class);
                intent.putExtra("class", classRoomDTOS.get(i).getClassName());
                startActivity(intent);
                //Hiển thị tên lớp đã được chọn
                Toast.makeText(ChooseClassActivity.this, "Bạn đã chọn lớp: " + classRoomDTOS.get(i).getClassName(), Toast.LENGTH_SHORT).show();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}