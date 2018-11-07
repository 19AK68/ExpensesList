package com.ak.user.expenseslist.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ak.user.expenseslist.DataBase.Model.SPROperationType;

public class DbHelper extends SQLiteOpenHelper
{

    public static final String DB_NAME = "money.db";
    public static final int DB_VERSION = 1;


    public static final String LOG_TAG = DbContract.class.getSimpleName();


    //consructor

    public DbHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //create table
        db.execSQL(DbContract.SPROperationType.CREATE_spr_operationType);
        db.execSQL(DbContract.SPROperationSource.CREATE_spr_operationSource);
        db.execSQL(DbContract.SPRCurrency.CREATE_spr_Currency);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}




