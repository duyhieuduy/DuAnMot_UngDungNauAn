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
import com.example.cookingapp.ThemMonMoiActivity;

public class ThemFragment extends Fragment {
    Button btnMonCuaToi, btnMonDaLuu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.them_fragment, container, false);

        Button btnThemMonMoi = view.findViewById(R.id.btnThemMonMoi);

        btnThemMonMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ThemMonMoiActivity.class));
            }
        });


        return view;


    }
}
