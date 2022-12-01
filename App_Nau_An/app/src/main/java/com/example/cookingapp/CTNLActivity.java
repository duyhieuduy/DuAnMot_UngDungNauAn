package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cookingapp.dao.CongThucNguyenLieuDAO;
import com.example.cookingapp.model.FooddetailModel;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class CTNLActivity extends AppCompatActivity {
    CongThucNguyenLieuDAO congThucNguyenLieuDAO;
    ArrayList<FooddetailModel>  list ;
    TextView textTenMon,textctl,textcl;
    ImageView imgAnhMon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ctnl);
        list = new ArrayList<>();
        congThucNguyenLieuDAO = new CongThucNguyenLieuDAO(this);
        Intent intent = getIntent();
        int id = intent.getIntExtra("key1",0);
        list = congThucNguyenLieuDAO.getClickItemIDmon(id);

        Log.d("tesstt","id= "+id+"anhmon= "+list.get(0).getAnhmon());

        imgAnhMon = findViewById(R.id.imgAnhMon);

        textTenMon = findViewById(R.id.tenmon);
        textctl = findViewById(R.id.Congthuclam);
        textcl = findViewById(R.id.cachlam);

        Picasso.get().load(list.get(0).getAnhmon()).
                into(imgAnhMon);

        textTenMon.setText(list.get(0).getTenmon());
        textctl.setText(list.get(0).getCongthuclam());
        textcl.setText(list.get(0).getCachlam());

        Log.d("testtt",list.get(0).getAnhmon());









    }
}