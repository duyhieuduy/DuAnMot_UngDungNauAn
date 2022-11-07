package com.example.cookingapp.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.cookingapp.Fragment.CacBanBepFragment;
import com.example.cookingapp.Fragment.Home_Fragment;
import com.example.cookingapp.Fragment.KhoCamHungFragment;

public class ViewPagerHomeAdapter extends FragmentStateAdapter {
    public ViewPagerHomeAdapter(@NonNull Home_Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new CacBanBepFragment();
            case 1:
                return new KhoCamHungFragment();
            default:
                return new CacBanBepFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
