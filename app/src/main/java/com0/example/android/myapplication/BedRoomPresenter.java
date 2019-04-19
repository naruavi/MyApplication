package com0.example.android.myapplication;

import android.view.LayoutInflater;

import java.util.HashMap;

public class BedRoomPresenter {
    private BedRoomModel bedRoomModel;
    private BedroomFragment bedroomFragment;

    public BedRoomPresenter (){
        bedRoomModel = new BedRoomModel();
        bedroomFragment = new BedroomFragment();
    }

    public void passId(String id){
        bedRoomModel.setId(id);
        bedRoomModel.getidelements(id);
    }

    public HashMap<String,Integer> getDevices(){
        return bedRoomModel.getDevices();
    }

    public String getroomname(){
        return bedRoomModel.getName();
    }

    public int getFans(){
        return bedRoomModel.getNooffans();
    }

    public int getLights(){
        return bedRoomModel.getNooflights();
    }
}
