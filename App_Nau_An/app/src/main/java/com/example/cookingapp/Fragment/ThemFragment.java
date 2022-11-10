package com.example.cookingapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.cookingapp.MonCuaToiActivity;
import com.example.cookingapp.MonDaLuuActivity;
import com.example.cookingapp.R;

public class ThemFragment extends Fragment {
    Button btnMonCuaToi, btnMonDaLuu;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.them_fragment, container, false);
        btnMonCuaToi = view.findViewById(R.id.btnMonCuaToi);
        btnMonDaLuu = view.findViewById(R.id.btnMonDaLuu);

        btnMonCuaToi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MonCuaToiActivity.class);
                startActivity(intent);
            }
        });
        btnMonDaLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MonDaLuuActivity.class);
                startActivity(intent);
            }
        });
        return view;


    }
}
