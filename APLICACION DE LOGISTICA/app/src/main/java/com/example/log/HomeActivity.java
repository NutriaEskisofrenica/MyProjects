package com.example.log;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void openAlmacenes(View view) {
        Intent intent = new Intent(HomeActivity.this, AlmacenesActivity.class);
        startActivity(intent);
    }

    public void openRastrea(View view) {
        Intent intent = new Intent(HomeActivity.this, RastreaActivity.class);
        startActivity(intent);
    }

    public void openAprende(View view) {
        Intent intent = new Intent(HomeActivity.this, AprendeActivity.class);
        startActivity(intent);
    }

    public void openComunicate(View view) {
        Intent intent = new Intent(HomeActivity.this, ComunicateActivity.class);
        startActivity(intent);
    }

    public void goHome(View view) {
        Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    public void openSettings(View view) {
        Intent intent = new Intent(HomeActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    public void openScan(View view) {
        // Launch device's camera
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }

    public void openInfo(View view) {
        Intent intent = new Intent(HomeActivity.this, InfoActivity.class);
        startActivity(intent);
    }

    public void openNotification(View view) {
        Intent intent = new Intent(HomeActivity.this, NotificacionActivity.class);
        startActivity(intent);
    }
}

