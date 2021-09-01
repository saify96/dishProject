package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //call the buttons that i added to layout and make an intent to make them send the user to the required pages
        //from main to add dish page
        Button addDishButton = findViewById(R.id.addDishButton);
        addDishButton.setOnClickListener(view -> {
            Intent goToAddTaskActivity = new Intent(MainActivity.this,AddDish.class);
            startActivity(goToAddTaskActivity);
        });
        //from main to menu page
        Button menuButton = findViewById(R.id.menuButton);
        menuButton.setOnClickListener(view -> {
            Intent goToMenuActivity = new Intent(MainActivity.this,Menu.class);
            startActivity(goToMenuActivity);
        });
    }
}