package com0.example.android.myapplication;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.awt.font.TextAttribute;

public class Manahome extends AppCompatActivity {

    private TextView rent;
    private TextView AssignNewMaster;
    private ConstraintLayout rentlayout;
    private ConstraintLayout newMasterlayout;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_homes);
        rent = findViewById(R.id.Home2);
        rentlayout = findViewById(R.id.layout1);
        AssignNewMaster = findViewById(R.id.textView17);
        newMasterlayout = findViewById(R.id.layout2);
        rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("rent", "visible");
                rentlayout.setVisibility(View.VISIBLE);
            }
        });

        AssignNewMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newMasterlayout.setVisibility(View.VISIBLE);
            }
        });

    }


}
