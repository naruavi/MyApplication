package com0.example.android.myapplication;

public class fan {
    private boolean mLed1Status, mLed2Status;

    public fan(){}

    public fan(boolean led1Status, boolean led2Status){
        mLed1Status = led1Status;
        mLed2Status = led2Status;
    }

    public boolean getLed1Status(){
        return mLed1Status;
    }

    public boolean getLed2Status(){
        return  mLed2Status;
    }

    public void setLed1Status(boolean status){
        mLed1Status = status;
    }

    public void setLed2Status(boolean status){
        mLed2Status = status;
    }
}
