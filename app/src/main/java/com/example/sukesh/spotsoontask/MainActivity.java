package com.example.sukesh.spotsoontask;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    //This is our tablayout
    private TabLayout tabLayout;
    cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager autoScrollViewPager;
    //This is our viewPager
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.video,
            R.drawable.image,
            R.drawable.milestone,
            R.drawable.select_video,
            R.drawable.select_image,
            R.drawable.select_milestone
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initializing the tablayout
        //getActionBar().setTitle("Home");
        autoScrollViewPager = (cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager)findViewById(R.id.view_pager);
        autoScrollViewPager.setAdapter(new SamplePagerAdapter(
                getSupportFragmentManager()));
        autoScrollViewPager.startAutoScroll();
        autoScrollViewPager.setInterval(5000);

        getSupportActionBar().setTitle("HOME");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("Videos"));
        tabLayout.addTab(tabLayout.newTab().setText("Images"));
        tabLayout.addTab(tabLayout.newTab().setText("MileStone"));

        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.pager);

        //Creating our pager adapter
        TabsPagerAdapter adapter = new TabsPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
       // tabLayout.getTabAt(0).setIcon(tabIcons[3]);

        //Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(this);

        setupTabIcons();
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[3]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
        tabLayout.getTabAt(tab.getPosition()).setIcon(tabIcons[tab.getPosition()+3]);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        tabLayout.getTabAt(tab.getPosition()).setIcon(tabIcons[tab.getPosition()]);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    public class SamplePagerAdapter extends FragmentPagerAdapter {

        public SamplePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            /** Show a Fragment based on the position of the current screen */
            if (position == 0) {
                return new SampleFragment();
            }else if (position == 1) {
                return new SampleFragmentTwo();
            } else
                return new SFragment3();
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 3;
        }
    }
}
