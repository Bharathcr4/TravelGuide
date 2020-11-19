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

public class ForgotpasswordSucessMessage extends AppCompatActivity {
    ImageView backBtn;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword_sucess_message);
        backBtn = findViewById(R.id.forgotsucess_backbuttn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ForgotpasswordSucessMessage.super.onBackPressed();
            }
        });

        login = findViewById(R.id.login_btn2);
        login.setOnClickListener(v ->

        {
            Intent intent = new Intent(getApplicationContext(), Login.class);

            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View, String>(login, "transition_login2_btn");

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ForgotpasswordSucessMessage.this, pairs);
                startActivity(intent, options.toBundle());
            } else {
                startActivity(intent);
            }
        });
    }
}