package com.example.realmlist;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Base extends RealmObject {
    private String count;
    private String name;
    private String code;
    @PrimaryKey
    private int id;



    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

