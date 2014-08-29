package com.example.SlideApp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class FragmentB extends Fragment {
    private CustomViewPager pager;

    public FragmentB(CustomViewPager pager) {
        this.pager = pager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_B, container, false);

        rootView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                pager.setPagingEnabled(true);
                return true;
            }
        });

        return rootView;
    }
}
