package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    DishDataBase db = Room.databaseBuilder(getApplicationContext(), DishDataBase.class,"dish-db").build();
    DishDao dishDao = db.dishDao();
    List<Dish> dishes = dishDao.getAll();
}