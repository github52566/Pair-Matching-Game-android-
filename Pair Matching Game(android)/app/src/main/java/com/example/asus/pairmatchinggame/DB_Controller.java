package com.example.asus.pairmatchinggame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

/**
 * Created by ASUS on 2/5/2018.
 */

public class DB_Controller extends SQLiteOpenHelper{

    public DB_Controller(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "TEST.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE PLAYERS (ID INTEGER PRIMARY KEY AUTOINCREMENT,PLAYER_NAME TEXT UNIQUE,SCORE_FINAL TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS PLAYERS;");
        onCreate(sqLiteDatabase);

    }
    public void insert_player(String player_name,String score_final){
        ContentValues contentValues=new ContentValues();
        contentValues.put("PLAYER_NAME",player_name);
        contentValues.put("SCORE_FINAL",score_final);
        this.getWritableDatabase().insertOrThrow("PLAYERS","",contentValues);

    }
    public void delete_player(String player_name){
        this.getWritableDatabase().delete("PLAYERS","PLAYER_NAME='"+player_name+"'",null);
    }
    public void update_player(String old_player_name,String new_player_name){
        this.getWritableDatabase().execSQL("UPDATE PLAYERS SET PLAYER_NAME='"+new_player_name+"'WHERE PLAYER_NAME='"+old_player_name+"'");

    }
    public void list_all_players(TextView textView){
        Cursor cursor=this.getReadableDatabase().rawQuery("SELECT * FROM PLAYERS",null);
        textView.setText("");
        while (cursor.moveToNext()){
            textView.append(cursor.getString(1)+" "+cursor.getString(2)+"\n");
        }
    }
}


