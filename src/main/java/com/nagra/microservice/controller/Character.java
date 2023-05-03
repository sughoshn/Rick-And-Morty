package com.nagra.microservice.controller;

public class Character {
    private String name;

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String image;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Character() {
    }


    public Character(String name, String image) {
        this.name = name;
        this.image=image;
    }
}

