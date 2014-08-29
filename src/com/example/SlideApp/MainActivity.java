package com.example.SlideApp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class MainActivity extends FragmentActivity {


    private static final int NUM_PAGES = 2;


    private CustomViewPager mPager;


    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mPager = (CustomViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrolled(int i, float v, int i2) {

            }

            public void onPageSelected(int i) {
                if (i == 1) {
                    findViewById(R.id.view_c).setVisibility(View.VISIBLE);
                }

                if (i == 0) {
                    findViewById(R.id.view_c).setVisibility(View.GONE);
                }
            }

            public void onPageScrollStateChanged(int i) {

            }
        });
    }


    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new FragmentA(mPager);
            }
            if (position == 1) {
                return new FragmentB(mPager);
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        @Override
        public float getPageWidth(int position) {
            if (position == 0) {
                return 0.8f;
            }
            if (position == 1) {
                return 0.67f;
            }
            return 1f;
        }
    }
}
