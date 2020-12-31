package com.example.happyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import Controller.DataController;
import Model.DatabaseHandler;

public class PieChartActivity extends AppCompatActivity {
    /*- PIE CHART JAVA ACTIVITY
     */

    DatabaseHandler objectDatabaseHandler = new DatabaseHandler(this);
    private Button btnDatePickerShower;
    //Long startDate,endDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        ArrayList<DataController> objectModelClassList = new ArrayList<>();


        //--date picker initialization and setup
        btnDatePickerShower = findViewById(R.id.btnDatePickerShower);




        }


    public void GetSelectedDate(View view){
        MaterialDatePicker.Builder<Pair<Long, Long>> builder = MaterialDatePicker.Builder.dateRangePicker();
        builder.setTitleText("SELECT A DATE");
        final MaterialDatePicker materialDatePicker = builder.build();
        materialDatePicker.show(getSupportFragmentManager(), materialDatePicker.toString());

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Pair<Long, Long>>() {


            @Override
            public void onPositiveButtonClick(Pair<Long, Long> selection) {
                Long startDate = selection.first;
                Long endDate = selection.second;
                GetChartData(StrStartDate(startDate),StrEndDate(endDate));
               //sampleStartDateShower(startDate);
            }
        });

    }

    protected String StrStartDate(Long startDate) {
        return new SimpleDateFormat("dd-MMM-yyy").format(new Date(startDate));
        // Toast.makeText(this,strStartDate,Toast.LENGTH_LONG).show();

    }

    protected String StrEndDate(Long endDate) {
        return new SimpleDateFormat("dd-MMM-yyy").format(new Date(endDate));
        // Toast.makeText(this,strStartDate,Toast.LENGTH_LONG).show();
    }


    void sampleStartDateShower(Long startDate){
        String samplestrtDate = new SimpleDateFormat("dd-MMM-yyyy").format(new Date(startDate));
        Toast.makeText(this, samplestrtDate, Toast.LENGTH_SHORT).show();

    }


    public void GetChartData(String strStartDate, String StrEndDate) {

        PieChart pieChart = findViewById(R.id.pieChart);
        ArrayList<DataController> objectModelClassList = new ArrayList<>();
        try{

            //pass objectdatabase arraylist to modelclass
            objectModelClassList = objectDatabaseHandler.getChartData(strStartDate,StrEndDate);
            //creates new arraylist with datatype float for all the ratings
            ArrayList<Float> arrListRating = new ArrayList<>();
            //arraylist for the piechart
            ArrayList<PieEntry> visitors = new ArrayList<>();
            //loops thru the modelclass arraylist to pass all the ratings to the created arrayListRating
            for(int i = 0; i < objectModelClassList.size(); i++){
                arrListRating.add(objectModelClassList.get(i).getRating());
            }
            //loops thru to all the ratings(float)
            // count all occurence of i, if not zero then multiply occurence to the float to get the final value of the rating
            //add to the chart the product of occ * i with corresponding  value
            for(float i=0f; i<5.0; i+=0.5){
                int occ = Collections.frequency(arrListRating,i);
                if (occ!=0){
                    //multiplies occ and index(e.g 3.5) to get the total value
                    float temp = occ *i;
                    //gives labels to every result
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

            //--OTHER PIE CHART COFIGS--//
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