package com.example.testdata.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.testdata.R;
import com.example.testdata.Subject_Activity;
import com.example.testdata.model.Subject;

import java.util.ArrayList;

public class adapterSubject extends BaseAdapter {

    private Subject_Activity context;
    private ArrayList<Subject> subjectArrayList;

    public adapterSubject(Subject_Activity context, ArrayList<Subject> subjectArrayList) {
        this.context = context;
        this.subjectArrayList = subjectArrayList;
    }

    @Override
    public int getCount() {
        return subjectArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return subjectArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.list_subject,null);
        TextView textViewSubjectTitle = view.findViewById(R.id.textSubjectTile);

        TextView textViewCredit = view.findViewById(R.id.textCredit);

        Button btn_information = view.findViewById(R.id.btn_information);
        Button btn_update = view.findViewById(R.id.btn_update);
        Button btn_delete = view.findViewById(R.id.btn_information);

        Subject subject = subjectArrayList.get(i);

        textViewSubjectTitle.setText(subject.getSubject_title());
        textViewCredit.setText(subject.getSubject_credit()+"");

        int id = subject.getId();

        btn_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.information(id);
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;

    }
}
