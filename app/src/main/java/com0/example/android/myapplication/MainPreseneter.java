package com0.example.android.myapplication;

public class MainPreseneter {
    private MainActivity activity;
    private MainModel mainModel;

    public MainPreseneter(){
        mainModel = new MainModel();
        activity = new MainActivity();
    }

    public int getLivingRoom(){
        return mainModel.getNoOfLivingRoom();
    }

    public int getBedroom(){
        return mainModel.getNoOfBedRoom();
    }

    public int getKitchen(){
        return mainModel.getNoOfKitchen();
    }
}
