package com.example.travelguide.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.travelguide.HelperClasses.FetchData_lodging;
import com.example.travelguide.HelperClasses.HomeAdapter.HelperAdapter_lodging;
import com.example.travelguide.HelperClasses.HomeAdapter.HelperAdapter_restaurant;
import com.example.travelguide.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Lodging_main extends AppCompatActivity {

    List<FetchData_lodging> fetchData_lodging;
    RecyclerView recyclerView;
    ImageView lodging;
    HelperAdapter_lodging helperAdapter_lodging;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lodging_main);
        recyclerView=findViewById(R.id.recycler_lodging);
        lodging=findViewById(R.id.lodge_back_button);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fetchData_lodging=new ArrayList<>();

        databaseReference= FirebaseDatabase.getInstance().getReference("Lodging");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren())
                {
                    FetchData_lodging data_lodging=ds.getValue(FetchData_lodging.class);
                    fetchData_lodging.add(data_lodging);
                }
                helperAdapter_lodging =new HelperAdapter_lodging(fetchData_lodging);
                recyclerView.setAdapter(helperAdapter_lodging);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
       lodging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Lodging_main.super.onBackPressed();
            }
        });
    }


}