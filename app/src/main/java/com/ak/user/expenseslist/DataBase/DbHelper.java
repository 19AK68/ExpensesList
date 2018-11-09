package com.ak.user.expenseslist.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.ak.user.expenseslist.DataBase.Model.SPROperationType;

public class DbHelper extends SQLiteOpenHelper
{

    public static final String TAG = "LOG";
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
        db.execSQL(DbContract.Operation.DB_CREATE);

        Log.d("LOG","------ OnCreate DbHelper is called db v." + db.getVersion()+"----------");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        Log.d("LOG","------ onUpgrade DbHelper is called and upgrade  from db v." + oldVersion + "to db v." + newVersion+ "----------");

        // Сделать проверку на версию и миграцию по данным через цикл курсок чтенрие в цикл и заполнение

        db.execSQL("DROP TABLE IF EXISTS " + DbContract.SPROperationType.TABLE_NAME_OperationType);
        db.execSQL("DROP TABLE IF EXISTS " + DbContract.SPROperationSource.TABLE_NAME_OperationSource);
        db.execSQL("DROP TABLE IF EXISTS " + DbContract.SPRCurrency.TABLE_NAME_Currency);
        db.execSQL("DROP TABLE IF EXISTS " + DbContract.Operation.TABLE_NAME_OPERATION);


    }
}




