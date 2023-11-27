package com.example.schoolmanagement_01.activity.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.activity.login.SignInActivity;
import com.example.schoolmanagement_01.activity.main.MainActivity;
import com.example.schoolmanagement_01.core.cache.AccountCache;
import com.example.schoolmanagement_01.core.contants.GoogleSheetConstant;
import com.example.schoolmanagement_01.core.dto.AccountDTO;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                nextActivity();
            }
        },2000);
    }

    private void nextActivity() {
//        SharedPreferences accountCache = getSharedPreferences("account",MODE_PRIVATE);
//        String flagLogin = accountCache.getString("isLogin","-1");
//        String role = accountCache.getString("role","");
        AccountDTO accountDTO = AccountCache.getCache(SplashActivity.this);
        String flagLogin = accountDTO.getFlagLogin();
        Intent intent = new Intent();
        if(flagLogin.equals(GoogleSheetConstant.FLAG_NONE_LOGIN)){
            intent = new Intent(SplashActivity.this, SignInActivity.class);
        }else {
            if(GoogleSheetConstant.listRole.contains(accountDTO.getRole())) {
                intent = new Intent(SplashActivity.this, MainActivity.class);
            }else {
                intent = new Intent(SplashActivity.this, SignInActivity.class);
            }
        }
        startActivity(intent);
        finish();
    }
}