package com.example.travelguide.HelperClasses;

import java.io.Serializable;

public class FetchData_lodging implements Serializable {
    String id;
    String Name;
    String Phone_number;
    String Residency_address;

    public FetchData_lodging() {
    }

    public FetchData_lodging(String id, String name, String phone_number, String residency_address) {
        this.id = id;
        Name = name;
        Phone_number = phone_number;
        Residency_address = residency_address;
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

    public String getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(String phone_number) {
        Phone_number = phone_number;
    }

    public String getResidency_address() {
        return Residency_address;
    }

    public void setResidency_address(String residency_address) {
        Residency_address = residency_address;
    }
    public String toString() {
        return "FetchData_lodging{" +
                " Name='" +  Name + '\'' +
                ", Phone_number'" + Phone_number+ '\'' +
                ", Residency_address'" + Residency_address + '\'' +
                '}';
    }
}
