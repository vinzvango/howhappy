package com.example.happyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Collections;

import Controller.DataController;
import Model.DatabaseHandler;

public class PieChartActivity extends AppCompatActivity {
    DatabaseHandler objectDatabaseHandler = new DatabaseHandler(this);
    ArrListAdapter objectArrListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        PieChart pieChart = findViewById(R.id.pieChart);

        ArrayList<DataController> objectModelClassList = new ArrayList<>();

    try{


        //pass objectdatabase arraylist to modelclass
        objectModelClassList = objectDatabaseHandler.getChartData();
        //creates new arraylist with datatype float for all the ratings
        ArrayList<Float> arrListRating = new ArrayList<>();
        //arraylist for the piechart
        ArrayList<PieEntry> visitors = new ArrayList<>();
        //loops thru the modelclass arraylist to pass all the ratings to the created arraylistrating
        for(int i = 0; i < objectModelClassList.size(); i++){
            arrListRating.add(objectModelClassList.get(i).getRating());
        }
        //loops thru to all the ratings(float)
        // count all occurence of i, if not zero then multiply occurence to the float to get the final value of the rating
        //add to the chart the product of occ * i with corresponding  value
            for(float i=0f; i<5.0; i+=0.5){
                int occ = Collections.frequency(arrListRating,i);
                if (occ!=0){
                    float temp = occ *i;
                    if (i == 1.0f) {
                        visitors.add(new PieEntry(temp, "Depressed"));
                    } else if (i == 1.5f) {
                        visitors.add(new PieEntry(temp, "Very Sad"));
                    } else if (i == 2.0f) {
                        visitors.add(new PieEntry(temp, "Sad"));
                    } else if (i == 2.5f) {
                        visitors.add(new PieEntry(temp, "Not Sure"));
                    } else if (i == 3.0f) {
                        visitors.add(new PieEntry(temp, "Satisfied"));
                    } else if (i == 3.5f) {
                        visitors.add(new PieEntry(temp, "Probably Okay"));
                    } else if (i == 4.0f) {
                        visitors.add(new PieEntry(temp, "Good!"));
                    } else if (i == 4.5f) {
                        visitors.add(new PieEntry(temp, "Very Good!"));
                    } else if (i == 5.0f) {
                        visitors.add(new PieEntry(temp, "Confident and Happy"));
                    }

                }
            }


        PieDataSet pieDataSet = new PieDataSet(visitors,"Mood");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Mood");
        pieChart.animate();

    }catch (Exception e){
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

    }
    }
}