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
import com.example.travelguide.HelperClasses.HomeAdapter.HelperAdapter_restaurant;
import com.example.travelguide.HelperClasses.HomeAdapter.HelperAdapter_shopping;
import com.example.travelguide.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Shopping_main extends AppCompatActivity {
    List<FetchData_shopping> fetchData_shopping;
    RecyclerView recyclerView;
    ImageView shopping;
    HelperAdapter_shopping helperAdapter_shopping;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_main);
        recyclerView = findViewById(R.id.recycler_shopping);
        shopping = findViewById(R.id.shopping_back_button);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fetchData_shopping = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("Shopping");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    FetchData_shopping data_shopping = ds.getValue(FetchData_shopping.class);
                    fetchData_shopping.add(data_shopping);
                }
                helperAdapter_shopping = new HelperAdapter_shopping(fetchData_shopping);
                recyclerView.setAdapter(helperAdapter_shopping);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Shopping_main.super.onBackPressed();
            }
        });
    }
}
