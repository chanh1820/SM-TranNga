package com.example.schoolmanagement_01.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
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
import com.example.schoolmanagement_01.activity.main.MainActivity;
import com.example.schoolmanagement_01.core.cache.AccountCache;
import com.example.schoolmanagement_01.core.contants.GoogleSheetConstant;
import com.example.schoolmanagement_01.core.dto.AccountDTO;
import com.example.schoolmanagement_01.core.dto.ResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SignInActivity extends AppCompatActivity {
    Button btnLogin;
    EditText edtUserName, edtPassWord;
    ProgressBar pgMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        initView();
        action();
    }

    private void initView() {
        btnLogin = findViewById(R.id.btn_login);
        edtUserName = findViewById(R.id.edt_user_name);
        edtPassWord = findViewById(R.id.edt_pass_word);
        pgMain = findViewById(R.id.pg_main);

    }
    private void action() {

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLogin.setClickable(false);
                btnLogin.setEnabled(false);
                pgMain.setVisibility(View.VISIBLE);
                String useName = edtUserName.getText().toString().trim();
                String passWord = edtPassWord.getText().toString().trim();
                if (!useName.isEmpty() || !passWord.isEmpty()) {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, GoogleSheetConstant.END_POINT_URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("response",response);
                            pgMain.setVisibility(View.INVISIBLE);

                            ObjectMapper objectMapper = new ObjectMapper();
                            try {
                                ResponseDTO responseDTO = objectMapper.readValue(response, ResponseDTO.class);
                                if(responseDTO.getStatus().equals(GoogleSheetConstant.STATUS_SUCCESS)){
                                    AccountDTO accountDTO = objectMapper.readValue(responseDTO.getData(), AccountDTO.class);
                                    if (GoogleSheetConstant.listRole.contains(accountDTO.getRole())){
                                        AccountCache.setCache(SignInActivity.this,accountDTO );
                                        startActivity(new Intent(SignInActivity.this, MainActivity.class));
                                        finish();
                                    }
                                }else {
                                    Toast.makeText(getApplicationContext(),GoogleSheetConstant.mapResponseStatus.get(responseDTO.getStatus()), Toast.LENGTH_LONG).show();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            btnLogin.setClickable(true);
                            btnLogin.setEnabled(true);
                            pgMain.setVisibility(View.INVISIBLE);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            btnLogin.setClickable(true);
                            btnLogin.setEnabled(true);
                            Toast.makeText(getApplicationContext(), "Bạn chưa bật kết nối Internet ?", Toast.LENGTH_SHORT).show();
                            pgMain.setVisibility(View.INVISIBLE);
                        }
                    }) {
                        @Nullable
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            params.put("action", "LOGIN");
                            params.put("userName", useName);
                            params.put("passWord", passWord);
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
                } else {
                    btnLogin.setClickable(true);
                    btnLogin.setEnabled(true);
                    pgMain.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), "Thông tin đăng nhập chưa đầy đủ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}