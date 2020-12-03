package com.example.travelguide.Common.LoginSignup;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.travelguide.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class SignUp extends AppCompatActivity {
    //    private AppCompatSpinner spinner;
    private static final String TAG = SignUp.class.getSimpleName();


    private ImageView bk_btn;
    private Button login;
    private Button sign_up;
    private TextInputLayout full_name;
    private TextInputLayout user_name;
    private TextInputLayout user_email;
    private TextInputLayout user_password;
    private TextInputLayout user_phone;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private String id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_sign_up);

        full_name=(TextInputLayout) findViewById(R.id.signup_fullname);
        user_name=(TextInputLayout) findViewById(R.id.signup_username);
        user_email=(TextInputLayout) findViewById(R.id.signup_email);
        user_password=(TextInputLayout) findViewById(R.id.signup_password);
        user_phone=(TextInputLayout) findViewById(R.id.signup_phonenumber);

        sign_up=(Button)findViewById(R.id.signup_button);

        mFirebaseInstance=FirebaseDatabase.getInstance();

        mFirebaseDatabase=mFirebaseInstance.getReference("user");

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String full_name1=full_name.getEditText().getText().toString();
                String user_name1=user_name.getEditText().getText().toString();
                String user_email1=user_email.getEditText().getText().toString();
                String user_password1=user_password.getEditText().getText().toString();
                String user_phone1=user_phone.getEditText().getText().toString();
                if(TextUtils.isEmpty((id))){
                    createUser(full_name1,user_name1,user_email1,user_password1,user_phone1);
                }else{
                    updateUser(full_name1,user_name1,user_email1,user_password1,user_phone1);
                }
            }
        });
        toggleButton();
    }
    private void toggleButton(){
        if(TextUtils.isEmpty(id)){
            sign_up.setText("save");
        }else{
            sign_up.setText("update");
        }
    }
    private void updateUser(String full_name,String user_name,String user_email,String user_password,String user_phone){
        if(!TextUtils.isEmpty(full_name))
            mFirebaseDatabase.child(id).child("full_name").setValue(full_name);

        if(!TextUtils.isEmpty(user_name))
            mFirebaseDatabase.child(id).child("user_name").setValue(user_name);


        if(!TextUtils.isEmpty(user_email))
            mFirebaseDatabase.child(id).child("user_email").setValue(user_email);

        if(!TextUtils.isEmpty(user_password))
            mFirebaseDatabase.child(id).child("user_password").setValue(user_password);


        if(!TextUtils.isEmpty(user_phone))
            mFirebaseDatabase.child(id).child("user_phone").setValue(user_phone);
    }

    private void createUser(String full_name,String user_name,String user_email,String user_password,String user_phone){
        if(TextUtils.isEmpty(id)){
            id=mFirebaseDatabase.push().getKey();
        }
        user user = new user(full_name,user_name,user_email,user_password,user_phone);
        mFirebaseDatabase.child(id).setValue(user);
    }
}
