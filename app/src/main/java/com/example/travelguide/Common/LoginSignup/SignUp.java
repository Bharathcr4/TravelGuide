package com.example.travelguide.Common.LoginSignup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travelguide.Databases.Signup_database;
import com.example.travelguide.R;
import com.example.travelguide.User.UserDashboard;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SignUp extends AppCompatActivity {
//        implements AdapterView.OnItemSelectedListener {
//    private AppCompatSpinner spinner;

    private ImageView regbackBtn;
    private Button regsignup, reglogin;

    private TextInputLayout regfullname, regusername, regemail, regpassword, regphonenumber;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_sign_up);
        setupUIViews();

        databaseReference = FirebaseDatabase.getInstance().getReference("Signup_database");
        firebaseAuth = FirebaseAuth.getInstance();
        regsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    String email = regemail.getEditText().getText().toString();
                    String password = regpassword.getEditText().getText().toString();
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                storedata();
//                                Toast.makeText(SignUp.this, "Registration Successful", Toast.LENGTH_SHORT).show();
//                                startActivity(new Intent(SignUp.this, UserDashboard.class));
                            } else {
                                Toast.makeText(SignUp.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });
        reglogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, Login.class));
            }
        });
    }

    private void storedata() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference reference = firebaseDatabase.getReference("Users");

        //Create helperclass reference and store data using firebase
        Signup_database information = new Signup_database(regfullname,regusername,regpassword,regemail,regphonenumber);
        reference.child(String.valueOf(regphonenumber)).setValue(information);

        //We will also create a Session here in next videos to keep the user logged In
        Toast.makeText(SignUp.this, "Registration Successful", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(SignUp.this, UserDashboard.class));
        finish();

    }

    private void setupUIViews() {
        regfullname = findViewById(R.id.signup_fullname);
        regusername = findViewById(R.id.signup_username);
        regemail = findViewById(R.id.signup_email);
        regpassword = findViewById(R.id.signup_password);
        regphonenumber = findViewById(R.id.signup_phonenumber);
        regsignup = findViewById(R.id.signup_next_button);
        regbackBtn = findViewById(R.id.signup_back_button);
        reglogin = findViewById(R.id.signup_login_button);


    }

    private Boolean validate() {
        Boolean result = false;
        String fullName = regfullname.getEditText().getText().toString();
        String username = regusername.getEditText().getText().toString();
        String email = regemail.getEditText().getText().toString();
        String password = regpassword.getEditText().getText().toString();
        String phoneNumber = regphonenumber.getEditText().getText().toString();



        if (fullName.isEmpty() || username.isEmpty() || password.isEmpty() || phoneNumber.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT);
        } else {
            result = true;

        }
        return result;
    }
}


