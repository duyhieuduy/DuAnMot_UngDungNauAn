package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TDTTuser extends AppCompatActivity {
    EditText edtTenDangNhap, edtMatKhau, edtSDT, edtEmail, edtDiaChi, edtTuoi;
    TextView txtAlready;
    Button btnDangKy;
    String tendangnhap, matkhau, diachi, email;
    int tuoi, sdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdttuser);
        sendPosts();



        txtAlready = findViewById(R.id.txtAlready);
        edtTenDangNhap = findViewById(R.id.edtTenDangNhap);
        edtMatKhau = findViewById(R.id.edtMatKhau);
        edtSDT = findViewById(R.id.edtSDT);
        edtEmail = findViewById(R.id.edtEmail);
        edtDiaChi = findViewById(R.id.edtDiaChi);
        edtTuoi = findViewById(R.id.edtTuoi);
        btnDangKy = findViewById(R.id.btnDangKy);
    }


    private void sendPosts() {
        if (edtTenDangNhap.getText() != null) {
            tendangnhap = edtTenDangNhap.getText().toString();
        }

        if (edtMatKhau.getText().toString() != null) {
            matkhau = edtMatKhau.getText().toString();
        }
        if (edtDiaChi.getText().toString() != null) {
            diachi = edtDiaChi.getText().toString();

        }
        if (edtEmail.getText().toString() != null) {
            email = edtEmail.getText().toString();

        }
        if (edtSDT.getText() != null) {
            sdt = Integer.parseInt(edtSDT.getText().toString());

        }
        if (edtTuoi.getText() != null) {
            tuoi = Integer.parseInt(edtTuoi.getText().toString());

        }
    }
}