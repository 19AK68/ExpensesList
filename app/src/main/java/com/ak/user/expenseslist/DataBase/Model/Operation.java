package com.ak.user.expenseslist.DataBase.Model;

public class Operation
{

    private int id;
    private String date_operation ;
    private int amount ;
    private int type_id ;
    private int currency_id ;
    private int source_id ;

    public Operation(){}

    public Operation(int id,String date_operation,int amount, int type_id,int currency_id,int source_id)

    {
        this.id=id;
        this.date_operation=date_operation;
        this.amount=amount;
        this.type_id=type_id;
        this.currency_id=currency_id;
        this.source_id=source_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate_operation() {
        return date_operation;
    }

    public void setDate_operation(String date_operation) {
        this.date_operation = date_operation;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(int currency_id) {
        this.currency_id = currency_id;
    }

    public int getSource_id() {
        return source_id;
    }

    public void setSource_id(int source_id) {
        this.source_id = source_id;
    }
}
