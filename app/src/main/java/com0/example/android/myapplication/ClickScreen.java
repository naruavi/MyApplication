package com0.example.android.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ClickScreen extends FragmentPagerAdapter {

    private int numOfTabs;

    ClickScreen(FragmentManager fragmentManager, int numOfTabs){
        super(fragmentManager);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new LivingRoomFragment();
            case 1:
                return new KitchenFragment();
            case 2:
                return new BedroomFragment();
            case 3:
                return new BedroomFragment();
            case 4:
                return new BedroomFragment();
            default:
                return new LivingRoomFragment();
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
