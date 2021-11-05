package com.example.finalproject301;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.FileNotFoundException;
import java.io.IOException;

public class profilr extends AppCompatActivity {
    int SELECT_PHOTO = 1;
    Uri uri;
    Button button2;
    ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilr);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.profile);

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendUserToNextActivity();
            }
        });
        imageView = findViewById(R.id.image);




        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), Home.class));
                        finish();
                        overridePendingTransition(0, 0);
                        return;

                    case R.id.form:
                        startActivity(new Intent(getApplicationContext(), Form.class));
                        finish();
                        overridePendingTransition(0, 0);
                        return;


                    case R.id.profile:
                }
            }
        });
    }

    private void sendUserToNextActivity() {
        Intent intent = new Intent(profilr.this, Profile.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id = item.getItemId();

        if (item_id == R.id.ratee) {
            Toast.makeText(this, "Rate Us", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), RateUs.class));
            finish();
            overridePendingTransition(0, 0);
        } else if (item_id == R.id.about_us) {
            Toast.makeText(this, "About Us", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), AboutUs.class));
            finish();
            overridePendingTransition(0, 0);
        } else if (item_id == R.id.logout) {
            Toast.makeText(this, "Logout...", Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
            overridePendingTransition(0, 0);
        }


        return true;
    }

}
        