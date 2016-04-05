package com.example.android_lab.mypega;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Maria Dimitrakarakou on 9/25/15.
 */
public class DBHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME ="TeiList.db";
    private static final int DATABASE_VERSION = 1;

    private static final  String TABLE_NAME = "teachers_list";
    private static final  String NAME = "name";
    private static final  String EMAIL = "email";
    private static final  String PHOTO = "photo";




    DBHelper(Context context){
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "("+ NAME +" TEXT NOT NULL," + EMAIL+" TEXT NOT NULL," + PHOTO + " TEXT NOT NULL"+")");

        db.execSQL("INSERT INTO " + TABLE_NAME + "(" + NAME+ ", " + EMAIL+", " + PHOTO +")" +
                "VALUES  ('Christos Ilioudis','iliou@it.teithe.gr', 'ilioudis') ");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(" + NAME+ ", " + EMAIL+", " + PHOTO +")" +
                "VALUES  ('Panagiotis Oikonomou','panawths@gmail.com', 'oikonomou') ");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(" + NAME+ ", " + EMAIL+", " + PHOTO +")" +
                "VALUES  ('Christos Litridis','lytridic@gmail.com', 'litidis') ");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(" + NAME+ ", " + EMAIL+", " + PHOTO +")" +
                "VALUES  ('Ephklidis Keramopoulos','euclid@it.teithe.gr', 'keramopoulos') ");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(" + NAME+ ", " + EMAIL+", " + PHOTO +")" +
                "VALUES  ('Dimitris Bratanis','dimibrat@teiemt.gr', 'bratanis') ");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(" + NAME+ ", " + EMAIL+", " + PHOTO +")" +
                "VALUES  ('Costas Rantos','krantos@teiemt.gr', 'bratanis') ");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(" + NAME+ ", " + EMAIL+", " + PHOTO +")" +
                "VALUES  ('Alexandros Rapsomanikis','alexraps@teiemt.gr', 'rapsomanikis') ");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(" + NAME+ ", " + EMAIL+", " + PHOTO +")" +
                "VALUES  ('Dimosthenis Stamatis','demos@it.teithe.gr', 'stamatis') ");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(" + NAME+ ", " + EMAIL+", " + PHOTO +")" +
                "VALUES  ('Lefteris Moisiadis','lmous@teiemt.gr', 'moisiadis') ");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
