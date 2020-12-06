package com.example.happyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import Controller.DataController;
import Model.DatabaseHandler;

public class RateActivity extends AppCompatActivity {
    RatingBar ratingBar;
    Button btnRateOkay;
    DatabaseHandler objectDatabaseHandler;
    TextView lblDate;
    String formattedDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        ratingBar = findViewById(R.id.ratingBar);
        btnRateOkay = findViewById(R.id.btnRateOkay);
        lblDate = findViewById(R.id.lblDate);


        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        formattedDate = df.format(c).toString();
        lblDate.setText("Today is "+formattedDate);

    }

    public  void clickedbtnRateOkay(View view){
        objectDatabaseHandler = new DatabaseHandler(this);

        System.out.println("RATING"+ ratingBar.getRating());
        try {
            objectDatabaseHandler.tryPopulateDB(new DataController(ratingBar.getRating(),"08-Dec-2020","hello world"));
            //objectDatabaseHandler.tryPopulateDB(new DataController(ratingBar.getRating(),formattedDate,"hello world"));
        }
        catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }


    }


}