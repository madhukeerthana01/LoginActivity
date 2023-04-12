package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {

    private TextView TextViewdetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        TextViewdetails = findViewById(R.id.info_text_view);

        String email = getIntent().getStringExtra("email");
        String mobile = getIntent().getStringExtra("mobile");

        String info = "Email: " + email + "\nMobile: " + mobile;

        TextViewdetails.setText(info);
    }
}
