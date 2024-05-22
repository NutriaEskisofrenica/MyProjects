package com.example.log;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    public void goHome(View view) {
        Intent intent = new Intent(InfoActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    public void openSettings(View view) {
        Intent intent = new Intent(InfoActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    public void openScan(View view) {
        // Launch device's camera
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }

    public void openInfo(View view) {
        Intent intent = new Intent(InfoActivity.this, InfoActivity.class);
        startActivity(intent);
    }

    public void openNotification(View view) {
        Intent intent = new Intent(InfoActivity.this, NotificacionActivity.class);
        startActivity(intent);
    }
}