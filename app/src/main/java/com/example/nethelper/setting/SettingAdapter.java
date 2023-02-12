package com.example.nethelper.setting;

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

public class SettingAdapter extends ArrayAdapter<Setting> {
    private List<Setting> settings;
    private Context mContext;
    Setting setting;
    private int resourseLayoute;

    public SettingAdapter(@NonNull Context context, int resourse, List<Setting> objects) {

        super(context, resourse, objects);
        this.settings = objects;
        this.mContext = context;
        this.resourseLayoute = resourse;

    }

    @SuppressLint("SuspiciousIndentation")
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View view = convertView;
        if (view == null)
            view = LayoutInflater.from(mContext).inflate(resourseLayoute, null);
        setting = settings.get(position);

        TextView infirmation = view.findViewById(R.id.settingName);
        infirmation.setText(setting.getSetting());

        return view;
    }
}
