package com.example.stormhacks2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistrationPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);

        Button seniorButton = findViewById(R.id.registration_senior_button);
        Button caregiverButton = findViewById(R.id.registration_caregiver_button);

        //senior registration
        seniorButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(RegistrationPage.this, SeniorRegistrationPage.class);
                startActivity(intent);
            }
        });

        //TO DO: caregiver registration
    }
}