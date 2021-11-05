package com.example.finalproject301;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    TextView btnAlreadyHaveAnAccount;
    EditText btnEmail,btnPass1, btnPass2;
    Button btnRegister;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnAlreadyHaveAnAccount=findViewById(R.id.btnAlreadyHaveAnAccount);
        btnEmail=findViewById(R.id.btnEmail);
        btnPass1=findViewById(R.id.btnPass1);
        btnPass2=findViewById(R.id.btnPass2);
        btnRegister=findViewById(R.id.btnRegister);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        btnAlreadyHaveAnAccount.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this,MainActivity.class));

            }

        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerforAuth();
            }
        });

    }

    private void PerforAuth() {

        String email=btnEmail.getText().toString();
        String password = btnPass1.getText().toString();
        String confirmpass = btnPass2.getText().toString();

        if (!email.matches(emailPattern))
        {
            btnEmail.setError("Enter Correct Email");
        }else if (password.isEmpty() || password.length()<6)
        {
            btnPass1.setError("Enter Proper Password");
        }else if(!password.equals(confirmpass))
        {
            btnPass2.setError("Password not Match");
        }else {
            progressDialog.setMessage("Registration...");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();


            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        sendUserToNextActviity();
                        Toast.makeText(Register.this,"Registration Successful",Toast.LENGTH_LONG).show();



                    }else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(Register.this,""+task.getException(),Toast.LENGTH_LONG).show();

                    }

                }
            });



        }
    }

    private void sendUserToNextActviity() {
        Intent intent = new Intent(Register.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }}
