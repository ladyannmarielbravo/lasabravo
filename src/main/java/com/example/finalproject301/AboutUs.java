package com.example.finalproject301;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class AboutUs extends AppCompatActivity {
Button btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        btnback= findViewById(R.id.btnback);
        btnback.setOnClickListener(v -> startActivity(new Intent(AboutUs.this, profilr.class)));
    }
    private void sendUserToNextActivity() {
        Intent intent = new Intent(AboutUs.this,profilr.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}