package com.example.nethelper.device;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.nethelper.R;

import java.util.List;

public class DeviceAdapter extends ArrayAdapter<Device> {
    private List<Device> devices;
    private Context mContext;
    Device device;
    private int resourseLayoute;

    public DeviceAdapter(@NonNull Context context, int resourse, List<Device> objects) {

        super(context, resourse, objects);
        this.devices = objects;
        this.mContext = context;
        this.resourseLayoute = resourse;

    }

    @SuppressLint("SuspiciousIndentation")
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View view = convertView;
        if (view == null)
            view = LayoutInflater.from(mContext).inflate(resourseLayoute, null);
        device = devices.get(position);

        TextView infirmation = view.findViewById(R.id.deviceName);
        infirmation.setText(device.getDevice());

        return view;
    }
}
