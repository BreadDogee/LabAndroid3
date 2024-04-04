package com.example.androidlab3;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.example.androidlab3.databinding.FragmentConstraintLayoutBinding;

public class ConstraintLayoutFragment extends Fragment {
    FragmentConstraintLayoutBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentConstraintLayoutBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText = binding.editTextText2.getText().toString();
                addTextViewToConstraintLayout(newText);
            }
        });

        return view;
    }

    private void addTextViewToConstraintLayout(String text) {
        TextView textView = new TextView(requireContext());
        textView.setId(View.generateViewId()); // Генерация уникального идентификатора
        textView.setText(text);
        textView.setTextSize(32);
        textView.setTextColor(getResources().getColor(R.color.black));

        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
        );
        textView.setLayoutParams(layoutParams);

        binding.innerConstraintLayout.addView(textView);

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(binding.innerConstraintLayout);
        constraintSet.connect(textView.getId(), ConstraintSet.START, binding.innerConstraintLayout.getId(), ConstraintSet.START);
        constraintSet.connect(textView.getId(), ConstraintSet.END, binding.innerConstraintLayout.getId(), ConstraintSet.END);

        // Подключим верхнюю грань нового TextView к нижней грани ScrollView
        constraintSet.connect(textView.getId(), ConstraintSet.TOP, binding.scrollView.getId(), ConstraintSet.BOTTOM);

        constraintSet.applyTo(binding.innerConstraintLayout);

        // Прокрутим ScrollView до нового TextView
        binding.scrollView.post(new Runnable() {
            @Override
            public void run() {
                binding.scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }
}
