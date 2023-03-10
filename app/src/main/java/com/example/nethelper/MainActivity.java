package com.example.nethelper;

import android.app.FragmentTransaction;
import android.content.res.AssetManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import com.example.nethelper.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;


public class MainActivity extends AppCompatActivity implements MainActivityInterface {

    private ActivityMainBinding binding;
    private FragmentTransaction deviceFragment;
    private DeviceFragment deviceFragmentActivity;
    private FragmentTransaction deviceSettingFragment;
    private DeviceSettingFragment deviceSettingFragmentActivity;
    private FragmentTransaction deviceInstructionFragment;
    private DeviceInstructionFragment deviceInstructionFragmentActivity;
    private String frame;
    private Object device;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        device();
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (frame.equals("DeviceInstruction"))
                    deviceSetting(device);
                else if (frame.equals("DeviceSetting")) device();
                //final AssetManager mgr = getAssets();
               // assetFiles(mgr); // содержимое папки /assets, включая странные папки
                //assetFiles(mgr, "cats"); // содержимое подпапки /assets/cats
            }
        });

    }
    void assetFiles(AssetManager mgr) {
        try {
            String list[] = mgr.list("");//webkit images
            if (list != null)
                for (int i = 0; i < list.length; ++i) {
                    //if(mgr.list(list[i])==null)
                    if(list[i].equals("images")||list[i].equals("webkit"));
                        else
                        Log.v("Assets:",  list[i]);
                    //assetFiles(mgr, path + "/" + list[i]);
                }
        } catch (IOException e) {
          //  Log.v("List error:", "can't list" + path);
        }
    }
    public void device() {
        frame = "Device";
        deviceFragment = getFragmentManager().beginTransaction();
        deviceFragmentActivity = new DeviceFragment(MainActivity.this);
        deviceFragment.replace(R.id.frameLayout, deviceFragmentActivity);
        deviceFragment.commit();
    }

    public void deviceSetting(Object device) {
        this.device = device;
        frame = "DeviceSetting";
        deviceSettingFragment = getFragmentManager().beginTransaction();
        deviceSettingFragmentActivity = new DeviceSettingFragment(MainActivity.this, device);
        deviceSettingFragment.replace(R.id.frameLayout, deviceSettingFragmentActivity);
        deviceSettingFragment.commit();
    }

    public void deviceInstruction(String device) {
        frame = "DeviceInstruction";
        deviceInstructionFragment = getFragmentManager().beginTransaction();
        deviceInstructionFragmentActivity = new DeviceInstructionFragment(MainActivity.this, device);
        deviceInstructionFragment.replace(R.id.frameLayout, deviceInstructionFragmentActivity);
        deviceInstructionFragment.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
   /* @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }*/
}