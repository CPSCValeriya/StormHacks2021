package com.example.stormhacks2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SeniorProfilePage extends AppCompatActivity {

    private AppManager appManager;
    private ArrayAdapter<String> notificationsAdapter;
    public static final String EXTRA_SENIOR_PROFILE = "selected_senior_position";
    int patientPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_profile_page);

        appManager = AppManager.getInstance();
        Senior senior;

        Intent intent = getIntent();
        patientPosition = intent.getIntExtra(getResources().getString(R.string.SENIOR_PROFILE_POSITION), -1);

        senior = appManager.getSeniors().get(patientPosition);

        TextView name = findViewById(R.id.senior_profile_name_txt);
        String seniorName = senior.getFirstName() + " " + senior.getLastName();
        name.setText(seniorName);

        TextView age = findViewById(R.id.senior_profile_age_text);
        String seniorAge = Integer.toString(senior.getAge());
        age.setText(seniorAge);

        ImageView image = findViewById(R.id.senior_profile_picture_image);
        image.setBackgroundResource(senior.getProfilePicture());

        populateNotificationsList();
    }

    private void populateNotificationsList() {
        ListView list = findViewById(R.id.senior_profile_notif_list);
        notificationsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, appManager.getSeniors().get(patientPosition).getCareGiverNotifications());
        list.setAdapter(notificationsAdapter);
    }

}