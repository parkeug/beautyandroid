package com.example.s1.beautyandroid.adapter;

/**
 * Created by s1 on 1/18/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.s1.beautyandroid.PageFragment;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] pageTitle = {
            "Page1", "Page2", "Page3"
    };

    public MyFragmentPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putString("pageIndex", Integer.toString(position + 1));
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public int getCount() {
        return pageTitle.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitle[position];
    }

}