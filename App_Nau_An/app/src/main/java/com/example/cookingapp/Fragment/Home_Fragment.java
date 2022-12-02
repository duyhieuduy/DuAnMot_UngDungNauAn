package com.example.cookingapp.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingapp.Adapter.NewNguyenlieuAdapter;
import com.example.cookingapp.Adapter.NguyenLieuAdapter;
import com.example.cookingapp.Interface.INguyenLieu;
import com.example.cookingapp.R;
import com.example.cookingapp.model.NewNguyenLieu;
import com.example.cookingapp.model.NguyenLieu;
import com.example.cookingapp.dao.dao;

import java.util.ArrayList;

import java.util.ArrayList;


public class Home_Fragment extends Fragment {
        RecyclerView recyclerviewHCK;
        RecyclerView recyclerviewnewHCK;
        ArrayList<NguyenLieu> list;
        ArrayList<NewNguyenLieu> listnew;
        dao daoz;

    NguyenLieuAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        RecyclerView recyclerMonAn = view.findViewById(R.id.recyclerMonAn);
        recyclerviewHCK = view.findViewById(R.id.recyclviewKCH);
        recyclerviewnewHCK = view.findViewById(R.id.recyclviewnewKCH);
        list = new ArrayList<>();
        listnew = new ArrayList<>();

        list.add(new NguyenLieu(1,"Thịt Hiếu","https://res.cloudinary.com/doluugxhe/image/upload/v1668265730/Cooking%20app/1_rjnyq8.jpg"));
        list.add(new NguyenLieu(2,"Thịt Bảo","https://res.cloudinary.com/doluugxhe/image/upload/v1668265730/Cooking%20app/1_rjnyq8.jpg"));
        list.add(new NguyenLieu(3,"Thịt Bảo","https://res.cloudinary.com/doluugxhe/image/upload/v1668265730/Cooking%20app/1_rjnyq8.jpg"));
        list.add(new NguyenLieu(4,"Thịt Bảo","https://res.cloudinary.com/doluugxhe/image/upload/v1668265730/Cooking%20app/1_rjnyq8.jpg"));
        list.add(new NguyenLieu(5,"Thịt Bảo","https://res.cloudinary.com/doluugxhe/image/upload/v1668265730/Cooking%20app/1_rjnyq8.jpg"));
        list.add(new NguyenLieu(6,"Thịt Bảo","https://res.cloudinary.com/doluugxhe/image/upload/v1668265730/Cooking%20app/1_rjnyq8.jpg"));
        list.add(new NguyenLieu(7,"Thịt Bảo","https://res.cloudinary.com/doluugxhe/image/upload/v1668265730/Cooking%20app/1_rjnyq8.jpg"));
        list.add(new NguyenLieu(8,"Thịt Bảo","https://res.cloudinary.com/doluugxhe/image/upload/v1668265730/Cooking%20app/1_rjnyq8.jpg"));
        list.add(new NguyenLieu(9,"Thịt Bảo","https://res.cloudinary.com/doluugxhe/image/upload/v1668265730/Cooking%20app/1_rjnyq8.jpg"));
        list.add(new NguyenLieu(10,"Thịt Bảo","https://res.cloudinary.com/doluugxhe/image/upload/v1668265730/Cooking%20app/1_rjnyq8.jpg"));
        listnew.add(new NewNguyenLieu(10,"Thịt Bảo","https://res.cloudinary.com/doluugxhe/image/upload/v1668265730/Cooking%20app/1_rjnyq8.jpg"));


        loadDataNewnl();
        adapter = new NguyenLieuAdapter(getContext(), list);
        GridLayoutManager gridView = new GridLayoutManager(getContext(),2,RecyclerView.HORIZONTAL,false);
        recyclerviewHCK.setLayoutManager(gridView);
        recyclerviewHCK.setAdapter(adapter);

        adapter.setiNguyenLieu(new INguyenLieu() {
            @Override
            public void onClick(NguyenLieu nguyenLieu) {
                dao daoz = new dao(getContext());
                daoz.insert(nguyenLieu.getManguyenlieu(),nguyenLieu.getTennguyenlieu(), nguyenLieu.getAnhnguyenlieu());
                loadDataNewnl();
            }
        });


        Button btn = view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, new WaitFragment(), null);
                fragmentTransaction.commit();
            }
        });




        return view;
    }

    private void loadDataNewnl(){
        listnew.clear();
        daoz = new dao(getContext());
        dao daoz = new dao(getActivity());
        listnew = daoz.getall();
        LinearLayoutManager linearLayoutManagera = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerviewnewHCK.setLayoutManager(linearLayoutManagera);
        NewNguyenlieuAdapter adaptera = new NewNguyenlieuAdapter(getContext(),listnew);
        recyclerviewnewHCK.setAdapter(adaptera);
    }



}