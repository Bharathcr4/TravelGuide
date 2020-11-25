package com.example.travelguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.travelguide.R;
import com.google.android.material.textfield.TextInputLayout;

public class ForgotPassword extends AppCompatActivity {
    ImageView backBtn;
    Button next;
    TextInputLayout email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        email = findViewById(R.id.forgotpassword_email);
        backBtn = findViewById(R.id.forgot_backbuttn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ForgotPassword.super.onBackPressed();
            }
        });
        next = findViewById(R.id.forgot_next1);
        next.setOnClickListener(v -> {
            if (!validateEmail()) {
                return;
            } else {

                Intent intent = new Intent(getApplicationContext(), MakeSelection.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(next, "transition_forgot_next1");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ForgotPassword.this, pairs);
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                }
            }
        });
    }


        private boolean validateEmail () {
            String val = email.getEditText().getText().toString().trim();
            String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
            if (val.isEmpty()) {
                email.setError("Field cannot be empty");
                return false;
            } else if (!val.matches(checkEmail)) {
                email.setError("Invalid Email!!");
                return false;
            } else {
                email.setError(null);
                email.setErrorEnabled(false);
                return true;

            }
        }
    }