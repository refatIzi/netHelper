package com.example.nethelper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.example.nethelper.databinding.FragmentDeviceInstructionBinding;




@SuppressLint("ValidFragment")
public class DeviceInstructionFragment extends Fragment {
    private @NonNull FragmentDeviceInstructionBinding binding;
    MainActivityInterface mainActivityInterface;
    Context context;
    @SuppressLint("ValidFragment")
    public DeviceInstructionFragment(Context context, String device){
        this.context=context;
        this.mainActivityInterface=  (MainActivityInterface)context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDeviceInstructionBinding.inflate(inflater, container, false);
        //binding.instruction.getSettings().setJavaScriptEnabled(true);

        binding.instruction.loadUrl("file:///android_asset/asa/VRFCiscoAsa.html");
        return binding.getRoot();
    }
}