package com.example.finalproject301;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.Random;

public class registrationform extends AppCompatActivity {
    EditText lname,fname,age,date_birth,address,contact_num,id_num,categoryy,code;
    Button submit, send, generate;
    TextView randommm;
    ImageView Output;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationform);
       lname = findViewById(R.id.lname);
        fname =  findViewById(R.id.fname);
       age =  findViewById(R.id.age);
         date_birth =  findViewById(R.id.date_birth);
        address =  findViewById(R.id.address);
         contact_num = findViewById(R.id.contact_num);
         id_num=  findViewById(R.id.id_num);
        categoryy = findViewById(R.id.categoryy);
        code = findViewById(R.id.code);
        submit =  findViewById(R.id.submit);
        Output = findViewById(R.id.Output);
        randommm= findViewById(R.id.randommm);
        generate = findViewById(R.id.generate);
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sText = code.getText().toString().trim();
                MultiFormatWriter writer = new MultiFormatWriter();
                try {
                    BitMatrix matrix = writer.encode(sText, BarcodeFormat.QR_CODE,250,250);

                    BarcodeEncoder encoder = new BarcodeEncoder();

                    Bitmap bitmap = encoder.createBitmap(matrix);

                    Output.setImageBitmap(bitmap);

                    InputMethodManager manager = (InputMethodManager)  getSystemService(
                            Context.INPUT_METHOD_SERVICE
                    );
                    manager.hideSoftInputFromWindow(code.getApplicationWindowToken(),0);


                } catch (WriterException e) {
                    e.printStackTrace();
                }


            }
        });



        send= findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int val = random.nextInt(100000-5)+1;
                randommm.setText(Integer.toString(val));

            }
        });


        reff= FirebaseDatabase.getInstance().getReference().child("Data");
        submit.setOnClickListener(v -> startActivity(new Intent(registrationform.this, Home.class)));
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendUserToNextActivity();
                insetFormData();


            }
        });

    }
    private void insetFormData(){

        String lastname=lname.getText().toString();
        String firstname= fname.getText().toString();
        String age1= age.getText().toString();
        String birth= date_birth.getText().toString();
        String addr= address.getText().toString();
        String contact= contact_num.getText().toString();
        String idnum1= id_num.getText().toString();
        String category1= categoryy.getText().toString();
        String codee= code.getText().toString();


        Data data = new Data(lastname,firstname,age1, birth,addr,contact,idnum1,category1,codee);


        reff.push().setValue(data);
        Toast.makeText(registrationform.this,"Successful",Toast.LENGTH_LONG).show();

    }
    private void sendUserToNextActivity() {
        Intent intent = new Intent(registrationform.this, Home.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);}




}