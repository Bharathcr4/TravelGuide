package com.example.travelguide.Databases;

import com.google.android.material.textfield.TextInputLayout;

public class Signup_database {

    public String FullName, Username, Email, Password, Gender, PhoneNumber;


    public Signup_database(TextInputLayout regfullname, TextInputLayout regemail, TextInputLayout password, TextInputLayout regphonenumber, TextInputLayout regusername) {

    }

    public Signup_database(String fullName, String username, String email, String password, String gender, String phoneNumber) {
        FullName = fullName;
        Username = username;
        Email = email;
        Password = password;
        Gender = gender;
        PhoneNumber = phoneNumber;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
