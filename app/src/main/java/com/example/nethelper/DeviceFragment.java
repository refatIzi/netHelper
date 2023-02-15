package com.example.nethelper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import android.app.Fragment;

import com.example.nethelper.databinding.FragmentDeviceBinding;
import com.example.nethelper.device.Device;
import com.example.nethelper.device.DeviceAdapter;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class DeviceFragment extends Fragment implements AdapterView.OnItemClickListener {
    MainActivityInterface mainActivityInterface;
    private FragmentDeviceBinding binding;
    private DeviceAdapter deviceAdapter;
    private List<Device> devices = new ArrayList<>();
    Context context;
    public DeviceFragment(Context context){
        this.context=context;
        this.mainActivityInterface=  (MainActivityInterface)context;
    }
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentDeviceBinding.inflate(inflater, container, false);
        devices.add(new Device("Cisco"));
        devices.add(new Device("Foxgate"));
        devices.add(new Device("Mikrotik"));
        deviceAdapter = new DeviceAdapter(context, R.layout.iteam_device,devices);
        binding.listDevice.setAdapter(deviceAdapter);
        binding.listDevice.setOnItemClickListener(this);
        return binding.getRoot();
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
        mainActivityInterface.deviceSetting(deviceAdapter.getItem(position).getDeviceObject());
    }
}