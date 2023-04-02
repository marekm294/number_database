package com.example.number_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBasaHelper extends SQLiteOpenHelper {
    public DataBasaHelper(@Nullable Context context) {
        super(context, "numbers.db", null, 1);
    }

    private static final String NUMBER_TABLE = "NUMBER_TABLE";
    private static final String COLUMN_ZERO = "COLUMN_ZERO";
    private static final String COLUMN_ONE = "COLUMN_ONE";
    private static final String COLUMN_TWO = "COLUMN_TWO";
    private static final String COLUMN_THREE = "COLUMN_THREE";
    private static final String COLUMN_FOUR = "COLUMN_FOUR";
    private static final String COLUMN_FIVE = "COLUMN_FIVE";
    private static final String COLUMN_SIX = "COLUMN_SIX";
    private static final String COLUMN_SEVEN = "COLUMN_SEVEN";
    private static final String COLUMN_EIGHT = "COLUMN_EIGTH";
    private static final String COLUMN_NINE = "COLUMN_NINE";
    private static final String COLUMN_ID = "ID";

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + NUMBER_TABLE + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_ZERO + " INTEGER, "
                + COLUMN_ONE + " INTEGER, "
                + COLUMN_TWO + " INTEGER, "
                + COLUMN_THREE + " INTEGER, "
                + COLUMN_FOUR + " INTEGER, "
                + COLUMN_FIVE + " INTEGER, "
                + COLUMN_SIX + " INTEGER, "
                + COLUMN_SEVEN + " INTEGER, "
                + COLUMN_EIGHT + " INTEGER, "
                + COLUMN_NINE + " INTEGER )";
        db.execSQL(createTable);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void addZeros(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ZERO, 0);
        cv.put(COLUMN_ONE, 0);
        cv.put(COLUMN_TWO, 0);
        cv.put(COLUMN_THREE, 0);
        cv.put(COLUMN_FOUR, 0);
        cv.put(COLUMN_FIVE, 0);
        cv.put(COLUMN_SIX, 0);
        cv.put(COLUMN_SEVEN, 0);
        cv.put(COLUMN_EIGHT, 0);
        cv.put(COLUMN_NINE, 0);

        db.insert(NUMBER_TABLE,null, cv);
        db.close();

    }
    public int getZero(){
        SQLiteDatabase db = this.getReadableDatabase();
        String getIt = "SELECT " + COLUMN_ZERO + " FROM " + NUMBER_TABLE;
        Cursor cursor = db.rawQuery(getIt, null);

        cursor.moveToFirst();
        int returnValue = cursor.getInt(0);
        cursor.close();
        db.close();
        return returnValue;
    }
    public int getOne(){
        SQLiteDatabase db = this.getReadableDatabase();
        String getIt = "SELECT " + COLUMN_ONE + " FROM " + NUMBER_TABLE;
        Cursor cursor = db.rawQuery(getIt, null);

        cursor.moveToFirst();
        int returnValue = cursor.getInt(0);
        cursor.close();
        db.close();
        return returnValue;
    }
    public int getTwo(){
        SQLiteDatabase db = this.getReadableDatabase();
        String getIt = "SELECT " + COLUMN_TWO + " FROM " + NUMBER_TABLE;
        Cursor cursor = db.rawQuery(getIt, null);

        cursor.moveToFirst();
        int returnValue = cursor.getInt(0);
        cursor.close();
        db.close();
        return returnValue;
    }
    public int getThree(){
        SQLiteDatabase db = this.getReadableDatabase();
        String getIt = "SELECT " + COLUMN_THREE + " FROM " + NUMBER_TABLE;
        Cursor cursor = db.rawQuery(getIt, null);

        cursor.moveToFirst();
        int returnValue = cursor.getInt(0);
        cursor.close();
        db.close();
        return returnValue;
    }
    public int getFour(){
        SQLiteDatabase db = this.getReadableDatabase();
        String getIt = "SELECT " + COLUMN_FOUR + " FROM " + NUMBER_TABLE;
        Cursor cursor = db.rawQuery(getIt, null);

        cursor.moveToFirst();
        int returnValue = cursor.getInt(0);
        cursor.close();
        db.close();
        return returnValue;
    }
    public int getFive(){
        SQLiteDatabase db = this.getReadableDatabase();
        String getIt = "SELECT " + COLUMN_FIVE + " FROM " + NUMBER_TABLE;
        Cursor cursor = db.rawQuery(getIt, null);

        cursor.moveToFirst();
        int returnValue = cursor.getInt(0);
        cursor.close();
        db.close();
        return returnValue;
    }
    public int getSix(){
        SQLiteDatabase db = this.getReadableDatabase();
        String getIt = "SELECT " + COLUMN_SIX + " FROM " + NUMBER_TABLE;
        Cursor cursor = db.rawQuery(getIt, null);

        cursor.moveToFirst();
        int returnValue = cursor.getInt(0);
        cursor.close();
        db.close();
        return returnValue;
    }
    public int getSeven(){
        SQLiteDatabase db = this.getReadableDatabase();
        String getIt = "SELECT " + COLUMN_SEVEN + " FROM " + NUMBER_TABLE;
        Cursor cursor = db.rawQuery(getIt, null);

        cursor.moveToFirst();
        int returnValue = cursor.getInt(0);
        cursor.close();
        db.close();
        return returnValue;
    }
    public int getEight(){
        SQLiteDatabase db = this.getReadableDatabase();
        String getIt = "SELECT " + COLUMN_EIGHT + " FROM " + NUMBER_TABLE;
        Cursor cursor = db.rawQuery(getIt, null);

        cursor.moveToFirst();
        int returnValue = cursor.getInt(0);
        cursor.close();
        db.close();
        return returnValue;
    }
    public int getNine(){
        SQLiteDatabase db = this.getReadableDatabase();
        String getIt = "SELECT " + COLUMN_NINE + " FROM " + NUMBER_TABLE;
        Cursor cursor = db.rawQuery(getIt, null);

        cursor.moveToFirst();
        int returnValue = cursor.getInt(0);
        cursor.close();
        db.close();
        return returnValue;
    }

    public Numbers getAll(){
        SQLiteDatabase db = this.getReadableDatabase();
        String getIt = "SELECT * FROM " + NUMBER_TABLE;
        Cursor cursor = db.rawQuery(getIt, null);
        cursor.moveToFirst();
        Numbers numbers = new Numbers(cursor.getInt(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(5),
                cursor.getInt(6), cursor.getInt(7), cursor.getInt(8), cursor.getInt(9), cursor.getInt(10) );
        cursor.close();
        db.close();
        return  numbers;

    }
    public void updateAll(Numbers numbers){
        updateZero(numbers.getZero());
        updateOne(numbers.getOne());
        updateTwo(numbers.getTwo());
        updateThree(numbers.getThree());
        updateFour(numbers.getFour());
        updateFive(numbers.getFive());
        updateSix(numbers.getSix());
        updateSeven(numbers.getSeven());
        updateEight(numbers.getEight());
        updateNine(numbers.getNine());
    }

    public void updateZero(int i){
        SQLiteDatabase db = this.getWritableDatabase();
        String updateIt = "UPDATE " + NUMBER_TABLE + " SET " + COLUMN_ZERO + " = " + i;
        db.execSQL(updateIt);
        db.close();
    }
    public void updateOne(int i){
        SQLiteDatabase db = this.getWritableDatabase();
        String updateIt = "UPDATE " + NUMBER_TABLE + " SET " + COLUMN_ONE + " = " + i;
        db.execSQL(updateIt);
        db.close();
    }
    public void updateTwo(int i){
        SQLiteDatabase db = this.getWritableDatabase();
        String updateIt = "UPDATE " + NUMBER_TABLE + " SET " + COLUMN_TWO + " = " + i;
        db.execSQL(updateIt);
        db.close();
    }
    public void updateThree(int i){
        SQLiteDatabase db = this.getWritableDatabase();
        String updateIt = "UPDATE " + NUMBER_TABLE + " SET " + COLUMN_THREE + " = " + i;
        db.execSQL(updateIt);
        db.close();
    }
    public void updateFour(int i){
        SQLiteDatabase db = this.getWritableDatabase();
        String updateIt = "UPDATE " + NUMBER_TABLE + " SET " + COLUMN_FOUR + " = " + i;
        db.execSQL(updateIt);
        db.close();
    }
    public void updateFive(int i){
        SQLiteDatabase db = this.getWritableDatabase();
        String updateIt = "UPDATE " + NUMBER_TABLE + " SET " + COLUMN_FIVE + " = " + i;
        db.execSQL(updateIt);
        db.close();
    }
    public void updateSix(int i){
        SQLiteDatabase db = this.getWritableDatabase();
        String updateIt = "UPDATE " + NUMBER_TABLE + " SET " + COLUMN_SIX + " = " + i;
        db.execSQL(updateIt);
        db.close();
    }
    public void updateSeven(int i){
        SQLiteDatabase db = this.getWritableDatabase();
        String updateIt = "UPDATE " + NUMBER_TABLE + " SET " + COLUMN_SEVEN + " = " + i;
        db.execSQL(updateIt);
        db.close();
    }
    public void updateEight(int i){
        SQLiteDatabase db = this.getWritableDatabase();
        String updateIt = "UPDATE " + NUMBER_TABLE + " SET " + COLUMN_EIGHT + " = " + i;
        db.execSQL(updateIt);
        db.close();
    }
    public void updateNine(int i){
        SQLiteDatabase db = this.getWritableDatabase();
        String updateIt = "UPDATE " + NUMBER_TABLE + " SET " + COLUMN_NINE + " = " + i;
        db.execSQL(updateIt);
        db.close();
    }

    public int getSizeOfDb(){
        SQLiteDatabase db = this.getReadableDatabase();
        String getSizeOfIt = "SELECT COUNT(*) FROM " + NUMBER_TABLE;
        Cursor cursor = db.rawQuery(getSizeOfIt, null);
        cursor.moveToFirst();
        int returnValue = cursor.getInt(0);
        db.close();
        return returnValue;
    }

}
