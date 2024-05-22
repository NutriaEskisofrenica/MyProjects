package com.example.log;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AprendeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprende);
    }

    public void goHome(View view) {
        Intent intent = new Intent(AprendeActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    public void openSettings(View view) {
        Intent intent = new Intent(AprendeActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    public void openScan(View view) {
        // Launch device's camera
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }

    public void openInfo(View view) {
        Intent intent = new Intent(AprendeActivity.this, InfoActivity.class);
        startActivity(intent);
    }

    public void openNotification(View view) {
        Intent intent = new Intent(AprendeActivity.this, NotificacionActivity.class);
        startActivity(intent);
    }
}
