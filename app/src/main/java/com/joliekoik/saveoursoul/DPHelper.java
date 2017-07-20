package com.joliekoik.saveoursoul;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DPHelper extends SQLiteOpenHelper
{
    private final static int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="Lists";
    private static final String TABLE_HOSPITALS = "Hospitals";
    private static final String TABLE_POLICE = "Police";
    private static final String TABLE_FIRE = "Fire";
    private static final String TABLE_WORKSHOP = "Workshop";
    private static final String KEY_NAME="name";
    private static final String KEY_ADDRESS="address";
    private static final String KEY_NUMBER="number";

    public DPHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_HOSPITALS_TABLE="CREATE TABLE "+TABLE_HOSPITALS+"("+KEY_NAME+" TEXT, "+KEY_ADDRESS+" TEXT, "+KEY_NUMBER+" TEXT)";
        db.execSQL(CREATE_HOSPITALS_TABLE);
        String CREATE_POLICE_TABLE="CREATE TABLE "+TABLE_POLICE+"("+KEY_NAME+" TEXT, "+KEY_ADDRESS+" TEXT, "+KEY_NUMBER+" TEXT)";
        db.execSQL(CREATE_POLICE_TABLE);
        String CREATE_FIRE_TABLE="CREATE TABLE "+TABLE_FIRE+"("+KEY_NAME+" TEXT, "+KEY_ADDRESS+" TEXT, "+KEY_NUMBER+" TEXT)";
        db.execSQL(CREATE_FIRE_TABLE);
        String CREATE_WORKSHOP_TABLE="CREATE TABLE "+TABLE_WORKSHOP+"("+KEY_NAME+" TEXT, "+KEY_ADDRESS+" TEXT, "+KEY_NUMBER+" TEXT)";
        db.execSQL(CREATE_WORKSHOP_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contacts"+ TABLE_HOSPITALS);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS contacts"+ TABLE_POLICE);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS contacts"+ TABLE_FIRE);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS contacts"+ TABLE_WORKSHOP);
        onCreate(db);

    }

    public void addHospital(String name, String address, String number) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_ADDRESS, address);
        values.put(KEY_NUMBER, number);

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_HOSPITALS, null, values);
        db.close();
    }


    public String[] getHospitalName(){
        SQLiteDatabase db =getWritableDatabase();

        Cursor pointer = db.rawQuery("SELECT "+ KEY_NAME +" FROM "+TABLE_HOSPITALS+" WHERE 1 ", null);
        pointer.moveToFirst();
        String[] hospitalArray = new String[pointer.getCount()];
        int i=0;

        while(!pointer.isAfterLast())
        {
            hospitalArray[i]=pointer.getString(0);
            i++;
            pointer.moveToNext();

        }

        db.close();

        return hospitalArray;

    }

    public String[] getHospitalDetails(String name)
    {
        SQLiteDatabase db = getWritableDatabase();

        Cursor pointer = db.rawQuery("SELECT " + KEY_ADDRESS + ", " + KEY_NUMBER + " FROM "+TABLE_HOSPITALS+" WHERE " + KEY_NAME + "='" + name + "';",null);
        pointer.moveToFirst();
        String[] hospitalArray= new String[2];

        //int i=0;

        if(pointer!=null)
        {
            pointer.moveToFirst();
            hospitalArray[0] = pointer.getString(0);
            hospitalArray[1] = pointer.getString(1);
        }

        db.close();

        return hospitalArray;


    }

    public void addPolice(String name, String address, String number ) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_ADDRESS, address);
        values.put(KEY_NUMBER, number);



        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_POLICE, null, values);
        db.close();
    }

    public String[] getPoliceName(){
        SQLiteDatabase db=getWritableDatabase();

        Cursor pointer = db.rawQuery("SELECT "+ KEY_NAME +" FROM "+TABLE_POLICE+" WHERE 1 ", null);
        pointer.moveToFirst();
        String[] policeArray = new String[pointer.getCount()];
        int i=0;

        while(!pointer.isAfterLast())
        {
            policeArray[i]=pointer.getString(0);
            i++;
            pointer.moveToNext();

        }

        db.close();

        return policeArray;

    }

    public String[] getPoliceDetails(String name)
    {
        SQLiteDatabase db = getWritableDatabase();

        Cursor pointer = db.rawQuery("SELECT " + KEY_ADDRESS + ", " + KEY_NUMBER + " FROM "+TABLE_POLICE+" WHERE " + KEY_NAME + "='" + name + "';",null);
        pointer.moveToFirst();
        String[] policeArray= new String[2];

        //int i=0;

        if(pointer!=null)
        {
            pointer.moveToFirst();
            policeArray[0] = pointer.getString(0);
            policeArray[1] = pointer.getString(1);
        }

        db.close();

        return policeArray;


    }

    public void addFire(String name, String address, String number ) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_ADDRESS, address);
        values.put(KEY_NUMBER, number);



        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_FIRE, null, values);
        db.close();
    }

    public String[] getFireName(){
        SQLiteDatabase db=getWritableDatabase();

        Cursor pointer = db.rawQuery("SELECT "+ KEY_NAME +" FROM "+TABLE_FIRE+" WHERE 1 ", null);
        pointer.moveToFirst();
        String[] fireArray = new String[pointer.getCount()];
        int i=0;

        while(!pointer.isAfterLast())
        {
            fireArray[i]=pointer.getString(0);
            i++;
            pointer.moveToNext();

        }

        db.close();

        return fireArray;

    }

    public String[] getFireDetails(String name)
    {
        SQLiteDatabase db = getWritableDatabase();

        Cursor pointer = db.rawQuery("SELECT " + KEY_ADDRESS + ", " + KEY_NUMBER + " FROM "+TABLE_FIRE+" WHERE " + KEY_NAME + "='" + name + "';",null);
        pointer.moveToFirst();
        String[] fireArray= new String[2];

        //int i=0;

        if(pointer!=null)
        {
            pointer.moveToFirst();
            fireArray[0] = pointer.getString(0);
            fireArray[1] = pointer.getString(1);
        }

        db.close();

        return fireArray;


    }

    public void addWorkshop(String name, String address, String number ) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_ADDRESS, address);
        values.put(KEY_NUMBER, number);



        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_WORKSHOP, null, values);
        db.close();
    }

    public String[] getWorkshopName(){
        SQLiteDatabase db=getWritableDatabase();

        Cursor pointer = db.rawQuery("SELECT "+ KEY_NAME +" FROM "+TABLE_WORKSHOP+" WHERE 1 ", null);
        pointer.moveToFirst();
        String[] workshopArray = new String[pointer.getCount()];
        int i=0;

        while(!pointer.isAfterLast())
        {
            workshopArray[i]=pointer.getString(0);
            i++;
            pointer.moveToNext();

        }

        db.close();

        return workshopArray;

    }

    public String[] getWorkshopDetails(String name)
    {
        SQLiteDatabase db = getWritableDatabase();

        Cursor pointer = db.rawQuery("SELECT " + KEY_ADDRESS + ", " + KEY_NUMBER + " FROM "+TABLE_WORKSHOP+" WHERE " + KEY_NAME + "='" + name + "';",null);
        pointer.moveToFirst();
        String[] workshopArray= new String[2];

        //int i=0;

        if(pointer!=null)
        {
            pointer.moveToFirst();
            workshopArray[0] = pointer.getString(0);
            workshopArray[1] = pointer.getString(1);
        }

        db.close();

        return workshopArray;


    }


}