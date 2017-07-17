package com.example.android.habittrackerliz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Liz on 19/06/2017.
 */

class HabitsDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "habitTrackerLiz.db";
    private static final int DATABASE_VERSION = 1;

    public HabitsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

        @Override
        public void onCreate (SQLiteDatabase sqLiteDatabase){
            String CREATE_TABLE_TRACKING_DIARY = "CREATE TABLE " + HabitsContract.HabitEntry.TABLE_NAME +
                    "(" + HabitsContract.HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    HabitsContract.HabitEntry.COLUMN_DATE + " INTEGER NOT NULL," +
                    HabitsContract.HabitEntry.COLUMN_HABIT + " INTEGER NOT NULL," +
                    HabitsContract.HabitEntry.COLUMN_COMMENT + " STRING);";
            Log.v("HabitsDbHelper", "create table: " + CREATE_TABLE_TRACKING_DIARY);
            sqLiteDatabase.execSQL(CREATE_TABLE_TRACKING_DIARY);
        }

        @Override
        public void onUpgrade (SQLiteDatabase sqLiteDatabase,int i, int i1){
        }

    public void insertHabits(int date, int habit, String comment) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitsContract.HabitEntry.COLUMN_DATE, date);
        values.put(HabitsContract.HabitEntry.COLUMN_HABIT, habit);
        values.put(HabitsContract.HabitEntry.COLUMN_COMMENT, comment);
        db.insert(HabitsContract.HabitEntry.TABLE_NAME, null, values);
    }

    public Cursor readHabits() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                HabitsContract.HabitEntry._ID,
                HabitsContract.HabitEntry.COLUMN_DATE,
                HabitsContract.HabitEntry.COLUMN_HABIT,
                HabitsContract.HabitEntry.COLUMN_COMMENT
        };
        Cursor cursor = db.query(
                HabitsContract.HabitEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }
}