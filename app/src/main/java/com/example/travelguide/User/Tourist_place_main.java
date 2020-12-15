package com.example.travelguide.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.travelguide.HelperClasses.FetchData_Tourist_place;
import com.example.travelguide.HelperClasses.FetchData_shopping;
import com.example.travelguide.HelperClasses.HomeAdapter.HelperAdapter_Tourist_place;
import com.example.travelguide.HelperClasses.HomeAdapter.HelperAdapter_shopping;
import com.example.travelguide.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Tourist_place_main extends AppCompatActivity {
    List<FetchData_Tourist_place> fetchData_Tourist_place;
    RecyclerView recyclerView;
    ImageView tourist;
    HelperAdapter_Tourist_place helperAdapter_Tourist_place;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_main);
        recyclerView = findViewById(R.id.recycler_shopping);
        tourist = findViewById(R.id.shopping_back_button);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fetchData_Tourist_place = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("Tourist_places");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    FetchData_Tourist_place data_Tourist_place = ds.getValue(FetchData_Tourist_place.class);
                    fetchData_Tourist_place.add(data_Tourist_place);
                }
                helperAdapter_Tourist_place = new HelperAdapter_Tourist_place(fetchData_Tourist_place);
                recyclerView.setAdapter(helperAdapter_Tourist_place);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        tourist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Tourist_place_main.super.onBackPressed();
            }
        });
    }
}
