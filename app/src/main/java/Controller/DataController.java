package Controller;

import android.database.DatabaseErrorHandler;

public class DataController {

    private float Rating;
    private String Date;
    private String Journal;


    public DataController(float rating, String date, String journal) {
        Rating = rating;
        Date = date;
        Journal = journal;
    }

    public DataController(float rating, String date) {
        Rating = rating;
        Date = date;

    }

    public DataController(DatabaseErrorHandler objectDatabaseHandler) {
    }


    public float getRating() {
        return Rating;
    }

    public void setRating(float rating) {
        Rating = rating;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getJournal() {
        return Journal;
    }

    public void setJournal(String journal) {
        Journal = journal;
    }




}
