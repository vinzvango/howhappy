package com.example.happyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

import Controller.BarDataController;
import Controller.DataController;
import Model.DatabaseHandler;

import static com.github.mikephil.charting.utils.ColorTemplate.*;

public class BarChartActivity extends AppCompatActivity {

    private DatabaseHandler objectDatabaseHandler;
    private ArrListAdapter objectArrListAdapter;
    private BarDataController objectBarDataController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        //objectArrListAdapter = new ArrListAdapter(objectBarDataController.getChartData());

        try{
            //creating arraylist of ArrListAdapter with databasehandler arraylist






            ArrayList<DataController> objectModelClassList = new ArrayList<>();
            objectModelClassList.add(new DataController(5, "07-Dec-2020"));


        BarChart barChart = findViewById(R.id.barChart);

            Toast.makeText(this, "SIZE"+ objectModelClassList.get(0).getRating(),Toast.LENGTH_LONG).show();
        ArrayList<BarEntry> visitors = new ArrayList<>();
       // visitors.add(new BarEntry();
        //visitors.add(new BarEntry(2020,3));
        //visitors.add(new BarEntry(2020,3));


        BarDataSet barDataSet = new BarDataSet(visitors,"Visitors");
        barDataSet.setColors(MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData bardata = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(bardata);
        barChart.getDescription().setText("Bar Chart Example");
        barChart.animateY(2000);


        }

        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(),Toast.LENGTH_LONG).show();
        }


    }
}