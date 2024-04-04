package com.example.androidlab3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.androidlab3.databinding.FragmentLinearLayoutBinding;

public class LinearLayoutFragment extends Fragment {
    FragmentLinearLayoutBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLinearLayoutBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout = (LinearLayout) binding.linearLayout1;
                LinearLayout.LayoutParams viewParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                viewParams.weight = 1;
                viewParams.rightMargin = 60;
                viewParams.gravity = Gravity.END;
                TextView txtView = new TextView(getActivity().getApplicationContext());
                txtView.setText(binding.editTextText2.getText());
                txtView.setHeight(300);
                txtView.setTextSize(32);
                txtView.setTextColor(getResources().getColor(R.color.black));
                txtView.setLayoutParams(viewParams);
                linearLayout.addView(txtView);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}