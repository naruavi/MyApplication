package com0.example.android.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class BedroomFragment extends Fragment {

    static View view;

    public static String PREFIXID ;
    private int IconImage = R.drawable.ic_bed_mini;
    private int noOfRoom = 3;
    private String Bid;
    private BedRoomPresenter presenter;
    private String roomname;
    private int NoofLights; // may not be of use
    private int NoofFans; // may not be of use
    private HashMap<String, Integer> Devices;
    private ArrayList<HashMap<String, Integer>> deviceroom;
    private HashMap<String,light> alldevices;
    private HashMap<String, View> alldeviceviews;
    private TextView mviewroomname;
    private int TotalDevices;
/*    private LinearLayout parentLayout;
    private LinearLayout parentLayout2;*/
    private LinearLayout testparentLayout1;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference rootreference;
    private final String path = "/device_details/JBANU01";

    public BedroomFragment() {
        // Required empty public constructor
    }

    public static BedroomFragment newInstance(String id,String prefix,int position){
        Log.d("Bed new instance","works");
        BedroomFragment fragment = new BedroomFragment();
        Bundle bundle = new Bundle();
        PREFIXID = prefix;
        String temp = id;
        bundle.putString("bedroomid",temp);
        bundle.putInt("devicerooomposition",position);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_bedroom, container,false);
        initialize(view);
        mviewroomname.setText(roomname); // see how to implement
        Log.d("View ","Room Name Set");
        Log.d("Devices",String.valueOf(Devices.size()));
        final int pos = getArguments().getInt("deviceroomposition");
        Log.d("found position",String.valueOf(pos));
        if (deviceroom.isEmpty() || deviceroom.get(pos) == null) {
            rootreference = mFirebaseDatabase.getReference().child(path + "/"+Bid);
            rootreference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Log.d("data","found" + dataSnapshot.getChildrenCount());
                    for(DataSnapshot ds : dataSnapshot.getChildren()){
                        //Log.d("data","found" + ds.getChildren().toString());
                        Log.d("data",ds.getKey().toString() + " " + ds.getValue().toString());
                        Devices.put(ds.getKey().toString(), Integer.parseInt(ds.getValue().toString()));
                        deviceroom.add(pos,Devices);
                    }
                    addtiles(inflater, container);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        else{
            Devices = deviceroom.get(pos);
            addtiles(inflater,container);
            Log.d("lagging","running else");
        }
/*        if(deviceroom.isEmpty() || deviceroom.get(pos) == null){
            try{
                Thread.sleep(100);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }*/
        return view;
    }

    public void initialize(View v){
        try{
        Bid = getArguments().getString("bedroomid");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        Devices = new HashMap<String, Integer>();
        deviceroom = new ArrayList<HashMap<String, Integer>>();
        alldevices = new HashMap<String, light>();
        alldeviceviews = new HashMap<String, View>();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        presenter = new BedRoomPresenter();
        presenter.passId(Bid);
/*        parentLayout = v.findViewById(R.id.bedroomlinearlayout);
        parentLayout2 = v.findViewById(R.id.parentlayout2);*/
        testparentLayout1 = v.findViewById(R.id.testparent1);
        mviewroomname = v.findViewById(R.id.RoomName);
        //roomname = presenter.getroomname(); // see how to implement
        //Devices = presenter.getDevices();
    }

    public int makeimagetile(String key){
        switch(key){
            case "balcony_light":  return R.layout.balcony_light_tile;
            case "bathroom_light": return R.layout.balcony_light_tile;
            case "fan": return R.layout.fan;
            case "geyser": return R.layout.geyser;
            case "ac": return R.layout.ac;
            //case "cooler": return R.layout.cooler;
            default: return R.layout.bathroom_light_tile;
        }
    }

    public void addtiles(final LayoutInflater inflater, final ViewGroup container){
        LinearLayout parentoftwo = new LinearLayout(getActivity());
        int layoutcount = 0;
        for(Map.Entry<String, Integer> entry: Devices.entrySet()){
            final String key = entry.getKey();
            final Integer value = entry.getValue();
            final int foundtile = makeimagetile(key);
            for (int r=1;r<=value;r++){
                Log.d("Views","dynamic creation of views " + r);
                if(layoutcount !=2 ){
                    final int lightno = r;
                    final String devicepath = "device_id/JBANU01/" + Bid +"/"+ key+r;
                    rootreference = mFirebaseDatabase.getReference().child(devicepath);
                    Log.d("path",devicepath);
                    final View v = inflater.inflate(foundtile, container,false);
                    rootreference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Log.d("DataChange", "Data changed");
                            Log.d("status",dataSnapshot.getValue().toString());
                            if(!alldevices.containsKey(devicepath)){
                                int status = Integer.parseInt(dataSnapshot.getValue().toString());
                                v.setContentDescription(devicepath);
                                light l = new light(status,v.getContentDescription().toString());
                                l.key = key;
                                alldevices.put(v.getContentDescription().toString(),l);
                                alldeviceviews.put(v.getContentDescription().toString(),v);
                                final ImageButton tempimagebutton = v.findViewById(R.id.imagetile);
                                tempimagebutton.setContentDescription(devicepath);
                                final TextView temptextview = v.findViewById(R.id.texttile);
                                temptextview.setText(key + " " + lightno);
                                if(l.getLed1Status()==0){
                                    int reqimage = getImage(key,l.getLed1Status());
                                    tempimagebutton.setImageResource(reqimage);
                                }
                                else{
                                    int reqimage = getImage(key,l.getLed1Status());
                                    tempimagebutton.setImageResource(reqimage);
                                }
                                tempimagebutton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        light l = alldevices.get(view.getContentDescription());
                                        if(l.getLed1Status() == 0){
                                            l.setLed1Status(1);
                                            int reqimage = getImage(key,l.getLed1Status());
                                            tempimagebutton.setImageResource(reqimage);
                                            rootreference = mFirebaseDatabase.getReference().child(tempimagebutton.getContentDescription().toString());
                                            rootreference.setValue(1);
                                        }
                                        else{
                                            l.setLed1Status(0);
                                            int reqimage = getImage(key,l.getLed1Status());
                                            tempimagebutton.setImageResource(reqimage);
                                            rootreference = mFirebaseDatabase.getReference().child(tempimagebutton.getContentDescription().toString());
                                            rootreference.setValue(0);
                                        }
                                    }
                                });
                                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                                        (LinearLayout.LayoutParams.WRAP_CONTENT,
                                         LinearLayout.LayoutParams.WRAP_CONTENT,
                                        1.0f
                                        );
                                v.setLayoutParams(params);
                            }
                            else if(alldevices.get(devicepath).getLed1Status() != Integer.parseInt(dataSnapshot.getValue().toString())){
                                Log.d("DataChange", "Data changed yes ran");
                                light l = alldevices.get(devicepath);
                                View lightview = alldeviceviews.get(devicepath);
                                int lstatus = Integer.parseInt(dataSnapshot.getValue().toString());
                                l.setLed1Status(lstatus);
                                ImageButton tempimagebutton = lightview.findViewById(R.id.imagetile);
                                tempimagebutton.setContentDescription(devicepath);
                                int reimage = getImage(l.key,l.getLed1Status());
                                tempimagebutton.setImageResource(reimage);
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    parentoftwo.addView(v);
                    layoutcount = layoutcount + 1;
                    if(layoutcount == 2){
                        layoutcount=0;
                        LinearLayout.LayoutParams parentoftwoparams = new LinearLayout.LayoutParams
                                (LinearLayout.LayoutParams.MATCH_PARENT,
                                        LinearLayout.LayoutParams.WRAP_CONTENT
                                );
                        parentoftwoparams.setMargins(0,24,0,24);
                        parentoftwo.setLayoutParams(parentoftwoparams);
                        testparentLayout1.addView(parentoftwo);
                        parentoftwo = new LinearLayout(getActivity());
                        Log.d("new","new linear view");
                    }
                }
            }
        }
        if(layoutcount < 2){
            LinearLayout.LayoutParams parentoftwoparams = new LinearLayout.LayoutParams
                    (LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );
            parentoftwoparams.setMargins(0,24,0,24);
            parentoftwo.setLayoutParams(parentoftwoparams);
            testparentLayout1.addView(parentoftwo);
            Log.d("new","last value");
        }
        /*for(Map.Entry<String, Integer> entry: Devices.entrySet()){
            final String key = entry.getKey();
            final Integer value = entry.getValue();
            Log.d("View","loop works " + key + value);
            final int foundtile = makeimagetile(key);
            for (int y=1;y<=value;y++){
                Log.d("Views","dynamic creation of views " + y);
                if (y%2 !=0){
                    final String devicepath = "device_id/JBANU01/" + Bid +"/"+ key+y;
                    rootreference = mFirebaseDatabase.getReference().child(devicepath);
                    Log.d("path",devicepath);
                    rootreference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Log.d("status",dataSnapshot.getValue().toString());
                            if(!alldevices.containsKey(devicepath)){
                                int status = Integer.parseInt(dataSnapshot.getValue().toString());
                                View v = inflater.inflate(foundtile, container,false);
                                v.setContentDescription(devicepath);
                                light l = new light(status,v.getContentDescription().toString());
                                alldevices.put(v.getContentDescription().toString(),l);
                                final ImageButton tempimagebutton = v.findViewById(R.id.imagetile);
                                tempimagebutton.setContentDescription(devicepath);
                                if(l.getLed1Status()==0){
                                    int reqimage = getImage(key,l.getLed1Status());
                                    tempimagebutton.setImageResource(reqimage);
                                }
                                else{
                                    int reqimage = getImage(key,l.getLed1Status());
                                    tempimagebutton.setImageResource(reqimage);
                                }
                                tempimagebutton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        light l = alldevices.get(view.getContentDescription());
                                        if(l.getLed1Status() == 0){
                                            l.setLed1Status(1);
                                            int reqimage = getImage(key,l.getLed1Status());
                                            tempimagebutton.setImageResource(reqimage);
                                            rootreference = mFirebaseDatabase.getReference().child(tempimagebutton.getContentDescription().toString());
                                            rootreference.setValue(1);
                                        }
                                        else{
                                            l.setLed1Status(0);
                                            int reqimage = getImage(key,l.getLed1Status());
                                            tempimagebutton.setImageResource(reqimage);
                                            rootreference = mFirebaseDatabase.getReference().child(tempimagebutton.getContentDescription().toString());
                                            rootreference.setValue(0);
                                        }
                                    }
                                });
                                parentLayout.addView(v);
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
                else{
                    final String devicepath = "device_id/JBANU01/" + Bid +"/"+ key+y;
                    rootreference = mFirebaseDatabase.getReference().child(devicepath);
                    rootreference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Log.d("status",devicepath+" "+dataSnapshot.getValue().toString());
                            if(!alldevices.containsKey(devicepath)){
                                int status = Integer.parseInt(dataSnapshot.getValue().toString());
                                View v = inflater.inflate(foundtile, container,false);
                                v.setContentDescription(devicepath);
                                light l = new light(status,v.getContentDescription().toString());
                                alldevices.put(v.getContentDescription().toString(),l);
                                final ImageButton tempimagebutton = v.findViewById(R.id.imagetile);
                                tempimagebutton.setContentDescription(devicepath);
                                if(l.getLed1Status()==0){
                                    int reqimage = getImage(key,l.getLed1Status());
                                    tempimagebutton.setImageResource(reqimage);
                                }
                                else{
                                    int reqimage = getImage(key,l.getLed1Status());
                                    tempimagebutton.setImageResource(reqimage);
                                }
                                tempimagebutton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        light l = alldevices.get(view.getContentDescription());
                                        if(l.getLed1Status() == 0){
                                            l.setLed1Status(1);
                                            int reqimage = getImage(key,l.getLed1Status());
                                            tempimagebutton.setImageResource(reqimage);
                                            rootreference = mFirebaseDatabase.getReference().child(tempimagebutton.getContentDescription().toString());
                                            rootreference.setValue(1);
                                        }
                                        else{
                                            l.setLed1Status(0);
                                            int reqimage = getImage(key,l.getLed1Status());
                                            tempimagebutton.setImageResource(reqimage);
                                            rootreference = mFirebaseDatabase.getReference().child(tempimagebutton.getContentDescription().toString());
                                            rootreference.setValue(0);
                                        }
                                    }
                                });
                                parentLayout2.addView(v);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
        }*/
    }

    public int getImage(String i,int status){
        switch (i){
            case "balcony_light": if(status == 0)return R.drawable.ic_bulb_off;
            else return R.drawable.ic_bulb_on;

            case "bathroom_light": if(status == 0)return R.drawable.ic_bulb_off;
            else return R.drawable.ic_bulb_on;

            case "fan": if(status == 0)return R.drawable.ic_fan_off;
            else return R.drawable.ic_fan_on;

            case "ac": if(status == 0) return R.drawable.ic_ac_off;
            else return R.drawable.ic_ac_on;

            case "geyser": if(status == 0) return R.drawable.ic_geyser_off;
            else  return R.drawable.ic_geyser_on;
            default:return R.drawable.ic_bulb_off;
        }
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
