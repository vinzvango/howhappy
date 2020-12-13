package Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.ContactsContract;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import Controller.DataController;

public class DatabaseHandler extends SQLiteOpenHelper {

    Context context;
    private static String DATABASE_NAME = "mydb.db";
    private static int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "HowHappyDB";
    private static String createTableQuery = ("CREATE TABLE " + TABLE_NAME + "  (ID INTEGER PRIMARY KEY AUTOINCREMENT,RATING FLOAT,DATE TEXT, JOURNAL TEXT)");

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            //Execute creation of table
            db.execSQL(createTableQuery);
            //db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
            //Toast if Table is successfully created in DB
            Toast.makeText(context, "Table Created successfully inside our database", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void getTableName() {
        Toast.makeText(context, createTableQuery, Toast.LENGTH_LONG).show();

    }

    public void tryPopulateDB(DataController dataController) {

        try {

            SQLiteDatabase objectSQLiteDatabase = this.getWritableDatabase();

            ContentValues objectContentValues = new ContentValues();
            //object holds the parameter passed by ModelClass

            //CODE FOR POPULATING
            objectContentValues.put("RATING", dataController.getRating());
            objectContentValues.put("DATE", dataController.getDate());
            objectContentValues.put("JOURNAL", "hello world");


            //Stores data to the table -- imageInfo
            long checkIfQueryRuns = objectSQLiteDatabase.insert(TABLE_NAME, null, objectContentValues);
            if (checkIfQueryRuns != 1) {
                Toast.makeText(context, "SAVED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                //--NOTE: can put some good window for sucessfully saving
                //objectSQLiteDatabase.close();

            } else {
                Toast.makeText(context, "SAVING UNSUCCESSFUL", Toast.LENGTH_SHORT).show();
                //--NOTE: can put some good window for unsucessfully saving
            }

        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
        }


    }

    public ArrayList<DataController> getChartData() {

        //--ArrayList which gets the data from the DB by date--//
        try {
            String queryString = "select * from "+TABLE_NAME+" WHERE DATE = ";
            String queryDateString;
            ArrayList<DataController> objectModelClassList = new ArrayList<>();
            SQLiteDatabase objectSQLiteDatabase = this.getWritableDatabase();

            Cursor objectCursor = objectSQLiteDatabase.rawQuery("select * from "+TABLE_NAME+" WHERE DATE = '08-Dec-2020' " ,null);
            //Cursor objectCursor = objectSQLiteDatabase.rawQuery("select * from "+TABLE_NAME+" WHERE DATE = '08-Dec-2020' " ,null);
            if(objectCursor.getCount() != 0 ) {
                while (objectCursor.moveToNext()) {
                    //loops until the end of the record and add item to the arraylist
                    objectModelClassList.add(new DataController(objectCursor.getFloat(1),objectCursor.getString(2)));
                    Toast.makeText(context, "DB NOT ZERO", Toast.LENGTH_SHORT).show();
                }
                return objectModelClassList;
            }else
                Toast.makeText(context, "VALUE NOT IN DB",Toast.LENGTH_SHORT).show();
                return null;
        }catch (Exception e){
            Toast.makeText(context, e.getMessage(),Toast.LENGTH_LONG).show();

        }
        return null;
    }
}
