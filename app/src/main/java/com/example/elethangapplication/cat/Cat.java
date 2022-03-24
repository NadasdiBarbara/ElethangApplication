package com.example.elethangapplication.cat;

import com.google.gson.annotations.SerializedName;

public class Cat {
    @SerializedName("name")
    public String catName;
    public String description;

    public Cat(String catName, String description) {
        this.catName = catName;
        this.description = description;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
