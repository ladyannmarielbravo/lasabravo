package com.example.finalproject301;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:

                    case R.id.form:
                        startActivity(new Intent(getApplicationContext(),Form.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;

                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),profilr.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                }
            }
        });
    }
}