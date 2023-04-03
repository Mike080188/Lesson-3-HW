package com.example.lesson3hw.model;

import java.io.Serializable;

public class Course implements Serializable {

    private int ID;
    private int credits;
    private String description;
    private String name;

    public Course(int ID, int credits, String description, String name) {
        this.ID = ID;
        this.credits = credits;
        this.name = name;
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.description = name;
    }
}
