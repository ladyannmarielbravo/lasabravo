package com.example.finalproject301;


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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    TextView btnCreateNewAccount;
    EditText btnEmail,btnPass1;
    Button btnLogin;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCreateNewAccount=findViewById(R.id.btnCreateNewAccount);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        btnEmail=findViewById(R.id.btnEmail);
        btnPass1=findViewById(R.id.btnPass1);
        btnLogin=findViewById(R.id.btnLogin);
        progressDialog = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        btnCreateNewAccount.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Register.class)));
        btnLogin.setOnClickListener(v -> performLogin());

    }


    private void performLogin() {

        String email = btnEmail.getText().toString();
        String password = btnPass1.getText().toString();


        if (!email.matches(emailPattern)) {
            btnEmail.setError("Enter Correct Email");
        } else if (password.isEmpty() || password.length() < 6) {
            btnPass1.setError("Enter Proper Password");
        }

        else {
            progressDialog.setMessage("Login...");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {

              if (task.isSuccessful()) {
                    progressDialog.dismiss();
                    sendUserToNextActviity();
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();

                }
              else
                {
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this,""+task.getException(),Toast.LENGTH_LONG).show();

                }

            });
        }


    }

    private void sendUserToNextActviity() {
        Intent intent = new Intent(MainActivity.this,Home.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void sendUserToNextActivity() {
        Intent intent = new Intent(MainActivity.this,profilr.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }}