package com.example.log;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ComunicateActivity extends AppCompatActivity {

    private EditText messageField;
    private TextView conversationField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comunicate);

        // Initialize views
        messageField = findViewById(R.id.messageField);
        conversationField = findViewById(R.id.conversationField);

        // Set up the spinner (dropdown menu)
        Spinner dropdown = findViewById(R.id.dropdownMenu);
        String[] items = new String[]{"Option 1", "Option 2", "Option 3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        // Set up the send button
        ImageView sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String message = messageField.getText().toString().trim();
        if (!message.isEmpty()) {
            String currentConversation = conversationField.getText().toString();
            conversationField.setText(currentConversation + "\n" + message);
            messageField.setText("");
        }
    }

    public void goHome(View view) {
        Intent intent = new Intent(ComunicateActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    public void openSettings(View view) {
        Intent intent = new Intent(ComunicateActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    public void openScan(View view) {
        // Launch device's camera
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }

    public void openInfo(View view) {
        Intent intent = new Intent(ComunicateActivity.this, InfoActivity.class);
        startActivity(intent);
    }

    public void openNotification(View view) {
        Intent intent = new Intent(ComunicateActivity.this, NotificacionActivity.class);
        startActivity(intent);
    }
}
