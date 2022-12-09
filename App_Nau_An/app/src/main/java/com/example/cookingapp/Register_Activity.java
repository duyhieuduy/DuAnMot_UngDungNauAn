package com.example.cookingapp;

import static com.example.cookingapp.CallApi.ApiService.BASE_Service;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cookingapp.CallApi.ApiService;
import com.example.cookingapp.model.Register;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Register_Activity extends AppCompatActivity {
    EditText edtTenDangNhap, edtMatKhau, edtSDT, edtEmail, edtDiaChi, edtTuoi;
    TextView txtAlready;
    Button btnDangKy;
    String tendangnhap, matkhau, diachi, email;
    int tuoi, sdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtAlready = findViewById(R.id.txtAlready);

        edtTenDangNhap = findViewById(R.id.edtTenDangNhap);
        edtMatKhau = findViewById(R.id.edtMatKhau);
        edtSDT = findViewById(R.id.edtSDT);
        edtEmail = findViewById(R.id.edtEmail);
        edtDiaChi = findViewById(R.id.edtDiaChi);
        edtTuoi = findViewById(R.id.edtTuoi);
        btnDangKy = findViewById(R.id.btnDangKy);
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendPosts();
            }
        });
        txtAlready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    private void sendPosts() {
        if (edtTenDangNhap.getText() != null) {
            tendangnhap = edtTenDangNhap.getText().toString();
        }

        if(edtMatKhau.getText().toString() != null){
            matkhau = edtMatKhau.getText().toString();
        }
        if(edtDiaChi.getText().toString() != null){
            diachi = edtDiaChi.getText().toString();

        }
        if(edtEmail.getText().toString()!=  null){
            email = edtEmail.getText().toString();

        }
        if(edtSDT.getText() != null){
            sdt = Integer.parseInt(edtSDT.getText().toString());

        }
        if(edtTuoi.getText() != null){
            tuoi = Integer.parseInt(edtTuoi.getText().toString());

        }

        Register register = new Register(tendangnhap, matkhau, sdt, email, diachi, tuoi);

        ApiService requestInterface = new Retrofit.Builder()
                .baseUrl(BASE_Service)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiService.class);
        new CompositeDisposable().add(requestInterface.sendPost(register)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)
        );
    }

    private void handleResponse(Number number){
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }

    private void handleError(Throwable error){
        Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
    }
}