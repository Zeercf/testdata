package com.example.testdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity_Subject_Information extends AppCompatActivity {

    TextView text_credit,text_title,text_time,text_place;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_information);

        text_title = findViewById(R.id.text_subject_title);
        text_credit = findViewById(R.id.text_subject_credit);
        text_time = findViewById(R.id.text_subject_time);
        text_place = findViewById(R.id.text_subject_place);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        int credit = intent.getIntExtra("credit",0);
        String time = intent.getStringExtra("time");
        String place = intent.getStringExtra("place");

        text_title.setText(title);
        text_credit.setText(credit+" ");
        text_time.setText(time);
        text_place.setText(place);

    }
}