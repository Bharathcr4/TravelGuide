package com.example.travelguide.HelperClasses;

import java.io.Serializable;

public class FetchData_hospital implements Serializable {
    String id;
    String H_name;
    String Location;
    String Phone;

    public FetchData_hospital() {
    }

    public FetchData_hospital(String id, String h_name, String location, String phone) {
        this.id = id;
        H_name = h_name;
        Location = location;
        Phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getH_name() {
        return H_name;
    }

    public void setH_name(String h_name) {
        H_name = h_name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
    @Override
    public String toString() {
        return "FetchData_hospital{" +
                " H_name='" +  H_name + '\'' +
                ", Location'" + Location + '\'' +
                ", Phone'" + Phone + '\'' +
                '}';
    }
}
