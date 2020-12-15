package com.example.travelguide.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.travelguide.HelperClasses.FetchData_car_rent;
import com.example.travelguide.HelperClasses.FetchData_restaurant;
import com.example.travelguide.HelperClasses.HomeAdapter.HelperAdapter_car_rent;
import com.example.travelguide.HelperClasses.HomeAdapter.HelperAdapter_restaurant;
import com.example.travelguide.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Restaurant_main extends AppCompatActivity {
    List<FetchData_restaurant> fetchData_restaurant;
    RecyclerView recyclerView;
    ImageView restaurant;
    HelperAdapter_restaurant helperAdapter_restaurant;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_main);
        recyclerView=findViewById(R.id.recycler_restaurant);
        restaurant=findViewById(R.id.restaurant_back_button);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fetchData_restaurant=new ArrayList<>();

        databaseReference= FirebaseDatabase.getInstance().getReference("Restaurant");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren())
                {
                    FetchData_restaurant data_restaurant=ds.getValue(FetchData_restaurant.class);
                    fetchData_restaurant.add(data_restaurant);
                }
                helperAdapter_restaurant =new HelperAdapter_restaurant(fetchData_restaurant);
                recyclerView.setAdapter(helperAdapter_restaurant);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Restaurant_main.super.onBackPressed();
            }
        });
    }


    }