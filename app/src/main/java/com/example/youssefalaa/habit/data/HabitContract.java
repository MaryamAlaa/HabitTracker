package com.example.youssefalaa.habit.data;

import android.provider.BaseColumns;

/**
 * Created by youssef alaa on 06/06/2017.
 */

public final class HabitContract {
    public class HabitEntry implements BaseColumns {
        public static final String TABLE_NAME = "HabitTracker";
        public static final String COLOUM_ID = BaseColumns._ID;
        public static final String COLOUM_SATARDAY = "saturday";
        public static final String COLOUM_SUNDAY = "sunday";
        public static final String COLOUM_MONDAY = "monday";
        public static final String COLOUM_TUESDAY = "tuesday";
        public static final String COLOUM_WEDNESDAY = "wednesday";
        public static final String COLOUM_THURSDAY = "thursday";
        public static final String COLOUM_FRIDAY = "friday";
    }
}