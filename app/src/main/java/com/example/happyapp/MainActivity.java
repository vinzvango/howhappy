package com.example.happyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import Model.DatabaseHandler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnRate = findViewById(R.id.btnRate);
        Button btnJournal = findViewById(R.id.btnJournal);

    }

    public void RateClicked(View view){

        startActivity(new Intent(getApplicationContext(), RateActivity.class));

    }


    public void JournalClicked(View view){

        startActivity(new Intent(getApplicationContext(), JournalActivity.class));


    }

    public void PieChartClicked(View view){

        startActivity(new Intent(getApplicationContext(), PieChartActivity.class));


    }





}