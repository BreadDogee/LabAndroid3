package com.example.androidlab3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.Html;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
;
import com.example.androidlab3.databinding.FragmentFrameLayoutBinding;

public class FrameLayoutFragment extends Fragment {

    public FragmentFrameLayoutBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFrameLayoutBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // Событие нажатия на кнопку "Отправить"
        binding.sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

        return view;
    }

    // Метод для отправки сообщения
    private void sendMessage() {
        // Получаем текст из поля ввода
        String message = binding.messageEditText.getText().toString().trim();
        if (!message.isEmpty()) {
            // Получаем текущий текст чата
            String currentText = binding.chatTextView.getText().toString();
            // Создаем новое сообщение с выравниванием по правому краю
            String newText = "<div align=\"right\">" + message + "</div>\n";
            // Объединяем текущий текст чата с новым сообщением
            String updatedText = currentText + newText;
            // Устанавливаем новый текст в чат
            binding.chatTextView.setText(Html.fromHtml(updatedText, Html.FROM_HTML_MODE_COMPACT));
            // Очищаем поле ввода
            binding.messageEditText.setText("");
            // Прокручиваем ScrollView вниз для отображения нового сообщения
            binding.scrollView1.fullScroll(View.FOCUS_DOWN);
        }
    }
}

