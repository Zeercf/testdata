package com.example.testdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.testdata.adapter.adapterSubject;
import com.example.testdata.database.Database;
import com.example.testdata.model.Subject;

public class AddSubject_Activity extends AppCompatActivity {
    Button btn_add_subject;
    EditText edit_title,edit_credit,edit_time,edit_place;

    Database database;

    adapterSubject SubjectAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);

        btn_add_subject = findViewById(R.id.btn_add_subject);
        edit_credit = findViewById(R.id.edit_subject_credit);
        edit_place = findViewById(R.id.edit_subject_place);
        edit_title = findViewById(R.id.edit_subject_title);
        edit_time = findViewById(R.id.edit_subject_time);

        database = new Database(this);

        btn_add_subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subjecttile = edit_title.getText().toString().trim();
                String credit = edit_credit.getText().toString().trim();
                String time = edit_time.getText().toString().trim();
                String place = edit_place.getText().toString().trim();

                if (subjecttile.isEmpty())
                {
                    edit_title.setError("Tên môn học không được để trống");
                }
                if (credit.isEmpty())
                {
                    edit_credit.setError("Số tín chỉ không được để trống");
                }
                if (time.isEmpty())
                {
                    edit_time.setError("Thời gian học không được để trống");
                }
                if (place.isEmpty())
                {
                    edit_place.setError("Nơi học không được để trống");
                }
                else {
                    Subject subject = createSubject();

                    database.AddSubject(subject);

                    Intent intent = new Intent(AddSubject_Activity.this,Subject_Activity.class);
                    startActivity(intent);
                }

            }
        });

    }

    private Subject createSubject () {
        String subjecttile = edit_title.getText().toString().trim();
        int credit = Integer.parseInt(edit_credit.getText().toString().trim());
        String time = edit_time.getText().toString().trim();
        String place = edit_place.getText().toString().trim();

        Subject subject = new Subject(subjecttile,credit,time,place);
        return subject;

    }


}