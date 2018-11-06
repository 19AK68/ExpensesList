package com.ak.user.expenseslist.objects;

import android.app.Application;

import com.ak.user.expenseslist.DataBase.DbAdapter;

public class AppContext extends Application
{

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        dbAdapter = new DbAdapter(this);
    }


    private static DbAdapter dbAdapter;


    public static DbAdapter getDbAdapter() {
        return dbAdapter;
    }
}
