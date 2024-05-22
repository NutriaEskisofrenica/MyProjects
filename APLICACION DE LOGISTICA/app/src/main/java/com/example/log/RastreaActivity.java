package com.example.log;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class RastreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rastrea);

        // Set up the dropdown menu
        Spinner dropdown = findViewById(R.id.dropdownMenu);
        String[] items = new String[]{"Option 1", "Option 2", "Option 3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }

    public void goHome(View view) {
        Intent intent = new Intent(RastreaActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    public void openSettings(View view) {
        Intent intent = new Intent(RastreaActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    public void openScan(View view) {
        // Launch device's camera
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }

    public void openInfo(View view) {
        Intent intent = new Intent(RastreaActivity.this, InfoActivity.class);
        startActivity(intent);
    }

    public void openNotification(View view) {
        Intent intent = new Intent(RastreaActivity.this, NotificacionActivity.class);
        startActivity(intent);
    }

}
