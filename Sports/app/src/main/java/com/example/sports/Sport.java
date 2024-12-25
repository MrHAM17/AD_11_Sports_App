package com.example.sports;

// This class will act as a model class
public class Sport {
    // Attributes
    String sportName;
    int sportImg;

    // Constructor
    public Sport(String sportName, int sportImg) {
        this.sportName = sportName;
        this.sportImg = sportImg;
    }

    // Getters & Setters
    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public int getSportImg() {
        return sportImg;
    }

    public void setSportImg(int sportImg) {
        this.sportImg = sportImg;
    }
}
