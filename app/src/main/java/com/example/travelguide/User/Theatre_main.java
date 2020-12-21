package com.example.travelguide.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.travelguide.HelperClasses.FetchData_restaurant;
import com.example.travelguide.HelperClasses.FetchData_shopping;
import com.example.travelguide.HelperClasses.FetchData_theatre;
import com.example.travelguide.HelperClasses.HomeAdapter.HelperAdapter_restaurant;
import com.example.travelguide.HelperClasses.HomeAdapter.HelperAdapter_shopping;
import com.example.travelguide.HelperClasses.HomeAdapter.HelperAdapter_theatre;
import com.example.travelguide.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Theatre_main extends AppCompatActivity {
    List<FetchData_theatre> fetchData_theatre;
    RecyclerView recyclerView;
    ImageView theatre;
    HelperAdapter_theatre helperAdapter_theatre;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theatre_main);
        recyclerView = findViewById(R.id.recycler_theatre);
       theatre = findViewById(R.id.theatre_back_button);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fetchData_theatre= new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("Theatres");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    FetchData_theatre data_theatre = ds.getValue(FetchData_theatre.class);
                    fetchData_theatre.add(data_theatre);
                }
                helperAdapter_theatre = new HelperAdapter_theatre(fetchData_theatre);
                recyclerView.setAdapter(helperAdapter_theatre);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        theatre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Theatre_main.super.onBackPressed();
            }
        });
    }
}
