package com.example.finalproject301;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class RateUs extends AppCompatActivity {
TextView rateCount,showRating;
EditText review;
Button btnSubmit, button3;
RatingBar ratingbar;
float ratevalue; String temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);


        rateCount = findViewById(R.id.rateCount);
        ratingbar = findViewById(R.id.ratingbar);
        review = findViewById(R.id.review);
        btnSubmit = findViewById(R.id.btnSubmit);
        showRating =findViewById(R.id.showRating);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendtoanotheractivity();
            }
        });


        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                ratevalue= ratingBar.getRating();

                if (ratevalue <= 1 && ratevalue>0)
                    rateCount.setText("Bad" +ratevalue + "/5");
                else if (ratevalue <= 2 && ratevalue>1)
                    rateCount.setText("Ok" +ratevalue + "/5");
                else if (ratevalue <= 3 && ratevalue>2)
                    rateCount.setText("Good" +ratevalue + "/5");
                else if (ratevalue <= 4 && ratevalue>3)
                    rateCount.setText("Very Good" +ratevalue + "/5");
                else if (ratevalue <= 5 && ratevalue>4)
                    rateCount.setText("Excellence" +ratevalue + "/5");
            }
        });
      btnSubmit.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              temp = rateCount.getText().toString();
              showRating.setText("Your Rating: \n"+ temp+ "\n" +review.getText());
              review.setText(" ");
              ratingbar.setRating(0);
              rateCount.setText("");

          }
      });




    }

    private void sendtoanotheractivity() {
        Intent intent = new Intent(RateUs.this, Home.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}