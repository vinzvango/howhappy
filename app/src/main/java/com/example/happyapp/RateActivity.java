package com.example.happyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class RateActivity extends AppCompatActivity {
    RatingBar ratingBar;
    Button btnRateOkay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        ratingBar = findViewById(R.id.ratingBar);
        btnRateOkay = findViewById(R.id.btnRateOkay);

    }

    public  void clickedbtnRateOkay(View view){

        System.out.println(ratingBar.getRating());


    }


}