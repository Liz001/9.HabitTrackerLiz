package com.example.android.habittrackerliz;

import android.provider.BaseColumns;

/**
 * Created by Liz on 19/06/2017.
 */

class HabitsContract {

    public static final class HabitEntry implements BaseColumns {
        public static final String TABLE_NAME = "tracking_diary";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_DATE = "date_added";
        public static final String COLUMN_HABIT = "habit";
        public static final String COLUMN_COMMENT = "comment";
        public static final int HABIT_FREE_TIME = 0;
        public static final int HABIT_PROGRAMMING = 1;
        public final static int HABIT_WORKOUT = 2;
    }
}
