package com.example.nethelper.deviceobject;

public class Foxgate {
    private String model="Foxgate";
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
    private String [] setting={"Create network","Create remote Ports","Create l2tp"};
    public  String [] getList(){
        return setting;
    }
}
