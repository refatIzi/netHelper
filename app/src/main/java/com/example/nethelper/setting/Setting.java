package com.example.nethelper.setting;

public class Setting {
    private String string;

    public Setting(String string){
        this.string = string;
    }
    public String getSetting(){ return string;}
    public void setSetting(String deviceName){this.string =deviceName;}

}
