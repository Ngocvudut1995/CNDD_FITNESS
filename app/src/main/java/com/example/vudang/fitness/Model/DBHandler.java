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
        String create_table = "CREATE TABLE Exersice (IDExersice INTEGER PRIMARY KEY AUTOINCREMENT,NameExersice TEXT," +
                "ListItemExersice  TEXT" + ")";
        db.execSQL(create_table);
        String insert = "INSERT INTO Exersice (NameExersice,ListItemExersice)" +
                "VALUES ( 'Full Body', '1,2,3,4,5,6')";
        db.execSQL(insert);
        create_table = "CREATE TABLE ItemExersice (IDItemExersice INTEGER PRIMARY KEY AUTOINCREMENT,NameItemExersice TEXT," +
                               "Image  TEXT)";
        db.execSQL(create_table);
        for(int i = 0;i<5;i++){
            insert ="INSERT INTO ItemExersice (NameItemExersice,Image) " +
                    "VALUES ( 'Exersice "+(i+1)+"', 'fitness"+(i+1)+"')";
            db.execSQL(insert);
        }
        create_table = "CREATE TABLE Setting (TimeRunning INTEGER ,TimeBreaking INTEGER,Sound INTEGER, " +
                "Color  TEXT)";
        db.execSQL(create_table);
        insert ="INSERT INTO Setting (TimeRunning,TimeBreaking,Sound,Color) " +
                "VALUES (30, 10,0,'red')";
        db.execSQL(insert);
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
    // Get Exersice by id
    public Exersice getExersiceByID(int id) {
        Exersice ex = new Exersice();
        String selectQuery = "SELECT * FROM " + TABLE_EXERSICE+" where IDExersice = "+id;
        if(db == null || !db.isOpen()) {
            db = getReadableDatabase();
        }
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
                ex.setIDExersice(cursor.getInt(0));
                ex.setNameExersice(cursor.getString(1));
                ex.setListIDItemExersice(cursor.getString(2));
        }
        return ex;
    }
    // Get Exersice by id
    public SubExersise getItemExersiseByID(int id) {
        SubExersise ex = new SubExersise();
        String selectQuery = "SELECT * FROM ItemExersice where IDItemExersice = "+id;
        if(db == null || !db.isOpen()) {
            db = getReadableDatabase();
        }
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            ex.setIDItemExersise(cursor.getInt(0));
            ex.setNameItemExersise(cursor.getString(1));
            ex.setImage(cursor.getString(2));
        }
        return ex;
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
    public boolean setSetting(Setting setting){
        String query = "Update Setting set TimeRunning = "+setting.getTime_running()+"," +
                "TimeBreaking = "+setting.getTime_break()+",Sound ="+setting.isSound()+" " +
                ",Color = '"+setting.getColor()+"'";
        try {

            if(db == null || !db.isOpen()) {
                db = getReadableDatabase();
            }
            db.execSQL(query);
            return true;
        }catch (Exception ex){
            return false;
        }


//        ContentValues values = new ContentValues();
//        values.put("TimeRunning", setting.getTime_running());
//        values.put("TimeBreaking", setting.getTime_break());
//        values.put("Sound", setting.isSound());
//        values.put("Color", setting.getColor());
//// updating row
//        return db.update("Setting", values, "ID" + " = ?",
//                new String[]{String.valueOf(shop.getId())});
    }
    public Setting getSetting(){
        Setting setting = new Setting();
        String selectQuery = "SELECT * FROM Setting" ;
        if(db == null || !db.isOpen()) {
            db = getReadableDatabase();
        }
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
                setting.setTime_running(cursor.getInt(0));
                setting.setTime_break(cursor.getInt(1));
                setting.setSound(cursor.getInt(2)>0);
            setting.setColor(cursor.getString(3));
        }

        return setting;
    }
}
