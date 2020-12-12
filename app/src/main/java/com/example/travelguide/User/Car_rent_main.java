package com.example.travelguide.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.travelguide.HelperClasses.FetchData_car_rent;
import com.example.travelguide.HelperClasses.HomeAdapter.HelperAdapter_car_rent;
import com.example.travelguide.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Car_rent_main extends AppCompatActivity {
List<FetchData_car_rent>fetchData_car_rent;
RecyclerView recyclerView;
HelperAdapter_car_rent helperAdapter_car_rent;
DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_rent_main);
        recyclerView=findViewById(R.id.recycler_car_rent);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fetchData_car_rent=new ArrayList<>();

        databaseReference= FirebaseDatabase.getInstance().getReference("RentCar");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren())
                {
                    FetchData_car_rent data_car_rent=ds.getValue(FetchData_car_rent.class);
                    fetchData_car_rent.add(data_car_rent);
                }
                helperAdapter_car_rent =new HelperAdapter_car_rent(fetchData_car_rent);
                recyclerView.setAdapter(helperAdapter_car_rent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}