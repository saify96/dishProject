package com.example.myapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;
//create database class to hold the database.
//select the entities that the database will deal with
//extends RoomDatabase
@Database(entities ={Dish.class}, version=1)
public abstract class DishDataBase extends RoomDatabase {
    public abstract DishDao dishDao();
}
