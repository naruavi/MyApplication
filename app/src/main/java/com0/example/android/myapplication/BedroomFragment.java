package com0.example.android.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class BedroomFragment extends Fragment {

    private int IconImage = R.drawable.ic_bed_mini;
    private int noOfRoom = 3;

    public BedroomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bedroom, container, false);
    }

    public int getIconImage(){
        return IconImage;
    }

    public void setIconImage(int id){
        this.IconImage = id;
    }

    public int getNoOfRoom(){
        return this.noOfRoom;
    }

    public void setNoOfRoom(int noOfRoom){
        this.noOfRoom = noOfRoom;
    }

}
