package com.example.cookingapp.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.cookingapp.Fragment.MonCuaToiFragment;
import com.example.cookingapp.Fragment.MonDaLuuFragment;
import com.example.cookingapp.Fragment.TrangCaNhanFragment;

public class ViewPagerTCNAdapter extends FragmentStateAdapter {
    public ViewPagerTCNAdapter(@NonNull TrangCaNhanFragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new MonDaLuuFragment();
            case 1:
                return new MonCuaToiFragment();
            default:
                return new MonDaLuuFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
