package com.ak.user.expenseslist.DataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DbAdapter
{

    private DbHelper dbHelper;
    private Context context;
    private SQLiteDatabase db;


    // Constructor
    public DbAdapter(Context context) {
        this.context = context;
    }

    public void createDatabaseInstance(){
        dbHelper = new DbHelper(context);
        db = dbHelper.getReadableDatabase();
    }

    public void getOperationsList()
    {

        Cursor c = db.query(DbContract.Operation.TABLE_NAME_OPERATION, null, null, null, null, null, null);

        if (c!=null){
            while (c.moveToNext()){
                System.out.println(c.getInt(c.getColumnIndex("amount")));
            }
        }

        int ff = 1;
    }

}
