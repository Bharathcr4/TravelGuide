package com.example.travelguide.HelperClasses;

import java.io.Serializable;

public class FetchData_restaurant implements Serializable {
    String id;
    String Hotel_name;
    String Location;

    public FetchData_restaurant() {
    }

    public FetchData_restaurant(String id, String hotel_name, String location) {
        this.id = id;
        Hotel_name = hotel_name;
        Location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHotel_name() {
        return Hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        Hotel_name = hotel_name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
    @Override
    public String toString() {
        return "FetchData_restaurant{" +
                "Hotel_name='" + Hotel_name + '\'' +
                ", Location'" + Location + '\'' +
                '}';
    }
}
