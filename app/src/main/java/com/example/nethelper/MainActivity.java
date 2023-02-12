package com.example.nethelper;

import android.app.FragmentTransaction;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import com.example.nethelper.databinding.ActivityMainBinding;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity implements MainActivityInterface {

    private ActivityMainBinding binding;
    private FragmentTransaction deviceFragment;
    private DeviceFragment deviceFragmentActivity;
    private FragmentTransaction deviceSettingFragment;
    private DeviceSettingFragment deviceSettingFragmentActivity;
    private FragmentTransaction deviceInstructionFragment;
    private DeviceInstructionFragment deviceInstructionFragmentActivity;
    private String frame;

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
                    deviceSetting("");
                else if (frame.equals("DeviceSetting")) device();
            }
        });
    }

    public void device() {
        frame = "Device";
        deviceFragment = getFragmentManager().beginTransaction();
        deviceFragmentActivity = new DeviceFragment(MainActivity.this);
        deviceFragment.replace(R.id.frameLayout, deviceFragmentActivity);
        deviceFragment.commit();
    }

    public void deviceSetting(String device) {
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