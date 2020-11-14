package com.example.happyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import static com.github.mikephil.charting.utils.ColorTemplate.*;

public class BarChartActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        BarChart barChart = findViewById(R.id.barChart);


        ArrayList<BarEntry> visitors = new ArrayList<>();
        visitors.add(new BarEntry(2014,420));
        visitors.add(new BarEntry(2020,650));
        visitors.add(new BarEntry(2017,476));
        visitors.add(new BarEntry(2018,986));
        visitors.add(new BarEntry(2019,82));

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
}