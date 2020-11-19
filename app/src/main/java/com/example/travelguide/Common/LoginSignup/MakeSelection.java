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

public class MakeSelection extends AppCompatActivity {
    ImageView backBtn;
    Button sms;
    Button email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_selection);
        backBtn = findViewById(R.id.make_selection_backbtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MakeSelection.super.onBackPressed();
            }
        });


       sms= findViewById(R.id.sms);
       sms.setOnClickListener(v ->

        {
            Intent intent = new Intent(getApplicationContext(), SetNewPassword.class);

            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View, String>(sms, "transition_sms_btn");

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MakeSelection.this, pairs);
                startActivity(intent, options.toBundle());
            } else {
                startActivity(intent);
            }
        });

        email= findViewById(R.id.email_id);
        email.setOnClickListener(v ->

        {
            Intent intent = new Intent(getApplicationContext(), SetNewPassword.class);

            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View, String>(email, "transition_email_btn");

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MakeSelection.this, pairs);
                startActivity(intent, options.toBundle());
            } else {
                startActivity(intent);
            }
        });
    }
}