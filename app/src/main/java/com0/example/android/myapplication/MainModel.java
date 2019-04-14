package com0.example.android.myapplication;

import android.util.Log;

public class MainModel {
    private int NoOfLivingRoom;
    private int NoOfKitchen;
    private int NoOfBedroom;

    public MainModel(){
        getDataFromDb();
    }

    public int getNoOfLivingRoom(){
        return NoOfLivingRoom;
    }
    public int getNoOfBedRoom(){
        return NoOfBedroom;
    }
    public int getNoOfKitchen(){
        return NoOfKitchen;
    }

    public void getDataFromDb(){
        this.NoOfLivingRoom = 1;
        this.NoOfKitchen = 1;
        this.NoOfBedroom = 3;
        Log.d("MainModel","rooms" + NoOfKitchen + "" + "" + "");
    }

}
