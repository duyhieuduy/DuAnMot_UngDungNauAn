package com.example.cookingapp.Fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingapp.Adapter.NguyenLieuAdapter;
import com.example.cookingapp.R;
import com.example.cookingapp.model.Nguyenlieu;

import java.util.ArrayList;
import java.util.List;

public class Home_Fragment extends Fragment {
        RecyclerView recyclerviewHCK;
        ArrayList<Nguyenlieu> list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        recyclerviewHCK = view.findViewById(R.id.recyclviewKCH);
        list = new ArrayList<>();
        list.add(new Nguyenlieu(1,"Thịt Hiếu","https://res.cloudinary.com/doluugxhe/image/upload/v1668265730/Cooking%20app/1_rjnyq8.jpg"));
        list.add(new Nguyenlieu(2,"Thịt Bảo","https://res.cloudinary.com/doluugxhe/image/upload/v1668265730/Cooking%20app/1_rjnyq8.jpg"));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerviewHCK.setLayoutManager(linearLayoutManager);
        NguyenLieuAdapter adapter = new NguyenLieuAdapter(getContext(),list);
        recyclerviewHCK.setAdapter(adapter);

        return view;





    }
}