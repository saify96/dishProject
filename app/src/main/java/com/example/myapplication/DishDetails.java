package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DishDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_details);
        //button to take the user back to the menu page
        Button backToMenu = findViewById(R.id.backToMenu);
        backToMenu.setOnClickListener(view -> {
            Intent goToMenuPage = new Intent(DishDetails.this, Menu.class);
            startActivity(goToMenuPage);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //get the data that was sent from the adapter and set it to the text views to display them
        Intent intent = getIntent();
        String name = intent.getExtras().getString("dishName");
        TextView nameField = findViewById(R.id.nameField);
        nameField.setText(name);
        String price = intent.getExtras().getString("dishPrice");
        TextView priceField = findViewById(R.id.priceField);
        priceField.setText(price);
        String ingredients = intent.getExtras().getString("dishIngredients");
        TextView IngredientsField = findViewById(R.id.IngredientsField);
        IngredientsField.setText(ingredients);
    }
}