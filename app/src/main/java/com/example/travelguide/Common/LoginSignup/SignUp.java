package com.example.travelguide.Common.LoginSignup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travelguide.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SignUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private AppCompatSpinner spinner;

    ImageView backBtn;
    Button signup, login;
    TextView tittleText;

    TextInputLayout fullname, username, email, password, phonenumber;
    RadioGroup radiogroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_retailer_sign_up);

        fullname = findViewById(R.id.signup_fullname);
        username = findViewById(R.id.signup_username);
        email = findViewById(R.id.signup_email);
        password = findViewById(R.id.signup_password);
        phonenumber = findViewById(R.id.signup_phonenumber);
       radiogroup= findViewById(R.id.signup_gender);
        if(!validateFullName() | !validateUserName() | !validateGender() | !validatePhoneNumber() | !validateEmail() | !validatePassword()){
            return;
        }
        backBtn = findViewById(R.id.signup_back_button);
        backBtn.setOnClickListener(v ->

        {

            Intent intent = new Intent(getApplicationContext(), RetailerStartUpScreen.class);

            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View, String>(backBtn, "transition_back_arrow_btn");

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this, pairs);
                startActivity(intent, options.toBundle());
            } else {
                startActivity(intent);
            }
        });
        signup = findViewById(R.id.signup_next_button);
        signup.setOnClickListener(v ->

        {
            Intent intent = new Intent(getApplicationContext(), SignUp.class);

            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View, String>(signup, "transition_next_btn");

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this, pairs);
                startActivity(intent, options.toBundle());
            } else {
                startActivity(intent);
            }
        });

        login = findViewById(R.id.signup_login_button);
        login.setOnClickListener(v ->

        {
            Intent intent = new Intent(getApplicationContext(), Login.class);

            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View, String>(login, "transition_login_btn");

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this, pairs);
                startActivity(intent, options.toBundle());
            } else {
                startActivity(intent);
            }
        });

        tittleText = findViewById(R.id.signup_title_text);
        tittleText.setOnClickListener(v ->

        {
            Intent intent = new Intent(getApplicationContext(), SignUp.class);

            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View, String>(tittleText, "transition_title_text");

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this, pairs);
                startActivity(intent, options.toBundle());
            } else {
                startActivity(intent);
            }

        });

        spinner = findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, getCountryNames());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


    }

    private static List<String> getCountryNames() {
        List<String> countries = new ArrayList<String>();

        // Get ISO countries, create Country object and
        // store in the collection.
        String[] isoCountries = Locale.getISOCountries();
        for (String country : isoCountries) {
            Locale locale = new Locale("en", country);
            String name = locale.getDisplayCountry();

            if (!"".equals(name)) {
                countries.add(name);
            }
        }

        return countries;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "" + getCountryNames().get(position), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private boolean validateFullName() {
        String val = fullname.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            fullname.setError("Field cannot be empty");
            return false;
        } else {
            fullname.setError(null);
            fullname.setErrorEnabled(false);
            return true;

        }
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

    private boolean validateEmail() {
        String val = email.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()) {
           email.setError("Field cannot be empty");
            return false;
        }  else if (!val.matches(checkEmail)) {
            email.setError("Invalid Email!!");
            return false;
        } else {
            email.setError(null);
           email.setErrorEnabled(false);
            return true;

        }
    }

    private boolean validatePassword() {
        String val = password.getEditText().getText().toString().trim();
        String checkPassword = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=S+$)" +           //no white spaces
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

    private boolean validateGender() {
        if (radiogroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please Select Gender", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    private boolean validatePhoneNumber() {
        String val = phonenumber.getEditText().getText().toString().trim();
        String checkspaces = "Aw{1,20}z";
        if (val.isEmpty()) {
            phonenumber.setError("Enter valid phone number");
            return false;
        } else if (!val.matches(checkspaces)) {
            phonenumber.setError("No White spaces are allowed!");
            return false;
        } else {
           phonenumber.setError(null);
           phonenumber.setErrorEnabled(false);
            return true;
        }
    }

}


