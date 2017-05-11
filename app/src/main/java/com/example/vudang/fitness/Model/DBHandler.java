package com.example.vudang.fitness.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VuDang on 10/05/17.
 */

public class DBHandler extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "Fitness.db";
    // Contacts table name
    private static final String TABLE_EXERSICE = "Exersice";
    // Shops Table Columns names
    private static final String KEY_ID = "IDExersice";
    private static final String KEY_NAME = "NameExersice";
    private static final String KEY_SH_ADDR = "ListItemExersice";
    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    SQLiteDatabase db;
    @Override
    public void onCreate(SQLiteDatabase db) {
        String insert_table = "CREATE TABLE Exersice (IDExersice INTEGER PRIMARY KEY AUTOINCREMENT,NameExersice TEXT," +
                "ListItemExersice  TEXT" + ")";
        db.execSQL(insert_table);
        String insert = "INSERT INTO Exersice (NameExersice,ListItemExersice)" +
                "VALUES ( 'Full Body', '1,2,3,4,5,6')";
        db.execSQL(insert);
        insert_table = "CREATE TABLE ItemExersice (IDItemExersice INTEGER PRIMARY KEY AUTOINCREMENT,NameItemExersice TEXT," +
                               "Image  TEXT)";
        this.db = db;
      //  db.close();

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXERSICE);
        // Creating tables again
        onCreate(db);
    }
    // Adding new exersice
    public void addExersice(Exersice exer) {
        if(db == null || !db.isOpen()) {
            db = getReadableDatabase();
        }
        ContentValues values = new ContentValues();
        values.put("NameExersice", exer.getNameExersice()); // Shop Name
        values.put("ListItemExersice", exer.getListIDItemExersice()); // Shop Phone Number

        db.insert(TABLE_EXERSICE, null, values);
        db.close(); // Closing database connection
    }
    // Get on Exersice
    public List<Exersice> getAllExersice() {
        List<Exersice> List_Exersice = new ArrayList<Exersice>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_EXERSICE;
        if(db == null || !db.isOpen()) {
            db = getReadableDatabase();
        }
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Exersice ex = new Exersice();
                ex.setIDExersice(cursor.getInt(0));
                ex.setNameExersice(cursor.getString(1));
                ex.setListIDItemExersice(cursor.getString(2));
        // Adding contact to list
                List_Exersice.add(ex);
            } while (cursor.moveToNext());
        }
        // return contact list
        return List_Exersice;
    }
}
