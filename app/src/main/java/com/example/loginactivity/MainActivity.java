package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText mEmailEditText;
    private EditText mMobileEditText;
    private Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmailEditText = findViewById(R.id.email_edit_text);
        mMobileEditText = findViewById(R.id.mobile_edit_text);
        mLoginButton = findViewById(R.id.login_button);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmailEditText.getText().toString().trim();
                String mobile = mMobileEditText.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    mEmailEditText.setError("Email is required.");
                    mEmailEditText.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    mEmailEditText.setError("Invalid email format.");
                    mEmailEditText.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(mobile)) {
                    mMobileEditText.setError("Mobile number is required.");
                    mMobileEditText.requestFocus();
                    return;
                }

                if (mobile.length() != 10) {
                    mMobileEditText.setError("Invalid mobile number.");
                    mMobileEditText.requestFocus();
                    return;
                }

                // Validation successful, navigate to next activity
                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                intent.putExtra("email", email);
                intent.putExtra("mobile", mobile);
                startActivity(intent);
                finish();
            }
        });
    }
}
