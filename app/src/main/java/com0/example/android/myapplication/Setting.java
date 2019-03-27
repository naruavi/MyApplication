package com0.example.android.myapplication;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class Setting extends AppCompatActivity {

    private TextView OwnerName;
    private TextView mManageUser;
    private TextView mManageHome;
    private TextView mManageDevices;
    private TextView HomeScreen;
    private TextView help;
    private TextView myAccount;
    private Button mMasterSwitch;
    private Button mWelcomeHome;



    private ImageView ProfilePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeView();

        mManageUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Setting.this,MangeUser.class);
                startActivity(intent);

            }
        });

        mManageHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting.this, Manahome.class);
                startActivity(intent);
            }
        });

        myAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Setting.this,MyAccount.class);
                startActivity(i);
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Setting.this,Help.class);
                startActivity(i);
            }
        });



    }

    public void initializeView(){
        OwnerName = (TextView)findViewById(R.id.OwnerName);
        mManageUser = (TextView)findViewById(R.id.ManageUser);
        mManageDevices = (TextView)findViewById(R.id.ManageDevices);
        mManageHome = (TextView)findViewById(R.id.ManageHome);
        HomeScreen = (TextView)findViewById(R.id.HomeScreen);
        help = (TextView)findViewById(R.id.Help);
        myAccount = (TextView)findViewById(R.id.MyAccount);
        mMasterSwitch = findViewById(R.id.MasterSwitch);
        mWelcomeHome = findViewById(R.id.WelcomeHome);


    }

}
