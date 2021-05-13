package com.example.inclass03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    TextView name, email, Id, dept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle(getResources().getString(R.string.profile_label));

        name = findViewById(R.id.textViewName);
        email = findViewById(R.id.textViewEmail);
        Id = findViewById(R.id.textViewID);
        dept = findViewById(R.id.textViewDept);

        if(getIntent().hasExtra(MainActivity.User_profile)){
            User user_profile = (User)getIntent().getSerializableExtra(MainActivity.User_profile);
            Log.d("Demo", user_profile + "");
            name.setText(user_profile.name);
            email.setText(user_profile.email);
            Id.setText(user_profile.Id + "");
            dept.setText(user_profile.dept);
        }

    }
}