package com.example.finalproject301;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Survey1 extends AppCompatActivity {
    Button button;
    EditText bodytemp, pulserate, cough, bloodpress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey1);
    }


    public void showAlertDialog(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Accepted");
        alert.setMessage("Thank you for taking the survey!!\n Congratulations you are qualified!\nPleace click continue to fill up the REGISTRATION FORM");
        alert.setCancelable(true);
        alert.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Intent intent = new Intent(Survey1.this, registrationform.class);
                startActivity(intent);
            }
        });
        alert.show();
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        alert.show();
    }}


