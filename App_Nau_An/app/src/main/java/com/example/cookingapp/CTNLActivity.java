package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cookingapp.dao.GetAllDAO;
import com.example.cookingapp.model.FooddetailModel;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class CTNLActivity extends AppCompatActivity {
    GetAllDAO congThucNguyenLieuDAO;
    ArrayList<FooddetailModel>  list ;
    TextView MOXT,GT,textTG,TenNL,TennL1,TennL2,clNl,ctcl;
    ImageView imgCTNL,linea,DH,linea1,imgconmuc,imgmang,imgclam,imgcl1,imgcl2,imgcl3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ctnl);
        list = new ArrayList<>();
        congThucNguyenLieuDAO = new GetAllDAO(this);
        Intent intent = getIntent();
        int id = intent.getIntExtra("key1",0);
        list = congThucNguyenLieuDAO.getClickItemIDmon(id);

        imgCTNL = findViewById(R.id.imgCTNL);

//        textTenMon = findViewById(R.id.tenmon);
//        MOXT = findViewById(R.id.MOXT);
//        GT = findViewById(R.id.GT);
//        textctl = findViewById(R.id.Congthuclam);
//        textcl = findViewById(R.id.cachlam);
//
//        Picasso.get().load(list.get(0).getAnhmon()).
//                into(imgAnhMon);
//
//        textTenMon.setText(list.get(0).getTenmon());
//        textctl.setText(list.get(0).getCongthuclam());
//        textcl.setText(list.get(0).getCachlam());
//
//        Log.d("testtt",list.get(0).getAnhmon());









    }
}