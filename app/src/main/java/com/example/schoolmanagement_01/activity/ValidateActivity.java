package com.example.schoolmanagement_01.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.activity.main.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ValidateActivity extends AppCompatActivity {
    EditText edtInputKey;
    Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validate);
        edtInputKey = findViewById(R.id.edt_input_key);
        btnStart = findViewById(R.id.btn_start);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                firebaseAuth.signInWithEmailAndPassword(edtInputKey.getText().toString().trim()+"@gmail.com", "1234567")
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(getApplicationContext(), "Đăng kí thành công", Toast.LENGTH_LONG).show();
                                    Intent i = new Intent(ValidateActivity.this, MainActivity.class);
                                    startActivity(i);
                                }else {
                                    Toast.makeText(ValidateActivity.this, "Key không đúng \n liên hệ Quản trị viên để nhận Key", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });
    }
}