package com.example.travelguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.travelguide.R;
import com.example.travelguide.User.AllCategories;
import com.example.travelguide.User.UserDashboard;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {
    ImageView backBtn;
    Button frgtpasswrd,Signup,Login;
    TextInputLayout  username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_login);

        username = findViewById(R.id.login_username);
        password = findViewById(R.id.login_password);
        backBtn = findViewById(R.id.login_back_button);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login.super.onBackPressed();
            }
        });


        frgtpasswrd = findViewById(R.id.forgt_buttn);
        frgtpasswrd.setOnClickListener(v ->

        {
            Intent intent = new Intent(getApplicationContext(), ForgotPassword.class);

            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View, String>(frgtpasswrd, "transition_forgot_buttn");

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
                startActivity(intent, options.toBundle());
            } else {
                startActivity(intent);
            }
        });

        Login = findViewById(R.id.loginsucess);
        Login.setOnClickListener(v -> {

            if ( !validateUserName()  | !validatePassword()) {
                return;
            } else {
                Intent intent = new Intent(getApplicationContext(), UserDashboard.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(Login, "transition_forgot_buttn");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                }
            }
        });

        Signup = findViewById(R.id.create_account);
        Signup.setOnClickListener(v ->

        {
            Intent intent = new Intent(getApplicationContext(), SignUp.class);

            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View, String>(Signup, "transition_create_buttn");

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
                startActivity(intent, options.toBundle());
            } else {
                startActivity(intent);
            }
        });
    }

        private boolean validateUserName() {
            String val = username.getEditText().getText().toString().trim();
            String checkspaces = "\\A\\w{1,20}\\z";
            if (val.isEmpty()) {
                username.setError("Field cannot be empty");
                return false;
            } else if (val.length() > 20) {
                username.setError("Username is too Large");
                return false;
            } else if (!val.matches(checkspaces)) {
                username.setError("No white Spaces allowed");
                return false;
            } else {
                username.setError(null);
                username.setErrorEnabled(false);
                return true;

            }
        }

        private boolean validatePassword() {
            String val = password.getEditText().getText().toString().trim();
            String checkPassword = "^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$";

            if (val.isEmpty()) {
                password.setError("Field can not be empty");
                return false;
            } else if (!val.matches(checkPassword)) {
                password.setError("Password should contain 4 characters!");
                return false;
            } else {
                password.setError(null);
                password.setErrorEnabled(false);
                return true;
            }
        }
    }