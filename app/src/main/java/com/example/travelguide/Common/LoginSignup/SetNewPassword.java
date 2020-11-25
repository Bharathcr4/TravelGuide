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

public class SetNewPassword extends AppCompatActivity {
    ImageView backBtn;
    Button ok;
    TextInputLayout  newpass,confpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_password);
        newpass= findViewById(R.id.newpasswrd);
        confpass = findViewById(R.id.confirmpasswrd);
        backBtn = findViewById(R.id.set_new_pass_backbtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetNewPassword.super.onBackPressed();
            }
        });
        ok = findViewById(R.id.ok);
       ok.setOnClickListener(v ->

        {
            Intent intent = new Intent(getApplicationContext(), ForgotpasswordSucessMessage.class);

            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View, String>(ok, "transition_ok_btn");

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SetNewPassword.this, pairs);
                startActivity(intent, options.toBundle());
            } else {
                startActivity(intent);
            }
        });


    }
    }