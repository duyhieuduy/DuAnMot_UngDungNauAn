package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MonCuaToiActivity extends AppCompatActivity {
    Button btnThem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_cua_toi);
        btnThem = findViewById(R.id.btnThemMon);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    
            }
        });
    }
}