package com.example.elethangapplication.dog;

import com.google.gson.annotations.SerializedName;

public class Dog {
    public int id;
    @SerializedName("name")
    public String dogName;
    @SerializedName("description")
    public String dogDescription;

    public Dog(int id, String dogName, String dogDescription) {
        this.id = id;
        this.dogName = dogName;
        this.dogDescription = dogDescription;
    }

    public int getId() {
        return id;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getDogDescription() {
        return dogDescription;
    }

    public void setDogDescription(String dogDescription) {
        this.dogDescription = dogDescription;
    }
}
