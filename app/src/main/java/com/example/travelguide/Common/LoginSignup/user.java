package com.example.travelguide.Common.LoginSignup;

import com.google.android.material.textfield.TextInputLayout;

public class user {
    String full_name,user_name,user_email,user_password,user_phone;

    public user() {
    }

    public user(String full_name, String user_name, String user_email, String user_password, String user_phone) {
        this.full_name = full_name;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_phone = user_phone;
    }
}