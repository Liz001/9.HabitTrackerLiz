package com.example.android.habittrackerliz;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HabitsDbHelper habitsDbHelper = new HabitsDbHelper(this);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = formatter.format(date);
        int dateInt = Integer.parseInt(dateString);

        habitsDbHelper.insertHabits(dateInt, HabitsContract.HabitEntry.HABIT_PROGRAMMING,
                "Programming");
        habitsDbHelper.insertHabits(dateInt, HabitsContract.HabitEntry.HABIT_FREE_TIME,
                "Free time");
        habitsDbHelper.insertHabits(dateInt, HabitsContract.HabitEntry.HABIT_WORKOUT,
                "Workout");
        Cursor cursor = habitsDbHelper.readHabits();
        while (cursor.moveToNext()) {
        }
    }
}
