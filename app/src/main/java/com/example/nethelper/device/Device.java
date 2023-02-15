package com.example.nethelper.device;

import android.content.res.AssetManager;
import android.util.Log;

import com.example.nethelper.deviceobject.Cisco;
import com.example.nethelper.deviceobject.Foxgate;
import com.example.nethelper.deviceobject.Mikrotik;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Device {

    public static final String cisco = "Cisco";
    public static final String asa = "Asa";
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
        else return new String[]{"no info"};
    }

    public static final List<String> assetFiles(AssetManager mgr,String group) {
        List<String> assets = new ArrayList<>();
        try {
            String list[] = mgr.list(group);
            if (list != null)
                for (int i = 0; i < list.length; ++i) {
                    if (list[i].equals("images") || list[i].equals("webkit")) ;
                   else
                        assets.add(list[i].replaceAll(".html",""));
                }
        } catch (IOException e) {
        }
        return assets;
    }

    public void setDevice(String deviceName) {
        this.deviceName = deviceName;
    }


}
