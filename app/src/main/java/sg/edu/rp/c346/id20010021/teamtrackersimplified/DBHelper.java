package sg.edu.rp.c346.id20010021.teamtrackersimplified;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Match.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_SONG = "Song";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TEAM = "team";
    private static final String COLUMN_SCORE = "score";
    private static final String COLUMN_TEAM2 = "team2";
    private static final String COLUMN_SCORE2 = "score2";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // CREATE TABLE Song
        // (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT,
        // singers TEXT, stars INTEGER, year INTEGER );
        String createMatchTableSql = "CREATE TABLE " + TABLE_SONG + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_TEAM + " TEXT, "
                + COLUMN_SCORE + " INTEGER"
                + COLUMN_TEAM2 + " TEXT, "
                + COLUMN_SCORE2 + " INTEGER";
        db.execSQL(createMatchTableSql);
        Log.i("info", createMatchTableSql + "\ncreated tables");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SONG);
        onCreate(db);
    }

    public long insertMatch(String team, int score, String team2, int score2) {
        // Get an instance of the database for writing
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TEAM, team);
        values.put(COLUMN_SCORE, score);
        values.put(COLUMN_TEAM2, team2);
        values.put(COLUMN_SCORE2, score2);
        // Insert the row into the TABLE_SONG
        long result = db.insert(team, null, values);
        // Close the database connection
        db.close();
        Log.d("SQL Insert", "" + result);
        return result;
    }

    public ArrayList<Match> getAllMatch() {
        ArrayList<Match>  matchlist = new ArrayList<Match>();

        String selectQuery = "SELECT " + COLUMN_ID + ","
                + COLUMN_TEAM + "," + COLUMN_SCORE + ","
                + COLUMN_TEAM2 + ","
                + COLUMN_SCORE2 + " FROM " + TABLE_SONG;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String team = cursor.getString(1);
                int score = cursor.getInt(2);
                String team2 = cursor.getString(3);
                int score2 = cursor.getInt(4);

                Match newMatch = new Match(id, team, score, team2, score2);
                matchlist.add(newMatch);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return matchlist;
    }


}
