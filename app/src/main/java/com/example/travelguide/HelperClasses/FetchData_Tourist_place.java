package com.example.travelguide.HelperClasses;

import java.io.Serializable;

public class FetchData_Tourist_place implements Serializable {
    String id;
    String Name;
    String T_location;

    public FetchData_Tourist_place() {
    }

    public FetchData_Tourist_place(String id, String name, String t_location) {
        this.id = id;
        Name = name;
        T_location = t_location;
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

    public String getT_location() {
        return T_location;
    }

    public void setT_location(String t_location) {
        T_location = t_location;
    }
    @Override
    public String toString() {
        return " FetchData_Tourist_place{" +
                "Name='" + Name + '\'' +
                ", T_location'" + T_location + '\'' +
                '}';
    }
}
