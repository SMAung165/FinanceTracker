package com.soemoe.financetracker.models;

public class Category {
    private final String categoryType;
    private final String label;
    private final String categoryDescription;

    //constructors
    public Category(String categoryType, String label, String categoryDescription) {
        this.categoryType = categoryType;
        this.label = label;
        this.categoryDescription = categoryDescription;
    }

    //getters
    public String getLabel() {
        return label;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

}
