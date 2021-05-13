package com.example.inclass03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

public class DepartmentActivity extends AppCompatActivity implements View.OnClickListener{
    RadioGroup radioGroup;
    String selectedDept;
    public static final String Dept_Name ="Dept_Name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);
        setTitle(getResources().getString(R.string.department_label));
        findViewById(R.id.button_SelectDept).setOnClickListener(this);
        findViewById(R.id.button_cancel).setOnClickListener(this);

        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton_CS: selectedDept = "Computer Science"; break;
                    case R.id.radioButton_SIS: selectedDept = "Software Info. Systems"; break;
                    case R.id.radioButton_BI: selectedDept = "Bio Informatics"; break;
                    case R.id.radioButton_DS: selectedDept = "Data Science"; break;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch(v.getId()){

            case R.id.button_cancel:
                setResult(RESULT_CANCELED,intent);
                finish();
                break;
            case R.id.button_SelectDept:
                intent.putExtra(Dept_Name,selectedDept);
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }
}