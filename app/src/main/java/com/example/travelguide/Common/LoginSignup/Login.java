package com.example.travelguide.Common.LoginSignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.travelguide.HelperClasses.Utils;
import com.example.travelguide.R;
import com.example.travelguide.User.AllCategories;
import com.example.travelguide.User.UserDashboard;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import dalvik.system.DelegateLastClassLoader;

public class Login extends AppCompatActivity {
    ImageView backBtn;
    Button frgtpasswrd, Signup, Login;
    TextInputLayout username, password;

    private String uname, pass;

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

            if (!validateUserName() | !validatePassword()) {
                return;
            } else {

                uname = username.getEditText().getText().toString();
                pass = password.getEditText().getText().toString();

                Log.d("TAG", "details: " + uname + " password " + pass);

                Intent intent = new Intent(getApplicationContext(), UserDashboard.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(Login, "transition_forgot_buttn");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    getFirebaseAuth().signInWithEmailAndPassword(uname, pass)
                            .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getApplicationContext(),
                                                "Login successful!!",
                                                Toast.LENGTH_LONG)
                                                .show();
                                        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
                                        startActivity(intent, options.toBundle());
                                    } else {
                                        Toast.makeText(getApplicationContext(),
                                                "Login Failed!!",
                                                Toast.LENGTH_LONG)
                                                .show();
                                        Toast.makeText(Login.this, "" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                               
                            });
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
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()) {
            username.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(checkEmail)) {
            username.setError("Invalid Email!!");
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

    public static FirebaseAuth getFirebaseAuth() {
        return FirebaseAuth.getInstance();
    }

}