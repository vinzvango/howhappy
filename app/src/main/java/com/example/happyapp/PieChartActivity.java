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


        ArrayList<PieEntry> visitors = new ArrayList<>();
        //visitors.add(new PieEntry(objectModelClassList.get(0).getRating(),objectModelClassList.get(0).getDate()));

        visitors.add(new PieEntry(objectModelClassList.get(0).getRating(),objectModelClassList.get(0).getDate()));
        visitors.add(new PieEntry(objectModelClassList.get(1).getRating(),objectModelClassList.get(1).getDate()));
        visitors.add(new PieEntry(objectModelClassList.get(3).getRating(),objectModelClassList.get(3).getDate()));
        visitors.add(new PieEntry(objectModelClassList.get(4).getRating(),objectModelClassList.get(4).getDate()));

        PieDataSet pieDataSet = new PieDataSet(visitors,"Visitors");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Visitors");
        pieChart.animate();

    }catch (Exception e){
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

    }
    }
}