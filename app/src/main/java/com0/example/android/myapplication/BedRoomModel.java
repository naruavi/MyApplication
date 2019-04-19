package com0.example.android.myapplication;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.android.gms.common.data.DataBufferObserver;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Observable;

public class BedRoomModel {

    private final String path = "/device_details/JBANU01"; //add path with user ID
    private String id;
    private String name;
    private int nooflights;
    private int nooffans;
    private HashMap<String, Integer> devices;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference rootreference;


    public BedRoomModel(){
        devices = new HashMap<String, Integer>();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        //rootreference = mFirebaseDatabase.getReference().child(path);
    }

    public void setId(String id){
        this.id = id;
    }

    public void getidelements(String id){
        //this.nooffans = 2;
        //this.nooflights = 1;
        Log.d("room id",id);
        if (id.startsWith("living")){
            this.name = id; // Write query here
/*            devices.put("balcony_light", 2); // Write query here
            devices.put("bathroom_light", 2); // Write query here
            devices.put("fan",1); //Write query here*/
        }
        else if(id.startsWith("kitchen")){
            this.name = id; // Write query here
//            devices.put("balcony_light", 2); // Write query here
//            devices.put("bathroom_light", 2); // Write query here
//            devices.put("fan",3); //Write query here
        }
        else if(id.startsWith("bedroom")){
            this.name = "BedRoom 1"; // Write query here
/*            devices.put("balcony_light", 2); // Write query here
            devices.put("bathroom_light", 2); // Write query here
            devices.put("fan",4); //Write query here*/
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
