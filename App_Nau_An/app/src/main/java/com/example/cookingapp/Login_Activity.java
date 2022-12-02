package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Login_Activity extends AppCompatActivity {
    private Context context;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences("tennguoidung",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        setContentView(R.layout.activity_login);
        EditText edtuser = findViewById(R.id.user);
        EditText edtpass = findViewById(R.id.pass);
        Button btnlg = findViewById(R.id.btnlogin);
        ImageView backbtn = findViewById(R.id.backbtn);

        

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_Activity.this,MainActivity.class));
                String user = edtuser.getText().toString();
                editor.putString("tenuser", user);
                editor.apply();
            }
        });
        btnlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_Activity.this,Menu_Activity.class));
                String user = edtuser.getText().toString();
                editor.putString("tenuser", user);
                editor.apply();
            }
        });
    }
}