package com.soemoe.financetracker.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.soemoe.financetracker.models.Category;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CategoryRecordSaver {
    private final Gson gson;
    //constructors
    public CategoryRecordSaver() {
        gson = new Gson();
    }
    //methods
    public void saveCategoryRecord(ArrayList<Category> categories) {
        try (FileWriter writer = new FileWriter("data/categories.json")) {
            writer.write(gson.toJson(categories, new TypeToken<ArrayList<Category>>(){}.getType()));
        } catch (IOException e) {
            System.out.println("Error writing file!" + e);
        }
    }
}
