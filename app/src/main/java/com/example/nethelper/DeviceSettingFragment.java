package com.example.nethelper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import android.app.Fragment;

import com.example.nethelper.databinding.FragmentSettingDeviceBinding;
import com.example.nethelper.setting.Setting;
import com.example.nethelper.setting.SettingAdapter;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class DeviceSettingFragment extends Fragment implements AdapterView.OnItemClickListener {

    MainActivityInterface mainActivityInterface;

    private FragmentSettingDeviceBinding binding;
    Context context;
    private String device;

    private SettingAdapter settingAdapter;
    private List<Setting> strings = new ArrayList<>();
    private ListView listView;
    public DeviceSettingFragment(Context context,String device){
        this.context = context;
        this.device=device;
       this. mainActivityInterface=( MainActivityInterface)context;

        Toast.makeText(context, "Device name "+device, Toast.LENGTH_LONG).show();

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSettingDeviceBinding.inflate(inflater, container, false);

        binding.listSettingView.setOnItemClickListener(this);
        showSetting("");
        return binding.getRoot();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void showSetting(String setting) {
        strings.add(new Setting("Create New Inrerface"));
        strings.add(new Setting("Create Vlans"));
        strings.add(new Setting("Create VPN"));
        settingAdapter = new SettingAdapter(context, R.layout.iteam_setting, strings);
        binding.listSettingView.setAdapter(settingAdapter);
        //listView.setAdapter(settingAdapter);
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(context,"Setting name"+settingAdapter.getItem(position).getSetting(),Toast.LENGTH_LONG).show();
        mainActivityInterface.deviceInstruction("");

    }
}