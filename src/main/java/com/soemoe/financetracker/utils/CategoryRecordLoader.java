package com.soemoe.financetracker.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.soemoe.financetracker.models.Category;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CategoryRecordLoader {
    private ArrayList<Category> categoryList;
    private final Gson gson;

    //constructors
    public CategoryRecordLoader() {
        gson = new Gson();
        setCategoryList();
    }

    //getters
    public ArrayList<Category> getCategoryList() {
        return categoryList;
    }

    //setters
    private void setCategoryList() {
        try (FileReader fileReader = new FileReader("data/categories.json")) {
            categoryList = gson.fromJson(fileReader, new TypeToken<ArrayList<Category>>() {
            }.getType());
            if (categoryList == null) categoryList = new ArrayList<>();
        } catch (IOException | JsonSyntaxException e) {
            System.out.println("Error reading file!" + e);
        }
    }
}
