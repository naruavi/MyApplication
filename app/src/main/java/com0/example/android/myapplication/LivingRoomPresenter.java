package com0.example.android.myapplication;

import java.util.HashMap;

public class LivingRoomPresenter {
    private LivingRoomModel livingRoomModel;
    private LivingRoomFragment livingroomfragment;

    public LivingRoomPresenter (){
        livingRoomModel = new LivingRoomModel();
        livingroomfragment = new LivingRoomFragment();
    }

    public void passId(String id){
        livingRoomModel.setId(id);
        livingRoomModel.getidelements(id);
    }

    public HashMap<String,Integer> getDevices(){
        return livingRoomModel.getDevices();
    }

    public String getroomname(){
        return livingRoomModel.getName();
    }

    public int getFans(){
        return livingRoomModel.getNooffans();
    }

    public int getLights(){
        return livingRoomModel.getNooflights();
    }
}
