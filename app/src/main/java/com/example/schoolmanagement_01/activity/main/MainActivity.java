package com.example.schoolmanagement_01.activity.main;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.activity.bangtongket.SummaryBoardActivity;
import com.example.schoolmanagement_01.activity.danhsachvipham.ReportActivity;
import com.example.schoolmanagement_01.activity.login.SignInActivity;
import com.example.schoolmanagement_01.activity.luudiemtiethoc.SavePointActivity;
import com.example.schoolmanagement_01.activity.luuvipham.ChooseClassActivity;
import com.example.schoolmanagement_01.activity.luuvipham.SaveReportActivity;
import com.example.schoolmanagement_01.core.DBHelper;
import com.example.schoolmanagement_01.core.cache.AccountCache;
import com.example.schoolmanagement_01.core.contants.DBConstants;
import com.example.schoolmanagement_01.core.contants.GoogleSheetConstant;
import com.example.schoolmanagement_01.core.dao.GeneralDAO;
import com.example.schoolmanagement_01.core.dto.AccountDTO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnQuanLyTrucNhat, btnDanhSachViPham, btnXepLoaiTietHoc, btnBangTongKet;
    TextClock textClock;
    ImageView btnLogOut;
    TextView edtInputStaff;
    ImageButton imvSettings;
    Spinner spnChooseWeek, spnChooseYear;
    ChooseWeekAdapter chooseWeekAdapter;
    ChooseYearAdapter chooseYearAdapter;
    ChooseSeesionAdapter chooseSeesionAdapter;
    ChooseSettingsAdapter chooseSettingsAdapter;
    List<String> listWeek = DBConstants.listWeek;
    SharedPreferences weekSPr, yearSPr;
    List<String> listYear = DBConstants.listYear;
    List<String> listSession = DBConstants.listSession;

    GeneralDAO generalDAO;
    AccountDTO accountDTO = new AccountDTO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebase();
        weekSPr = getSharedPreferences("week",MODE_PRIVATE);
        yearSPr = getSharedPreferences("year",MODE_PRIVATE);
        initView();
        action();

    }

    private void firebase() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword("sm_trannga_2"+"@gmail.com", "123456")
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                        }else {
                            Toast.makeText(getApplicationContext(), "Phiên bản hết hạn \n Vui lòng liên hệ nhà phát triển", Toast.LENGTH_LONG).show();
                        finish();

                        }
                    }
                });
    }

    private void action() {
        btnQuanLyTrucNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(accountDTO.getRole().equals(GoogleSheetConstant.ROLE_CO_DO) && !isAvailableClass(accountDTO.getClassRoom())){
                    return;
                }
                Intent i = new Intent();
                if(accountDTO.getRole().equals(GoogleSheetConstant.ROLE_CO_DO)){
                    i = new Intent(MainActivity.this, SaveReportActivity.class);
                    i.putExtra("class",accountDTO.getClassRoom());

                }else {
                    i = new Intent(MainActivity.this, ChooseClassActivity.class);
                }
                startActivity(i);
            }
        });
        btnDanhSachViPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ReportActivity.class);
                if(accountDTO.getRole().equals(GoogleSheetConstant.ROLE_CO_DO)){
                    i.putExtra("class",accountDTO.getClassRoom());
                }else {
                    i.putExtra("class","");
                }
                startActivity(i);
            }
        });
        btnXepLoaiTietHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(accountDTO.getRole().equals(GoogleSheetConstant.ROLE_CO_DO) && !isAvailableClass(accountDTO.getClassRoom())){
                    return;
                }
                Intent i =  new Intent(MainActivity.this, SavePointActivity.class);
                if(accountDTO.getRole().equals(GoogleSheetConstant.ROLE_CO_DO)){
                    i.putExtra("class",accountDTO.getClassRoom());
                }else {
                    i.putExtra("class","");
                }
                startActivity(i);
            }
        });
        btnBangTongKet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_choose_session);
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().setAttributes(lp);

                dialog.show();

                chooseSeesionAdapter = new ChooseSeesionAdapter(listSession, getApplicationContext());
                GridView gvListSession = dialog.findViewById(R.id.gv_list_session);
                gvListSession.setAdapter(chooseSeesionAdapter);
                gvListSession.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(MainActivity.this, SummaryBoardActivity.class);
                        intent.putExtra("session", position);
                        startActivity(intent);
                    }
                });
            }
        });
        edtInputStaff.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                SharedPreferences.Editor week = weekSPr.edit();
                week.putString("staff_name",edtInputStaff.getText().toString().trim());
                week.commit();
                SharedPreferences.Editor year = yearSPr.edit();
                year.putString("staff_name",edtInputStaff.getText().toString().trim());
                year.commit();
            }
        });
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
//        imvSettings.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Dialog dialog = new Dialog(MainActivity.this);
//                dialog.setContentView(R.layout.dialog_setting);
//                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
//                lp.copyFrom(dialog.getWindow().getAttributes());
//                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
//                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.getWindow().setAttributes(lp);
//
//                dialog.show();
//
//                chooseSettingsAdapter = new ChooseSettingsAdapter(DBConstants.listSettingDTO, getApplicationContext());
//                GridView gvListSession = dialog.findViewById(R.id.gv_list_session);
//                gvListSession.setAdapter(chooseSettingsAdapter);
//                gvListSession.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        showDialog();
//                    }
//                });
//            }
//        });
    }



    private void initView() {
        DBHelper db = new DBHelper(this);
        try {
            db.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        generalDAO = new GeneralDAO(getApplicationContext());
        accountDTO = AccountCache.getCache(MainActivity.this);
        btnQuanLyTrucNhat = findViewById(R.id.btn_quan_ly_truc_nhat);
        btnDanhSachViPham = findViewById(R.id.btn_danh_sach_vi_pham);
        btnXepLoaiTietHoc = findViewById(R.id.btn_xep_loai_tiet_hoc);
        btnBangTongKet = findViewById(R.id.btn_bang_tong_ket);
        edtInputStaff = findViewById(R.id.edt_input_staff);
        StringBuilder staffInfo = new StringBuilder(accountDTO.getDisplayName());
        if(StringUtils.isNotBlank(accountDTO.getClassRoom())){
            staffInfo.append(" - ");
            staffInfo.append(accountDTO.getClassRoom());
        }
        if(accountDTO.getRole().equals(GoogleSheetConstant.ROLE_GIAO_VIEN)){
            btnQuanLyTrucNhat.setVisibility(View.GONE);
            btnXepLoaiTietHoc.setVisibility(View.GONE);
        }
        edtInputStaff.setText( staffInfo.toString());
//        edtInputStaff.setFocusable(false);
//        textClock = findViewById(R.id.textclock);
        imvSettings = findViewById(R.id.imv_settings);
        btnLogOut = findViewById(R.id.btn_log_out);
        spnChooseWeek = findViewById(R.id.spn_choose_week);
        spnChooseYear = findViewById(R.id.spn_choose_year);
        String formatdate = "E, d-M-yyyy k:m:sa";
//        textClock.setFormat12Hour(formatdate);
//        textClock.setFormat24Hour(formatdate);
        chooseWeekAdapter = new ChooseWeekAdapter(getApplicationContext(), listWeek);
        spnChooseWeek.setAdapter(chooseWeekAdapter);
        spnChooseWeek.setSelection(Integer.parseInt(weekSPr.getString("position", 0+"")));
        spnChooseWeek.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SharedPreferences.Editor week = weekSPr.edit();
                week.putString("week", listWeek.get(i));
                week.putString("position",String.valueOf(i));
                week.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        chooseYearAdapter = new ChooseYearAdapter(getApplicationContext(),listYear);
        spnChooseYear.setAdapter(chooseYearAdapter);
        spnChooseYear.setSelection(Integer.parseInt(yearSPr.getString("position", 0+"")));
        spnChooseYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SharedPreferences.Editor year = yearSPr.edit();
                year.putString("year", listYear.get(i));
                year.putString("position",String.valueOf(i));
                year.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });






    }
    void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.drawable.exit);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có muốn thoát hay không ?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                AccountCache.removeCache(MainActivity.this);
                finish();
                Intent i = new Intent(getApplicationContext(), SignInActivity.class);
                startActivity(i);
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
    private boolean isAvailableClass(String classRoom) {
        List<String> classRoomList = generalDAO.getClassRoomList();
        if(classRoomList.contains(classRoom)){
            return true;
        }else {
            Toast.makeText(getApplicationContext(), "Lớp " + classRoom + " không hợp lệ", Toast.LENGTH_LONG).show();
            return false;
        }
    }
}