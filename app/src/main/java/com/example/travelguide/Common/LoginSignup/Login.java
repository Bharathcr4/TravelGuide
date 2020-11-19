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

public class Login extends AppCompatActivity {
    ImageView backBtn;
    Button frgtpasswrd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_login);
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
    }

}