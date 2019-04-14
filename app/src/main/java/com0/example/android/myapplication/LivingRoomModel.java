package com0.example.android.myapplication;

import java.util.HashMap;

public class LivingRoomModel {
    private String id;
    private String name;
    private int nooflights;
    private int nooffans;
    private HashMap<String, Integer> devices;

    public LivingRoomModel(){
        devices = new HashMap<String, Integer>();
    }

    public void setId(String id){
        this.id = id;
    }

    public void getidelements(String id){
        //this.nooffans = 2;
        //this.nooflights = 1;
        this.name = "LivingRoom 1"; // Write query here
        devices.put("balcony_light", 2); // Write query here
        devices.put("bathroom_light", 2); // Write query here
        devices.put("fan",2); //Write query here
        devices.put("ac",1);
        //devices.put("")

    }
    public HashMap<String,Integer> getDevices(){
        return devices;
    }

    public String getName(){
        return name;
    }

    public int getNooffans(){
        return nooffans;
    }

    public int getNooflights(){
        return nooflights;
    }
}
