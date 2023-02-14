package com.example.nethelper.device;

import com.example.nethelper.deviceobject.Cisco;
import com.example.nethelper.deviceobject.Foxgate;
import com.example.nethelper.deviceobject.Mikrotik;

import java.util.List;

public class Device {

    public static final String cisco = "Cisco";
    public static final String foxgate = "Foxgate";
    public static final String mikrotik = "Mikrotik";

    private String deviceName;


    public Device(String deviceName) {

        this.deviceName = deviceName;

    }


    public String getDevice() {
        return deviceName;
    }

    public Object getDeviceObject() {
        if (deviceName.equals(cisco))
            return new Cisco();
        else if (deviceName.equals(foxgate))
            return new Foxgate();
        else return new Mikrotik();

    }

    static public String[] setDeviceObject(String deviceName) {
        if (deviceName.equals(cisco))
            return new Cisco().getList();
        else if (deviceName.equals(foxgate))
            return new Foxgate().getList();
        else if (deviceName.equals(mikrotik))
            return new Mikrotik().getList();
        else return new String[]{"Is not info"};

    }

    public void setDevice(String deviceName) {
        this.deviceName = deviceName;
    }


}
