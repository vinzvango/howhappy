package com.example.happyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import Model.DatabaseHandler;

public class JournalActivity extends AppCompatActivity {
    DatabaseHandler objectDatabaseHandler;
    Button btnSubmitJournal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);
        btnSubmitJournal = findViewById(R.id.btnSubmitJournal);



    }


    public void SubmitClicked(View view){

        objectDatabaseHandler = new DatabaseHandler(this);
        objectDatabaseHandler.tryPopulateDB();
    }
}