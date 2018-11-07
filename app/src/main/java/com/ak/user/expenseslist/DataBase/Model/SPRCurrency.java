package com.ak.user.expenseslist.DataBase.Model;

public class SPRCurrency
{

    private int id;
    private String  name;

    //conctructor

    public SPRCurrency(){}

    public SPRCurrency(int id, String name)
    {
        this.id=id;
        this.name=name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
