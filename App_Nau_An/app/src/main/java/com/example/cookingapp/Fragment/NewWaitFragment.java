package com.example.cookingapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingapp.Adapter.FoodinfoAdapter;
import com.example.cookingapp.CTNLActivity;
import com.example.cookingapp.Interface.IFood;
import com.example.cookingapp.R;
import com.example.cookingapp.dao.CongThucNguyenLieuDAO;
import com.example.cookingapp.model.FoodInFor;

import java.util.ArrayList;

public class NewWaitFragment extends Fragment {
    RecyclerView recyclerView;
    CongThucNguyenLieuDAO congThucNguyenLieuDAO;
    ArrayList<FoodInFor> listfood;
    FoodinfoAdapter foodForGetCmt;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycvle_waitng,container,false);
        recyclerView = view.findViewById(R.id.RecyclviewWating);

        reload();


        foodForGetCmt.setiFood(new IFood() {
            @Override
            public void onClickFood(FoodInFor foodInFor) {
              Intent intent = new Intent(getContext(), CTNLActivity.class);
              intent.putExtra("key1",foodInFor.getMamon());
              startActivity(intent);

            }
        });



        return view;

    }
    public void reload(){
        congThucNguyenLieuDAO = new CongThucNguyenLieuDAO(getContext());
        listfood = new ArrayList<>();
        listfood = congThucNguyenLieuDAO.getAll();
        foodForGetCmt = new FoodinfoAdapter(getContext(), listfood);
        GridLayoutManager gridView = new GridLayoutManager(getContext(),1,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(gridView);
        recyclerView.setAdapter(foodForGetCmt);
    }
}
