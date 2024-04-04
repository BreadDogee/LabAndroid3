package com.example.androidlab3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.androidlab3.databinding.FragmentFrameLayoutBinding;
import com.example.androidlab3.databinding.FragmentGridLayoutBinding;

public class GridLayoutFragment extends Fragment {

    FragmentGridLayoutBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGridLayoutBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout = (LinearLayout) binding.linearLayout1;
                LinearLayout.LayoutParams viewParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                viewParams.weight = 1;
                viewParams.rightMargin = 60;
                viewParams.gravity = Gravity.END;
                TextView txtView = new TextView(getActivity().getApplicationContext());
                txtView.setText(binding.editTextText8.getText());

                txtView.setHeight(300);
                txtView.setTextSize(32);
                txtView.setTextColor(getResources().getColor(R.color.black));
                linearLayout.addView(txtView);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}