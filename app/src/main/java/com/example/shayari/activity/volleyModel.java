package com.example.shayari.activity;

public class volleyModel {

    public int id;
    public int user_id;
    public String title;
    public String due_on;
    public String status;

    public volleyModel(int id, int user_id, String title, String due_on, String status) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.due_on = due_on;
        this.status = status;
    }
}
