package com.example.sukesh.spotsoontask;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Sukesh on 7/19/2017.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {
    int tabcount;
    String tabTitles[]={"Videos","Images","MileStone"};


    public TabsPagerAdapter(FragmentManager fm,int tabcount) {
        super(fm);
        this.tabcount = tabcount;
    }

    @Override
    public Fragment getItem(int index) {
        switch (index) {
            case 0:
                // Top Rated fragment activity
                return new VideosFragment();
            case 1:
                // Games fragment activity
                return new ImagesFragment();
            case 2:
                // Movies fragment activity
                return new MileStoneFragment();
        }

        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }


    @Override
    public int getCount() {
        return tabcount;
    }
}
