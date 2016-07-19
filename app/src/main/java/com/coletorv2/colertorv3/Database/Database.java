package com.coletorv2.colertorv3.Database;

/**
 * Created by Raphael on 03/03/2016.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper{

    public Database(Context context)
    {
        super(context, "COLETOR ",null,1);


    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(scriptsql.getCreateContato());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
