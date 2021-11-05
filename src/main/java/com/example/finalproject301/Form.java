package com.example.finalproject301;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Button btnsurvey = findViewById(R.id.btnsurvey);
        Button btnregForm = findViewById(R.id.btnregForm);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.form);
        btnsurvey.setOnClickListener(v -> startActivity(new Intent(Form.this, Survey1.class)));
        btnregForm.setOnClickListener(v -> startActivity(new Intent(Form.this,registrationform.class) ));

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),Home.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;

                    case R.id.form:


                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),profilr.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                }
            }
        });
    }
    private void sendUserToNextActviity() {
        Intent intent = new Intent(Form.this, Survey1.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    private void sendUserToNextActvity() {
        Intent intent = new Intent(Form.this, registrationform.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }}
