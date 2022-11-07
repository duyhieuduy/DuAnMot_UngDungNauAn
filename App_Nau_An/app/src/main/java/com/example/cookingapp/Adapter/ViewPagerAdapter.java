package com.example.cookingapp.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.cookingapp.Fragment.Home_Fragment;
import com.example.cookingapp.Fragment.TrangCaNhanFragment;
import com.example.cookingapp.Fragment.SeachFragment;
import com.example.cookingapp.Fragment.ThemFragment;
import com.example.cookingapp.Fragment.TuongTacFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Home_Fragment();
            case 1:
                return new SeachFragment();
            case 2:
                return new ThemFragment();
            case 3:
                return new TuongTacFragment();
            case 4:
                return new TrangCaNhanFragment();
            default:
                return new Home_Fragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
