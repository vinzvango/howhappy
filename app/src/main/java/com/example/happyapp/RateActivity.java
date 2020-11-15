package com.example.happyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import Controller.DataController;
import Model.DatabaseHandler;

public class RateActivity extends AppCompatActivity {
    RatingBar ratingBar;
    Button btnRateOkay;
    DatabaseHandler objectDatabaseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        ratingBar = findViewById(R.id.ratingBar);
        btnRateOkay = findViewById(R.id.btnRateOkay);

    }

    public  void clickedbtnRateOkay(View view){
        objectDatabaseHandler = new DatabaseHandler(this);

        System.out.println("RATING"+ ratingBar.getRating());
        try {
            objectDatabaseHandler.tryPopulateDB(new DataController(ratingBar.getRating(),"Nov-15-2020","hello world"));

        }
        catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }


    }


}