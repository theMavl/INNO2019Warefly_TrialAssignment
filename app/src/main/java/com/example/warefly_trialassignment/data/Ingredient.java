package com.example.warefly_trialassignment.data;

public class Ingredient {
    public final String name;
    public final String value;

    public Ingredient(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return name + " " + value;
    }
}