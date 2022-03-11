package com.example.shayari.delete2;

public class deleteModel {

    public int id;
    public String title;
    public float price;
    public String description;
    public String category;
    public String image;

    public deleteModel(int id, String title, float price, String description, String category, String image) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
    }
}
