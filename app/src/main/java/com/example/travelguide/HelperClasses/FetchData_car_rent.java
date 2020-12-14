package com.example.travelguide.HelperClasses;

import java.io.Serializable;
import java.util.Locale;

public class FetchData_car_rent implements Serializable {
    String id;
    String Company;
    String Location;
    String Phonenumber;
    String DownloadLink;

    public FetchData_car_rent() {

    }

    public FetchData_car_rent(String id, String company, String location, String phonenumber, String downloadLink) {
        this.id = id;
        Company = company;
        Location = location;
        Phonenumber = phonenumber;
        DownloadLink = downloadLink;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        Phonenumber = phonenumber;
    }

    public String getDownloadLink() {
        return DownloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        DownloadLink = downloadLink;
    }

    @Override
    public String toString() {
        return "FetchData_car_rent{" +
                "Company='" + Company + '\'' +
                ", DownloadLink='" + DownloadLink + '\'' +
                ", Location'" + Location + '\'' +
                ", Phonenumber='" + Phonenumber + '\'' +
                '}';
    }
}