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



        objectModelClassList = objectDatabaseHandler.getChartData();
        ArrayList<Float> arrListRating = new ArrayList<>();

        ArrayList<PieEntry> visitors = new ArrayList<>();

        for(int i = 0; i < objectModelClassList.size(); i++){
            arrListRating.add(objectModelClassList.get(i).getRating());
        }



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

        //int occurrences = Collections.frequency(objectModelClassList,5.0f);

       //System.out.println("OCCURENCES2 "+ occurrences);



        //Toast.makeText(this, occurrences, Toast.LENGTH_SHORT).show();




        //-------Adds the items to the chart...
        //visitors.add(new PieEntry(arrListRating.get(0)));

        //visitors.add(new PieEntry(objectModelClassList.get(0).getRating(),objectModelClassList.get(0).getDate()));
        //visitors.add(new PieEntry(objectModelClassList.get(1).getRating(),objectModelClassList.get(1).getDate()));
       // visitors.add(new PieEntry(objectModelClassList.get(2).getRating(),objectModelClassList.get(3).getDate()));
        //visitors.add(new PieEntry(objectModelClassList.get(4).getRating(),objectModelClassList.get(4).getDate()));

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