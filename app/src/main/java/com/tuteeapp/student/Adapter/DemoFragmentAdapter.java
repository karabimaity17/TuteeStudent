package com.tuteeapp.student.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.tuteeapp.student.Fragment.AllFragment;

public class DemoFragmentAdapter extends FragmentStatePagerAdapter {


    public DemoFragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment f = null;

        if (position == 0) {
            f = new AllFragment();
        }
        if (position == 1) {
            f = new AllFragment();
        }
        if (position == 2) {
            f = new AllFragment();
        }
        if (position == 3) {
            f = new AllFragment();
        }
        if (position == 4) {
            f = new AllFragment();
        }
        return f;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
