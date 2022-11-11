package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class VerifyEnterOtp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_enter_otp);

        getDataIntent();
        setTitleToolbar();
    }

    private void getDataIntent(){
        String strPhoneNumber = getIntent().getStringExtra("phone_number");
        TextView tvUserinfo = findViewById(R.id.tv_user);
        tvUserinfo.setText(strPhoneNumber);
    }

    private void setTitleToolbar() {
        if (getSupportActionBar() !=null){
            getSupportActionBar().setTitle("VerifyEnterOtp");
        }
    }

}