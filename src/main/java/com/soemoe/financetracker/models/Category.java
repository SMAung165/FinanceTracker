package com.soemoe.financetracker.models;

public class Category {
    private String label;
    private String categoryDescription;

    //constructors
    public Category(String label, String categoryDescription) {
        this.label = label;
        this.categoryDescription = categoryDescription;
    }

    //getters
    public String getLabel() {
        return label;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }
}
