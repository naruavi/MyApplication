package com0.example.android.myapplication;

import java.util.HashMap;

public class KitchenPresenter {
    private KitchenModel kitchenModel;
    private KitchenFragment kitchenFragment;

    public KitchenPresenter (){
        kitchenModel = new KitchenModel();
        kitchenFragment = new KitchenFragment();
    }

    public void passId(String id){
        kitchenModel.setId(id);
        kitchenModel.getidelements(id);
    }

    public HashMap<String,Integer> getDevices(){
        return kitchenModel.getDevices();
    }

    public String getroomname(){
        return kitchenModel.getName();
    }

    public int getFans(){
        return kitchenModel.getNooffans();
    }

    public int getLights(){
        return kitchenModel.getNooflights();
    }
}
