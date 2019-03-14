package com0.example.android.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView OwnerName;
    private TextView mManageUsage;
    private TextView mManageHome;
    private TextView mManageDevices;
    private TextView HomeScreen;
    private TextView Help;
    private TextView MyAccount;

    private Switch MasterSwitch;
    private Switch WelcomeHome;

    private ImageView ProfilePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeView();
        mManageHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ManageHome fragment = new ManageHome();
                fragmentTransaction.add(R.id.container, fragment,"manageHome");
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    public void initializeView(){
        OwnerName = (TextView)findViewById(R.id.OwnerName);
        mManageUsage = (TextView)findViewById(R.id.ManageUsage);
        mManageDevices = (TextView)findViewById(R.id.ManageDevices);
        mManageHome = (TextView)findViewById(R.id.ManageHome);
        HomeScreen = (TextView)findViewById(R.id.HomeScreen);
        Help = (TextView)findViewById(R.id.Help);
        MyAccount = (TextView)findViewById(R.id.MyAccount);
        MasterSwitch = (Switch)findViewById(R.id.MasterSwitch);
        WelcomeHome = (Switch)findViewById(R.id.WelcomSwitch);
    }

}
