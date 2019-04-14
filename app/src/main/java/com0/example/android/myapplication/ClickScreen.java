package com0.example.android.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

public class ClickScreen extends FragmentPagerAdapter {

    private int numOfTabs;
    private int livingtab;
    private int bedtabs;
    private int kitchentabs;

    ClickScreen(FragmentManager fragmentManager, int numOfTabs, int ltab, int btab, int ktab){
        super(fragmentManager);
        this.numOfTabs = numOfTabs;
        this.livingtab = ltab;
        this.bedtabs = btab;
        this.kitchentabs = ktab;
        Log.d("Click ","this are all tabs " + ltab + " " + btab + " " + ktab );
    }

    @Override
    public Fragment getItem(int position) {
        if (position>=0 && position<livingtab){
            //Log.d("MainModel","value of position in click " + position);
            return BedroomFragment.newInstance( "Living" + position,"LIVING");
        }
        else if(position>=livingtab && position<livingtab+kitchentabs){
            //Log.d("MainModel","value of position in click " + position);
            return BedroomFragment.newInstance( "Kitchen" + position,"KITCHEN");
        }
        else if(position>=livingtab+kitchentabs && position<livingtab+kitchentabs+bedtabs){
            //Log.d("MainModel","value of position in click " + position);
            //Log.d("MainModel","this if else works");
            return BedroomFragment.newInstance("Bedroom" + position,"BEDROOM");
        }
        else{
            return BedroomFragment.newInstance("Living" + position,"LIVING");
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
