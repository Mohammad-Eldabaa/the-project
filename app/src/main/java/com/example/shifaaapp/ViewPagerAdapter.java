package com.example.shifaaapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new parcher_fragment();
            case 1:
                return new homeFragment();
            case 2:
                return new setting_fragment();
            // Add more cases for additional fragments
            default:
                return new homeFragment();
        }
    }

    @Override
    public int getItemCount() {
        // Return the number of fragments
        return 3;
    }
}
