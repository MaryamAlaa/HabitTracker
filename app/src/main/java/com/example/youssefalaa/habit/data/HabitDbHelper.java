package com.example.youssefalaa.habit.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.youssefalaa.habit.data.HabitContract.HabitEntry;

/**
 * Created by youssef alaa on 06/06/2017.
 */
public class HabitDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "habit.db";
    private static final int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_HABIT_TABLE = "CREATE TABLE " + HabitEntry.TABLE_NAME + " ("
                + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitEntry.COLOUM_SATARDAY + " TEXT NOT NULL, "
                + HabitEntry.COLOUM_SUNDAY + " TEXT, "
                + HabitEntry.COLOUM_MONDAY + " TEXT, "
                + HabitEntry.COLOUM_TUESDAY + " TEXT, "
                + HabitEntry.COLOUM_WEDNESDAY + " TEXT, "
                + HabitEntry.COLOUM_THURSDAY + " TEXT NOT NULL, "
                + HabitEntry.COLOUM_FRIDAY + " TEXT NOT NULL DEFAULT 0);";
        db.execSQL(SQL_CREATE_HABIT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
