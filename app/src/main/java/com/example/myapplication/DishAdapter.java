package com.example.myapplication;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DishAdapter extends RecyclerView.Adapter<DishAdapter.DishViewHolder> {
    //create a list to add all items that we want to display in the recyclerView
    List<Dish> dishesList = new ArrayList<Dish>();
    //create a constructor to the class
    public DishAdapter(List<Dish> dishesList) {
        this.dishesList = dishesList;
    }

    public static class DishViewHolder extends RecyclerView.ViewHolder {
        //Provide a reference to the type of views that i am using
        public Dish dish;
        View itemView;

        public DishViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            //Define click listener for the ViewHolder's View
            itemView.setOnClickListener(view -> {
                Intent goToDetailsPage = new Intent(view.getContext(), DishDetails.class);
                goToDetailsPage.putExtra("dishName", dish.dishName);
                goToDetailsPage.putExtra("dishPrice", dish.dishPrice);
                goToDetailsPage.putExtra("dishIngredients", dish.dishIngredients);
                view.getContext().startActivity(goToDetailsPage);
            });
        }
    }

    @NonNull
    @Override
    public DishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_dish, parent, false);
        DishViewHolder dishViewHolder = new DishViewHolder(view);
        return dishViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DishViewHolder holder, int position) {
        // Get dish from the list at this position
        holder.dish = dishesList.get(position);
        //set the data for the invoked dish
        TextView dishName = holder.itemView.findViewById(R.id.dishNameFrag);
        TextView dishPrice = holder.itemView.findViewById(R.id.dishPriceFrag);
        dishName.setText(holder.dish.dishName);
        dishPrice.setText(holder.dish.dishPrice);
    }

    @Override
    public int getItemCount() {
        return dishesList.size();
    }
}
