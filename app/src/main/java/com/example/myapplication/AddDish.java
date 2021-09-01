package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddDish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dish);
        //after i create fields from layout i take the input from user by EditText class and store them into strings
        //make an instance from Dish class by user's input
        //call the button and make a listener to it and make it to save the new obj to DB when clicked
        Button submitDishButton = findViewById(R.id.submitDishButton);
        submitDishButton.setOnClickListener(view -> {

            EditText dishNameField = findViewById(R.id.dishNameField);
            String dishName = dishNameField.getText().toString();

            EditText dishPriceField = findViewById(R.id.dishPriceField);
            String dishPrice = dishPriceField.getText().toString();

            EditText ingredientsField = findViewById(R.id.ingredientsField);
            String dishIngredients = ingredientsField.getText().toString();

            Dish newDish = new Dish(dishName, dishPrice, dishIngredients);
            DishDataBase db = Room.databaseBuilder(getApplicationContext(), DishDataBase.class, "dish-db").allowMainThreadQueries().build();
            DishDao dishDao = db.dishDao();

            dishDao.insertDishes(newDish);
        });
    }
}