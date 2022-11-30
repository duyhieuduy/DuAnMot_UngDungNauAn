package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.cookingapp.DB.DBHelper;
import com.example.cookingapp.dao.CongThucNguyenLieuDAO;
import com.example.cookingapp.model.BinhLuan;
import com.example.cookingapp.model.CLAnhMonAn;
import com.example.cookingapp.model.FooddetailModel;

import java.util.ArrayList;

public class CTNLActivity extends AppCompatActivity {
    CongThucNguyenLieuDAO congThucNguyenLieuDAO;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ctnl);

        congThucNguyenLieuDAO = new CongThucNguyenLieuDAO(this);
        Intent intent = getIntent();
        int id = intent.getIntExtra("key1",0);
        congThucNguyenLieuDAO.getClickItemIDmon(id);



    }
}