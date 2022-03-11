package com.example.shayari.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.shayari.fragment.FirstFragment;
import com.example.shayari.fragment.SecondFragment;

public class viewpager_fragment_adapter extends FragmentPagerAdapter {

    public viewpager_fragment_adapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            default:
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            default:
            case 0:
                return "first";
            case 1:
                return "second";
        }
    }
}
