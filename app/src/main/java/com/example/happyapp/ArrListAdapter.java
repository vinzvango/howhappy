package com.example.happyapp;

import java.util.ArrayList;

import Controller.DataController;

class ArrListAdapter {
    ArrayList<DataController> objectModelClassList;

    public ArrListAdapter(ArrayList<DataController> objectModelClassList) {
        this.objectModelClassList = objectModelClassList;
    }

    public int getItemCount() {



        return objectModelClassList.size();




    }





}
