package com.example.travelguide.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.travelguide.Common.LoginSignup.RetailerStartUpScreen;
import com.example.travelguide.R;

public class AllCategories extends AppCompatActivity {
ImageView backBtn;
Button expandall_car;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_all_categories);


        //Hooks
        backBtn = findViewById(R.id.back_pressed);
        expandall_car=findViewById(R.id.car_rental);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AllCategories.super.onBackPressed();
            }
        });
        expandall_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Car_rent_main.class);
                startActivity(intent);
            }
        });
    }
}