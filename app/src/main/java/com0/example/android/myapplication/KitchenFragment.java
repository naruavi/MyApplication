package com0.example.android.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class KitchenFragment extends Fragment {

    private static final String PREFIXID = "Kitchen";
    private int IconImage = R.drawable.ic_spoon_and_fork_mini;
    private int noOfRoom = 1;
    private String Kid;
    private KitchenPresenter presenter;
    private String roomname;
    private int NoofLights; // may not be of use
    private int NoofFans; // may not be of use
    private HashMap<String, Integer> Devices;
    private TextView mviewroomname;
    private int TotalDevices;
    private LinearLayout parentLayout;
    private LinearLayout parentLayout2;
    private int clicked = 0;

    public KitchenFragment() {
        // Required empty public constructor
    }

    public static KitchenFragment newInstance(int id){
        Log.d("kitchen new instance","works");
        KitchenFragment fragment = new KitchenFragment();
        Bundle bundle = new Bundle();
        String temp = PREFIXID + id;
        bundle.putString("kitchenid",temp);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bedroom, container,false);
        initialize(view);
        mviewroomname.setText(roomname); // see how to implement
        //Log.d("View ","Room Name Set");
        for(Map.Entry<String, Integer> entry: Devices.entrySet()){
            final String key = entry.getKey();
            final Integer value = entry.getValue();
            Log.d("View","loop works " + key + value);
            int foundtile = makeimagetile(key);
            for (int y=1;y<=value;y++){
                Log.d("Views","dynamic creation of views " + y);
                if (y%2 !=0){
                    View v = inflater.inflate(foundtile, container,false);
                    TextView temptextview = v.findViewById(R.id.texttile);
                    final ImageButton tempimagebutton = v.findViewById(R.id.imagetile);
                    tempimagebutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (clicked == 0){
                                if (key.equals("fan"))
                                    tempimagebutton.setImageResource(R.drawable.fan_on);
                                else
                                    tempimagebutton.setImageResource(R.drawable.bulb_on);
                                clicked=1;
                            }
                            else {
                                if (key.equals("fan"))
                                    tempimagebutton.setImageResource(R.drawable.fan_off);
                                else
                                    tempimagebutton.setImageResource(R.drawable.bulb_off);
                                clicked=0;
                            }
                        }
                    });
                    //temptextview.setText(key + "" + (y+1));
                    parentLayout.addView(v);
                }
                else{
                    Log.d("View","else works");
                    View v = inflater.inflate(foundtile, container,false);
                    TextView temptextview = v.findViewById(R.id.texttile);
                    final ImageButton tempimagebutton = v.findViewById(R.id.imagetile);
                    tempimagebutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (clicked == 0){
                                if (key.equals("fan"))
                                    tempimagebutton.setImageResource(R.drawable.fan_on);
                                else
                                    tempimagebutton.setImageResource(R.drawable.bulb_on);
                                clicked=1;
                            }
                            else {
                                if (key.equals("fan"))
                                    tempimagebutton.setImageResource(R.drawable.fan_off);
                                else
                                    tempimagebutton.setImageResource(R.drawable.bulb_off);
                                clicked=0;
                            }
                        }
                    });
                    //temptextview.setText(key + "" + (y+1));
                    parentLayout2.addView(v);
                }
            }
        }
        return view;
    }

    public void initialize(View v){
        try{
            Kid = getArguments().getString("kitchenid");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        presenter = new KitchenPresenter();
        presenter.passId(Kid);
        parentLayout = v.findViewById(R.id.kitchenparentlayout1);
        parentLayout2 = v.findViewById(R.id.kitchenparentlayout2);
        mviewroomname = v.findViewById(R.id.RoomName);
        roomname = presenter.getroomname(); // see how to implement
        Devices = presenter.getDevices();
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
