package com.example.nethelper.deviceobject;

public class Mikrotik {
    private String model="Mikrotik";
    public String getModel() {
        return model;
    }
    @Override
    public  String toString(){
        return model;
    }
    public String getInstruction(){
        return "file:///android_asset/cisco/asa/CiscoVRF.html";
    }
    private String [] setting={"Create Point to Point","Create control network","Create VPN"};
    public  String [] getList(){
        return setting;
    }
}
