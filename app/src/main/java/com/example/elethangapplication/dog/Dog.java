package com.example.elethangapplication.dog;

public class Dog {

    public String dogName,dogDescription;

    public Dog(String dogName, String dogDescription) {
        this.dogName = dogName;
        this.dogDescription = dogDescription;
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
