package com.example.travelguide.Common.LoginSignup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.travelguide.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SignUp3rdClass extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
        private AppCompatSpinner spinner;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_sign_up3rd_class);

            spinner = findViewById(R.id.spinner);

            spinner.setOnItemSelectedListener(this);
            ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,getCountryNames());
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);

        }

        private static List<String> getCountryNames(){
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
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
            Toast.makeText(this, "" + getCountryNames().get(position), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

