package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cookingapp.dao.GetAllDAO;
import com.example.cookingapp.model.CLAnhMonAn;
import com.example.cookingapp.model.FooddetailModel;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class CTNLActivity extends AppCompatActivity {
    GetAllDAO congThucNguyenLieuDAO;
    ArrayList<FooddetailModel>  list ;
    TextView MOXT,GT,textTG,TennL1,TennL2,clNl,ctcl;
    ImageView imgCTNL,imgcl1,imgcl2,imgcl3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ctnl);
        list = new ArrayList<>();
        congThucNguyenLieuDAO = new GetAllDAO(this);
        Intent intent = getIntent();
        int id = intent.getIntExtra("key1",0);
        list = congThucNguyenLieuDAO.getClickItemIDmon(id);
        ArrayList<CLAnhMonAn> listama = new ArrayList<>();
        listama = congThucNguyenLieuDAO.getClickItemanh(id);

        imgCTNL = findViewById(R.id.imgCTNL);
        imgcl1 = findViewById(R.id.imgcl1);
        imgcl2 = findViewById(R.id.imgcl2);
        imgcl3 = findViewById(R.id.imgcl3);


        MOXT = findViewById(R.id.MOXT);

        GT = findViewById(R.id.GT);

        textTG = findViewById(R.id.textTG);
        TennL1 = findViewById(R.id.TennL1);
        TennL2 = findViewById(R.id.TennL2);
        clNl = findViewById(R.id.clNl);
        ctcl = findViewById(R.id.ctcl);


        Picasso.get().load(list.get(0).getAnhmon()).
               into(imgCTNL);
        Picasso.get().load(listama.get(0).getAnhmonan()).
                into(imgcl1);
        Picasso.get().load(listama.get(1).getAnhmonan()).
                into(imgcl2);
        Picasso.get().load(listama.get(2).getAnhmonan()).
                into(imgcl3);
          MOXT.setText(list.get(0).getTenmon());
         ctcl.setText(list.get(0).getCongthuclam());
         clNl.setText(list.get(0).getCachlam());









    }
}