package com0.example.android.myapplication;

import java.util.HashMap;

public class KitchenModel {
    private String id;
    private String name;
    private int nooflights;
    private int nooffans;
    private HashMap<String, Integer> devices;

    public KitchenModel(){
        devices = new HashMap<String, Integer>();
    }

    public void setId(String id){
        this.id = id;
    }

    public void getidelements(String id){
        //this.nooffans = 2;
        //this.nooflights = 1;
        this.name = "Kitchen 1"; // Write query here
        devices.put("balcony_light", 2); // Write query here
        devices.put("bathroom_light", 2); // Write query here
        devices.put("fan",3); //Write query here
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
