package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
//create an interface with Dao annotate so we can access the database
//add methods to control the data
@Dao
public interface DishDao {
    @Query("SELECT * FROM dish")
    List<Dish> getAll();

    @Insert
    void insertDishes(Dish... dishes);

    @Delete
    void deleteDish(Dish dish);
}
