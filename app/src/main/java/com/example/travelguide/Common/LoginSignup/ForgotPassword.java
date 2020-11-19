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

public class ForgotPassword extends AppCompatActivity {
    ImageView backBtn;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        backBtn = findViewById(R.id.forgot_backbuttn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ForgotPassword.super.onBackPressed();
            }
        });
        next = findViewById(R.id.forgot_next1);
        next.setOnClickListener(v ->

        {
            Intent intent = new Intent(getApplicationContext(), MakeSelection.class);

            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View, String>(next, "transition_forgot_next1");

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ForgotPassword.this, pairs);
                startActivity(intent, options.toBundle());
            } else {
                startActivity(intent);
            }
        });
    }
}