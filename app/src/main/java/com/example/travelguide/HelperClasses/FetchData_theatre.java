package com.example.travelguide.HelperClasses;

import java.io.Serializable;

public class FetchData_theatre implements Serializable {
    String id;
    String Name;
    String T_loc;

    public FetchData_theatre() {

    }

    public FetchData_theatre(String id, String name, String t_loc) {
        this.id = id;
        Name = name;
        T_loc = t_loc;
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

    public String getT_loc() {
        return T_loc;
    }

    public void setT_loc(String t_loc) {
        T_loc = t_loc;
    }

    @Override
    public String toString() {
        return "FetchData_theatre{" +
                "Name='" + Name + '\'' +
                ",  T_loc='" +  T_loc + '\'' +
                '}';
    }
}