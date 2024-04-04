package com.example.androidlab3;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidlab3.databinding.FragmentMenuBinding;

public class Menu extends Fragment {

    FragmentMenuBinding binding;
    InnerInterface innerInterface;
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        innerInterface = (InnerInterface) context;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMenuBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.buttonMenu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                innerInterface.Button1();
            }
        });

        binding.buttonMenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                innerInterface.Button2();
            }
        });

        binding.buttonMenu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                innerInterface.Button3();
            }
        });

        binding.buttonMenu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                innerInterface.Button4();
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
    }

    @Override
    public void onPause() {
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onPause();
    }
}