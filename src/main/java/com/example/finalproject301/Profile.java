package com.example.finalproject301;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //actionbar title

        //EditText
        final EditText mNameEt = findViewById(R.id.nameEt);
        final EditText mEmailEt = findViewById(R.id.emailEt);
        final EditText mPhoneEt = findViewById(R.id.phoneEt);
        final EditText maddressEt = findViewById(R.id.addressEt);
        final EditText mbirthdayEt = findViewById(R.id.birthdayEt);
        final EditText mreferenceEt = findViewById(R.id.ReferenceEt);

        //Button
        Button mSaveBtn = findViewById(R.id.saveBtn);
        Button cancel = findViewById(R.id.Cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendUserToNextActvity();
            }
        });

        //button click listener
        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get data from edit text
                String name = mNameEt.getText().toString();
                String email = mEmailEt.getText().toString();
                String phone = mPhoneEt.getText().toString();
                String address = maddressEt.getText().toString();
                String birthday = mbirthdayEt.getText().toString();
                String reference = mreferenceEt.getText().toString();

                //activity intent
                Intent intent = new Intent(Profile.this, EditProfile.class);
                intent.putExtra("NAME", name);
                intent.putExtra("EMAIL", email);
                intent.putExtra("PHONE", phone);
                intent.putExtra("ADDRESS",address);
                intent.putExtra("BIRTHDAY", birthday);
                intent.putExtra("REFERENCE", reference);
                startActivity(intent);

            }
        });}

    private void sendUserToNextActvity() {
        Intent intent = new Intent(Profile.this, profilr.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}