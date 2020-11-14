package Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;

public class DatabaseHandler extends SQLiteOpenHelper
{

    Context context;
    private static String DATABASE_NAME="mydb.db";
    private static int DATABASE_VERSION=1;

    private static final String TABLE_NAME = "HowHappyDB";
    private static String createTableQuery = ("CREATE TABLE "+ TABLE_NAME +"  (ID INTEGER PRIMARY KEY AUTOINCREMENT,RATING DOUBLE,DATE TEXT, JOURNAL TEXT)");

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION );
        this.context = context;


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            //Execute creation of table
            db.execSQL(createTableQuery);
            //Toast if Table is successfully created in DB
            Toast.makeText(context, "Table Created successfully inside our database",Toast.LENGTH_SHORT).show();

        }  catch (Exception e)
        {
            Toast.makeText(context, e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void getTableName(){
        Toast.makeText(context, createTableQuery,Toast.LENGTH_LONG).show();

    }

    public void tryPopulateDB(){

        try
        {

            SQLiteDatabase objectSQLiteDatabase = this.getWritableDatabase();

            ContentValues objectContentValues = new ContentValues();
            //object holds the parameter passed by ModelClass

            //CODE FOR POPULATING
            objectContentValues.put("RATING",1.5);
            objectContentValues.put("DATE","mm/dd/yy");
            objectContentValues.put("JOURNAL","sample text");


            //Stores data to the table -- imageInfo
            long checkIfQueryRuns= objectSQLiteDatabase.insert(TABLE_NAME,null,objectContentValues);
            if(checkIfQueryRuns!=1){
                Toast.makeText(context, "SAVED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                //--NOTE: can put some good window for sucessfully saving
                //objectSQLiteDatabase.close();

            }else{
                Toast.makeText(context,"SAVING UNSUCCESSFUL", Toast.LENGTH_SHORT).show();
                //--NOTE: can put some good window for unsucessfully saving
            }

        }catch (Exception e){
            Toast.makeText(context, e.getMessage(),Toast.LENGTH_SHORT).show();
        }




    }


}
