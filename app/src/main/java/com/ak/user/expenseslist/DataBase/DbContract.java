package com.ak.user.expenseslist.DataBase;

import android.provider.BaseColumns;

import com.ak.user.expenseslist.DataBase.Model.SPROperationType;

import static com.ak.user.expenseslist.DataBase.DbContract.SPRCurrency.TABLE_NAME_Currency;
import static com.ak.user.expenseslist.DataBase.DbContract.SPROperationSource.TABLE_NAME_OperationSource;
import static com.ak.user.expenseslist.DataBase.DbContract.SPROperationType.TABLE_NAME_OperationType;

public class DbContract
{
    // constructor
    private DbContract(){}

    public static final class SPROperationType implements BaseColumns
    {
        public final static String TABLE_NAME_OperationType = "spr_OperationType";
        public final static String _id = BaseColumns._ID;
        public final static String name = "name";



       public final static String CREATE_spr_operationType = "CREATE TABLE " + TABLE_NAME_OperationType+ " ("
                + _id + "INTEGER PRIMARY KEY ON CONFLICT FAIL AUTOINCREMENT,"
                +  name + "NVARCHAR NOT NULL);";
    }

    public static final class SPROperationSource implements BaseColumns
    {
        public final static String TABLE_NAME_OperationSource = "spr_OperationSource";
        public final static String _id = BaseColumns._ID;
        public final static String name = "name";
        public final static String type_id = "type_id";


        public final static String CREATE_spr_operationSource = "CREATE TABLE " + TABLE_NAME_OperationSource + " ("
                + _id + "INTEGER PRIMARY KEY ON CONFLICT FAIL AUTOINCREMENT,"
                +  name + "TEXT NOT NULL,"
                + type_id + "INTEGER,"
                + "CONSTRAINT fk_type" + "FOREIGN KEY (" + _id + ")" + "REFERENCES" + TABLE_NAME_OperationType + "(" + _id + ")"+ "ON DELETE RESTRICT ON UPDATE CASCADE );" ;

    }

    public static final class SPRCurrency implements BaseColumns
    {
        public final static String TABLE_NAME_Currency = "spr_Currency";
        public final static String _id = BaseColumns._ID;
        public final static String name = "name";



        public final static String CREATE_spr_Currency = "CREATE TABLE " + TABLE_NAME_Currency + " ("
                + _id + "INTEGER PRIMARY KEY ON CONFLICT FAIL AUTOINCREMENT,"
                +  name + "TEXT NOT NULL);";


    }

    public static final class Operation implements BaseColumns
    {
        public final static String TABLE_NAME_OPERATION = "operation";
        public final static String _id = BaseColumns._ID;
        public final static String date_operation = "date_operation";
        public final static String amount = "amount";
        public final static String type_id = "type_id";
        public final static String currency_id = "currency_id";
        public final static String source_id = "type_id";



        public final static String DB_CREATE = "CREATE TABLE " + TABLE_NAME_OPERATION + " ("
                + _id + "INTEGER PRIMARY KEY ON CONFLICT FAIL AUTOINCREMENT,"
                + date_operation + "TEXT NOT NULL,"
                + amount + "INTEGER NOT NULL,"
                + type_id + "INTEGER NOT NULL,"
                + "CONSTRAINT fk_type" + "FOREIGN KEY (" + type_id + ")" +  "REFERENCES" + TABLE_NAME_OperationType + "(" + _id + ")"+ "ON DELETE RESTRICT ON UPDATE CASCADE,"
                + currency_id + "INTEGER NOT NULL,"
                + "CONSTRAINT fk_currency" + "FOREIGN KEY (" + currency_id + ")" +  "REFERENCES" + TABLE_NAME_Currency  + "(" + _id + ")"+ "ON DELETE RESTRICT ON UPDATE CASCADE,"
                + source_id + "INTEGER NOT NULL,"
                + "CONSTRAINT fk_source" + "FOREIGN KEY (" + type_id + ")" +  "REFERENCES" + TABLE_NAME_OperationSource+ "(" + _id + ")"+ ");";

    }



}
