package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.List;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //get all dish objects from the database
        DishDataBase db = Room.databaseBuilder(getApplicationContext(), DishDataBase.class, "dish-db").allowMainThreadQueries().build();
        DishDao dishDao = db.dishDao();
        List<Dish> dishes = dishDao.getAll();
        //get the targeted view
        RecyclerView allDishesView = findViewById(R.id.allDishesView);
        //set the layout
        allDishesView.setLayoutManager(new LinearLayoutManager(this));
        //send the dishes to the dishAdapter to deal with the viewHolder and to display the list
        allDishesView.setAdapter(new DishAdapter(dishes));
        //button to send me back to the homePage
        Button backToHomeButton = findViewById(R.id.backTohomeButton);
        backToHomeButton.setOnClickListener(view -> {
            Intent backToHome = new Intent(Menu.this, MainActivity.class);
            startActivity(backToHome);
        });
    }
}