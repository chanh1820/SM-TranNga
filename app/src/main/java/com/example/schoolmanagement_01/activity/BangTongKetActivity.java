package com.example.schoolmanagement_01.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.schoolmanagement_01.R;

public class BangTongKetActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bang_tong_ket);

        // Ánh xạ view
        editText = findViewById(R.id.edit_text);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.text_view);

        // Xử lý
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // hành động sẽ xảy ra nếu click

                //1. lấy giá trị edittext
                String text = editText.getText().toString();

                //2. gán cho textview để hiển thị ra
                textView.setText(text);

            }
        });


    }
}