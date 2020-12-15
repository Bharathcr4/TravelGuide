package com.example.travelguide.HelperClasses;

import java.io.Serializable;

public class FetchData_shopping implements Serializable {
    String id;
    String Name;
    String S_location;

    public FetchData_shopping() {
    }

    public FetchData_shopping(String id, String name, String s_location) {
        this.id = id;
        Name = name;
        S_location = s_location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getS_location() {
        return S_location;
    }

    public void setS_location(String s_location) {
        S_location = s_location;
    }

    @Override
    public String toString() {
        return "FetchData_shopping{" +
                "Name='" + Name + '\'' +
                ", S_location'" + S_location + '\'' +
                '}';
    }
}
