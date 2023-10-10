package com.example.testdata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.testdata.adapter.adapterSubject;
import com.example.testdata.database.Database;
import com.example.testdata.model.Subject;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class Subject_Activity extends AppCompatActivity {
    Toolbar toolbar;
    ListView listViewSubject;
    ArrayList<Subject> ArraylistSubject;
    Database database;
    adapterSubject adapter;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        toolbar = findViewById(R.id.toolbar);
        listViewSubject = findViewById(R.id.listView_Subject);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        database = new Database(this);

        ArraylistSubject = new ArrayList<>();
        Cursor cursor = database.getDataSubject();
        while (cursor.moveToNext())
        {
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            int credit = cursor.getInt(2);
            String time = cursor.getString(3);
            String place = cursor.getString(4);

            ArraylistSubject.add(new Subject(id,title,credit,time,place));
        }
        adapter = new adapterSubject(Subject_Activity.this,ArraylistSubject);
        listViewSubject.setAdapter(adapter);
        cursor.moveToFirst();
        cursor.close();

        listViewSubject.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Subject_Activity.this,Student_Activity.class);
                int id_subject = ArraylistSubject.get(i).getId();
                intent.putExtra("id_subject",id_subject);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_subject,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuAdd)
        {
            startActivity(new Intent(Subject_Activity.this,AddSubject_Activity.class));
        }
        else {
            startActivity(new Intent(Subject_Activity.this,MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        count++;
        if (count >= 1) {
            startActivity(new Intent(Subject_Activity.this, MainActivity.class));
            finish();
        }
        super.onBackPressed();
    }
    public void information (final int pos) {
        Cursor cursor = database.getDataSubject();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            if (id == pos) {
                Intent intent = new Intent(Subject_Activity.this, Activity_Subject_Information.class);
                intent.putExtra("id",id);
                String title = cursor.getString(1);
                int credit = cursor.getInt(2);
                String time = cursor.getString(3);
                String place = cursor.getString(4);

                intent.putExtra("title",title);
                intent.putExtra("credit",credit);
                intent.putExtra("time",time);
                intent.putExtra("place",place);

                startActivity(intent);
            }
        }
    }
    public void delete (final int positon)
    {

    }
}