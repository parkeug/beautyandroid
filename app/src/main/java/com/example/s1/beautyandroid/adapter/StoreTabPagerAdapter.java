package com.example.s1.beautyandroid.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.s1.beautyandroid.StoreTab;

import java.util.Locale;


/**
 * Created by s1 on 1/18/2017.
 */

public class StoreTabPagerAdapter extends FragmentPagerAdapter {
    public StoreTabPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case 0:
                StoreTab t1 = new StoreTab();
                return t1;
            case 1:
                StoreTab t2 = new StoreTab();
                return t2;
            case 2:
                StoreTab t3 = new StoreTab();
                return t3;

        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }//set the number of tabs

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (position) {
            case 0:
                return "Top stories";
            case 1:

                return "Members";
            case 2:

                return "Setting";
        }
        return null;
    }


}

