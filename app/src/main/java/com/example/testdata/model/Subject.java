package com.example.testdata.model;

public class Subject {

    private int id;
    private String subject_title;
    private int subject_credit;
    private String time;
    private String place;

    public Subject(String subject_title, int subject_credit, String time, String place) {
        this.subject_title = subject_title;
        this.subject_credit = subject_credit;
        this.time = time;
        this.place = place;
    }

    public Subject(int id, String subject_title, int subject_credit, String time, String place) {
        this.id = id;
        this.subject_title = subject_title;
        this.subject_credit = subject_credit;
        this.time = time;
        this.place = place;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject_title() {
        return subject_title;
    }

    public void setSubject_title(String subject_title) {
        this.subject_title = subject_title;
    }

    public int getSubject_credit() {
        return subject_credit;
    }

    public void setSubject_credit(int subject_credit) {
        this.subject_credit = subject_credit;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
