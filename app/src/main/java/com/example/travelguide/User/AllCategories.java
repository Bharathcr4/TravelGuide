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
Button expandall_car,expandall_restaurant,expandall_hospital,expandall_shopping;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_all_categories);


        //Hooks
        backBtn = findViewById(R.id.back_pressed);
        expandall_car=findViewById(R.id.car_rental);
        expandall_restaurant=findViewById(R.id.restaurant);
        expandall_hospital=findViewById(R.id.hospital);
        expandall_shopping=findViewById(R.id.shopping);
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
        expandall_restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Restaurant_main.class);
                startActivity(intent);
            }
        });
        expandall_hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Hospital_main.class);
                startActivity(intent);
            }
        });
        expandall_shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Shopping_main.class);
                startActivity(intent);
            }
        });
    }
}