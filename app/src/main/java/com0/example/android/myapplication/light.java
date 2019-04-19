package com0.example.android.myapplication;

public class light {

        private int mLed1Status;
        public String Deviceid;
        public String key;

        public light(){}

        public light(int led1Status,String s){
            mLed1Status = led1Status;
            Deviceid = s;
        }

        public int getLed1Status(){
            return mLed1Status;
        }

        public void setLed1Status(int status){
            mLed1Status = status;
        }

}
