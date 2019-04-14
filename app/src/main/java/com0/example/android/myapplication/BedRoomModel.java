package com0.example.android.myapplication;

import java.util.HashMap;

public class BedRoomModel {

    private String id;
    private String name;
    private int nooflights;
    private int nooffans;
    private HashMap<String, Integer> devices;

    public BedRoomModel(){
        devices = new HashMap<String, Integer>();
    }

    public void setId(String id){
        this.id = id;
    }

    public void getidelements(String id){
        //this.nooffans = 2;
        //this.nooflights = 1;
        if (id.startsWith("Living")){
            this.name = id; // Write query here
            devices.put("balcony_light", 2); // Write query here
            devices.put("bathroom_light", 2); // Write query here
            devices.put("fan",1); //Write query here
        }
        else if(id.startsWith("Kitchen")){
            this.name = id; // Write query here
            devices.put("balcony_light", 2); // Write query here
            devices.put("bathroom_light", 2); // Write query here
            devices.put("fan",3); //Write query here
        }
        else if(id.startsWith("Bedroom")){
            this.name = "BedRoom 1"; // Write query here
            devices.put("balcony_light", 2); // Write query here
            devices.put("bathroom_light", 2); // Write query here
            devices.put("fan",4); //Write query here
        }

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
