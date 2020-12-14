package com.example.travelguide.Common.LoginSignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.travelguide.Common.LoginSignup.ForgotPassword;
import com.example.travelguide.Common.LoginSignup.Login;
import com.example.travelguide.Common.LoginSignup.SignUp;
import com.example.travelguide.HelperClasses.Utils;
import com.example.travelguide.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

    public class Profile_main extends AppCompatActivity {
        private static final String TAG = Profile_main.class.getSimpleName();
        private ImageView backButton;
        private TextView full_name;

        private TextView user_name;

        private TextView user_email;

        private TextView user_phone;
        private FirebaseDatabase firebaseDatabase;
        private DatabaseReference databaseReference;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_profile_main);
            backButton = findViewById(R.id.profile_back_button);

            full_name=(TextView)findViewById(R.id.profile_fullname);

            user_name=(TextView)findViewById(R.id.profile_username);

            user_email=(TextView)findViewById(R.id.profile_email);

            user_phone=(TextView)findViewById(R.id.profile_phonenumber);

            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Profile_main.super.onBackPressed();
                }
            });

            firebaseDatabase = FirebaseDatabase.getInstance();
            databaseReference = firebaseDatabase.getReference(Utils.USERS_TABLE);

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    Profile_main value = dataSnapshot.getValue(Profile_main.class);
                    Log.d(TAG, "Value is: " + value);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w(TAG, "Failed to read value.", error.toException());
                }
            });

        }
    }
