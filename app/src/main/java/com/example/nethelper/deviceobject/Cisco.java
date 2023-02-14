package com.example.nethelper.deviceobject;

import java.util.ArrayList;
import java.util.List;

public class Cisco {
    private String model="Cisco";
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

    private String [] setting={"Create New Inrerface","Create Vlans","Create VPN"};
    public  String [] getList(){
        return setting;
    }
}
