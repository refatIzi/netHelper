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


   /* @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDeviceInstructionBinding.inflate(inflater, container, false);
        binding.instruction.setText("І\n" +
                "\n" +
                "Кохайтеся, чорнобриві,\n" +
                "\n" +
                "Та не з москалями,\n" +
                "\n" +
                "Бо москалі — чужі люде,\n" +
                "\n" +
                "Роблять лихо з вами.\n" +
                "\n" +
                "Москаль любить жартуючи,\n" +
                "\n" +
                "Жартуючи кине;\n" +
                "\n" +
                "Піде в свою Московщину,\n" +
                "\n" +
                "А дівчина гине...\n" +
                "\n" +
                "Якби сама, ще б нічого,\n" +
                "\n" +
                "А то й стара мати,\n" +
                "\n" +
                "Що привела на світ Божий,\n" +
                "\n" +
                "Мусить погибати.\n" +
                "\n" +
                "Серце в’яне співаючи,\n" +
                "\n" +
                "Коли знає, за що;\n" +
                "\n" +
                "Люде серця не побачать,\n" +
                "\n" +
                "А скажуть — ледащо!\n" +
                "\n" +
                "Кохайтеся ж, чорнобриві,\n" +
                "\n" +
                "Та не з москалями,\n" +
                "\n" +
                "Бо москалі — чужі люде,\n" +
                "\n" +
                "Згнущаються вами.");
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}