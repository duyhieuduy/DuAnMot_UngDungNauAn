package com.example.cookingapp.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.cookingapp.Fragment.Fragtest;
import com.example.cookingapp.Fragment.Home_Fragment;

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
                return new Fragtest();
            case 2:
                return new Home_Fragment();
            case 3:
                return new Home_Fragment();
            case 4:
                return new Home_Fragment();
            default:
                return new Home_Fragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
