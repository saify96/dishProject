package com.example.myapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
//create an entity and set the fields for it
//make a constructor function without the id cua it's auto Generated
@Entity
public class Dish {
    @PrimaryKey (autoGenerate = true)
    public int id;
    @ColumnInfo(name = "dish_Name")
    public String dishName;
    @ColumnInfo(name = "dish_Price")
    public String dishPrice;
    @ColumnInfo(name = "dish_Ingredients")
    public String dishIngredients;

    public Dish(String dishName, String dishPrice, String dishIngredients) {
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.dishIngredients = dishIngredients;
    }
}
