package com.example.travelguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.annotation.Nullable;

import android.app.ActivityOptions;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.travelguide.Common.LoginSignup.Login;
import com.example.travelguide.Common.LoginSignup.MakeSelection;
import com.example.travelguide.Common.LoginSignup.RetailerStartUpScreen;
import com.example.travelguide.Common.LoginSignup.SetNewPassword;
import com.example.travelguide.Common.LoginSignup.SignUp;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class OtpActivity_one extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private AppCompatSpinner spinner;

    ImageView backbuttn;
    private Button btn_otp;
    private EditText etPhoneNumber;

    private static final String TAG = "OtpActivity_one";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_one);

        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        btn_otp = findViewById(R.id.otp_btn_id1);

        backbuttn = findViewById(R.id.backbtn_otp);
        backbuttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OtpActivity_one.super.onBackPressed();
            }
        });


        btn_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = etPhoneNumber.getText().toString();
                if (phoneNumber.isEmpty())
                    Toast.makeText(OtpActivity_one.this, "Enter your phone number", Toast.LENGTH_SHORT).show();
                else {
                    //verify phone number
                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            "+91" + phoneNumber, 60, TimeUnit.SECONDS, OtpActivity_one.this,
                            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                @Override
                                public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                                    signInUser(phoneAuthCredential);
                                }

                                @Override
                                public void onVerificationFailed(FirebaseException e) {
                                    Log.d(TAG, "onVerificationFailed:" + e.getLocalizedMessage());
                                }

                                @Override
                                public void onCodeSent(final String verificationId, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                    super.onCodeSent(verificationId, forceResendingToken);
                                    //
                                    Dialog dialog = new Dialog(OtpActivity_one.this);
                                    dialog.setContentView(R.layout.verify_popup);

                                    final EditText etVerifyCode = dialog.findViewById(R.id.etVerifyCode);
                                    Button btnVerifyCode = dialog.findViewById(R.id.btnVerifyOTP);
                                    btnVerifyCode.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            String verificationCode = etVerifyCode.getText().toString();
                                            if (verificationId.isEmpty()) return;
                                            //create a credential
                                            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, verificationCode);
                                            signInUser(credential);
                                        }
                                    });

                                    dialog.show();
                                }
                            });
                }
            }
        });


        spinner = findViewById(R.id.spinner_one);

        spinner.setOnItemSelectedListener(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, getCountryNames());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }



    private void signInUser(PhoneAuthCredential credential) {
            FirebaseAuth.getInstance().signInWithCredential(credential)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                startActivity(new Intent(OtpActivity_one.this,SetNewPassword.class));
                                finish();
                            }else {
                                Log.d(TAG, "onComplete:"+task.getException().getLocalizedMessage());
                            }
                        }
                    });
        }

    private static List<String> getCountryNames() {
        List<String> countries = new ArrayList<String>();

        // Get ISO countries, create Country object and
        // store in the collection.
        String[] isoCountries = Locale.getISOCountries();
        for (String country : isoCountries) {
            Locale locale = new Locale("en", country);
            String name = locale.getDisplayCountry();

            if (!"".equals(name)) {
                countries.add(name);
            }
        }

        return countries;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "" + getCountryNames().get(position), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    }