package com.example.shayari;

public class Database1_Model {

    public int id;
    public String fullname, contacts, email, course, fees;

    public Database1_Model(int id, String fullname, String contacts, String email, String course, String fees) {
        this.id = id;
        this.fullname = fullname;
        this.contacts = contacts;
        this.email = email;
        this.course = course;
        this.fees = fees;
    }

    public Database1_Model() {

    }
}
