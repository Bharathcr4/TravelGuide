package com.example.travelguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travelguide.R;

public class SignUp extends AppCompatActivity {


    ImageView backBtn;
    Button next, login;
    TextView tittleText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_sign_up);



        backBtn = findViewById(R.id.signup_back_button);
        backBtn.setOnClickListener(v -> {

            Intent intent = new Intent(getApplicationContext(), SignUp2ndClass.class);

            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View, String>(backBtn, "transition_back_arrow_btn");

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this, pairs);
                startActivity(intent, options.toBundle());
            }else {
                startActivity(intent);
            }
        });
       next = findViewById(R.id.signup_next_button);
        next.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SignUp2ndClass.class);

            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View, String>(next, "transition_next_btn");

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this, pairs);
                startActivity(intent, options.toBundle());
            }else {
                startActivity(intent);
            }
        });

      login = findViewById(R.id.signup_login_button);
        login.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SignUp2ndClass.class);

            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View, String>(login, "transition_login_btn");

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this, pairs);
                startActivity(intent, options.toBundle());
            }else {
                startActivity(intent);
            }
        });

       tittleText = findViewById(R.id.signup_title_text);
        tittleText.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SignUp2ndClass.class);

            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View, String>(tittleText, "transition_title_text");

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this, pairs);
                startActivity(intent, options.toBundle());
            }else {
                startActivity(intent);
            }
        });
    }

}