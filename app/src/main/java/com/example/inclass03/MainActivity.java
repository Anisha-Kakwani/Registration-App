package com.example.inclass03;

/*
* Assignment: InClass03
* Group: B8
* Group Members:
* Anisha Kakwani
* Hiten Changlani
* */

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    EditText personName, personEmail, personID;
    TextView dept_name;
    public static final String User_profile = "USER_PROFILE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getResources().getString(R.string.registration_label));

        personName = findViewById(R.id.editTextName);
        personEmail = findViewById(R.id.editTextEmail);
        personID = findViewById(R.id.editNumberID);
        dept_name = findViewById(R.id.deptDisplayLabel);
        findViewById(R.id.button_Select).setOnClickListener(this);
        findViewById(R.id.button_Submit).setOnClickListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                if (data != null && data.hasExtra(DepartmentActivity.Dept_Name)) {
                    dept_name.setText(data.getStringExtra(DepartmentActivity.Dept_Name));
                }
            }
            else if (resultCode == RESULT_CANCELED){
                Toast.makeText(this, getResources().getString(R.string.toast_enter_dept), Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button_Select){
            dept_name.setText("");
            Intent intent = new Intent(MainActivity.this, DepartmentActivity.class);
            startActivityForResult(intent, 100);
        }
        else if (v.getId()==R.id.button_Submit){
            String name = personName.getText().toString();
            String email = personEmail.getText().toString();
            String id = personID.getText().toString();
            String dept = dept_name.getText().toString();
            String email_regex = "[a-zA-Z0-9._-]+@[a-zA-Z]+\\.+[a-zA-Z]+";
            if (name.isEmpty() || email.isEmpty() || dept.isEmpty() || id.isEmpty()){
                Toast.makeText(this, getResources().getString(R.string.toast_mandatory), Toast.LENGTH_SHORT).show();
            }
            else if (name.matches(".*[0-9].*") || name.contains("!@#$%&*()'+,-./:;<=>?[]^_`{|}")){
                Toast.makeText(this, getResources().getString(R.string.toast_names), Toast.LENGTH_SHORT).show();
            }
            else if (!email.matches(email_regex)){
                Toast.makeText(this, getResources().getString(R.string.toast_email), Toast.LENGTH_SHORT).show();
            }
            else{
                Intent profile_intent = new Intent(MainActivity.this, ProfileActivity.class);
                User user = new User(name, email, parseInt(id), dept);
                profile_intent.putExtra(User_profile, user);
                startActivity(profile_intent);
            }

        }
    }
}