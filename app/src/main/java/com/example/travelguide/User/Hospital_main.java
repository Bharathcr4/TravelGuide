package com.example.travelguide.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.travelguide.HelperClasses.FetchData_hospital;
import com.example.travelguide.HelperClasses.HomeAdapter.HelperAdapter_hospital;
import com.example.travelguide.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Hospital_main extends AppCompatActivity {
    List<FetchData_hospital> fetchData_hospital;
    RecyclerView recyclerView;
    ImageView hospital;
    HelperAdapter_hospital helperAdapter_hospital;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_main);
        recyclerView=findViewById(R.id.recycler_hospital);
        hospital=findViewById(R.id.hosp_back_button);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fetchData_hospital=new ArrayList<>();

        databaseReference= FirebaseDatabase.getInstance().getReference("Hospital");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren())
                {
                    FetchData_hospital data_hospital=ds.getValue(FetchData_hospital.class);
                    fetchData_hospital.add(data_hospital);
                }
                helperAdapter_hospital =new HelperAdapter_hospital(fetchData_hospital);
                recyclerView.setAdapter(helperAdapter_hospital);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
       hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Hospital_main.super.onBackPressed();}
        });
    }
    }

