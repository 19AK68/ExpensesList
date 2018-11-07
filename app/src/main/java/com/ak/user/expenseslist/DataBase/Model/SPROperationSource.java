package com.ak.user.expenseslist.DataBase.Model;

public class SPROperationSource
{


    private int id;
    private String  name;
    private int type_id;


    public SPROperationSource(){}

    public SPROperationSource(int id, String name, int type_id)
    {
        this.id=id;
        this.name=name;
        this.type_id=type_id;
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

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }
}
