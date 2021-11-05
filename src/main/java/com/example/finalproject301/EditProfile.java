package com.example.finalproject301;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;

public class EditProfile extends AppCompatActivity {
    int SELECT_PHOTO = 1;
    Uri uri;
    TextView resultss;

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Button Choose = findViewById(R.id.choose);
        imageView = findViewById(R.id.image);
        Button cancell = findViewById(R.id.cancell);
        cancell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendUserToNextActvity();
            }
        });

//intent to get data
        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        String email = intent.getStringExtra("EMAIL");
        String phone = intent.getStringExtra("PHONE");
        String address = intent.getStringExtra("ADDRESS");
        String birthday = intent.getStringExtra("BIRTHDAY");
        String reference = intent.getStringExtra("REFERENCE");
        //TextView
        TextView mResultTv = findViewById(R.id.resultTv);

        //setText
        mResultTv.setText("Name: "+name+"\nAge: " +email+ "\nContact Number: "+phone+"\nAddress:  "+address+ "\nBirthday: "+birthday+"\nReference Number: "+reference);



        Choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, SELECT_PHOTO);

            }
        });}

    private void sendUserToNextActvity() {

            Intent intent = new Intent(EditProfile.this, profilr.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }


    @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == SELECT_PHOTO&& resultCode == RESULT_OK && data != null && data.getData() !=null);
            uri = data.getData();
            try{
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


}}