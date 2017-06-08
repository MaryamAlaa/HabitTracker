package com.example.youssefalaa.habit;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.youssefalaa.habit.data.HabitContract.HabitEntry;
import com.example.youssefalaa.habit.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {
    HabitDbHelper habitDbHelper = new HabitDbHelper(this);
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insert();
        display();
    }

    private void insert() {
        SQLiteDatabase db = habitDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLOUM_ID, 1);
        values.put(HabitEntry.COLOUM_SATARDAY, "YES");
        values.put(HabitEntry.COLOUM_SUNDAY, "YES");
        values.put(HabitEntry.COLOUM_MONDAY, "YES");
        values.put(HabitEntry.COLOUM_TUESDAY, "YES");
        values.put(HabitEntry.COLOUM_WEDNESDAY, "YES");
        values.put(HabitEntry.COLOUM_THURSDAY, "YES");
        values.put(HabitEntry.COLOUM_FRIDAY, "YES");
        values.put(HabitEntry.COLOUM_ID, 2);
        values.put(HabitEntry.COLOUM_SATARDAY, "YES");
        values.put(HabitEntry.COLOUM_SUNDAY, "YES");
        values.put(HabitEntry.COLOUM_MONDAY, "YES");
        values.put(HabitEntry.COLOUM_TUESDAY, "YES");
        values.put(HabitEntry.COLOUM_WEDNESDAY, "YES");
        values.put(HabitEntry.COLOUM_THURSDAY, "YES");
        values.put(HabitEntry.COLOUM_FRIDAY, "YES");
        db.insert(HabitEntry.TABLE_NAME, null, values);
    }


    public Cursor returnCursor() {
        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        // Create and/or open a database to read from it
        SQLiteDatabase db = habitDbHelper.getReadableDatabase();

        // Perform this raw SQL query "SELECT * FROM pets"
        // to get a Cursor that contains all rows from the pets table.
        String[] projection = {HabitEntry.COLOUM_ID,
                HabitEntry.COLOUM_SATARDAY,
                HabitEntry.COLOUM_SUNDAY,
                HabitEntry.COLOUM_MONDAY,
                HabitEntry.COLOUM_TUESDAY,
                HabitEntry.COLOUM_WEDNESDAY,
                HabitEntry.COLOUM_THURSDAY,
                HabitEntry.COLOUM_FRIDAY};
        cursor = db.query(HabitEntry.TABLE_NAME, projection, null, null, null, null, null);
        return cursor;
    }

    private void display() {
        returnCursor();
        int idColoumIndex = cursor.getColumnIndex(HabitEntry._ID);
        int nameColoumIndex = cursor.getColumnIndex(HabitEntry.COLOUM_SATARDAY);
        try {
            // Display the number of rows in the Cursor (which reflects the number of rows in the
            // pets table in the database).
            TextView displayView = (TextView) findViewById(R.id.habit_text);
            displayView.setText("the pets table contains " + cursor.getCount() + "pets. \n\n ");
            displayView.append(HabitEntry._ID + " - " + HabitEntry.COLOUM_SATARDAY + "\n");

            while (cursor.moveToNext()) {
                int coloumId = cursor.getInt(idColoumIndex);
                String coloumSaturday = cursor.getString(nameColoumIndex);
                displayView.append(("\n" + coloumId + " - " + coloumSaturday));
            }
        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }


    }
}
