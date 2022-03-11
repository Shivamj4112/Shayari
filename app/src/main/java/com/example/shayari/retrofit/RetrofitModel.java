package com.example.shayari.retrofit;

public class RetrofitModel {

    public int id;
    public String name;
    public String email;
    public String gender;
    public String status;

    public RetrofitModel(int id, String name, String email, String gender, String status) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }

}
