package com.hfad.ezyfoodyassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.hfad.ezyfoodyassignment.Adapters.ItemAdapter;
import com.hfad.ezyfoodyassignment.Models.ItemModel;
import com.hfad.ezyfoodyassignment.databinding.ActivityFoodBinding;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {

    ActivityFoodBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<ItemModel> foodarr = new ArrayList<>();

        foodarr.add(new ItemModel(R.drawable.food1, "Sate Padang","15000"));
        foodarr.add(new ItemModel(R.drawable.food2, "Laksa Tangerang","25000"));
        foodarr.add(new ItemModel(R.drawable.food3, "Bubur Ayam","10000"));

        ItemAdapter adapter = new ItemAdapter(foodarr, this);
        binding.foodrecycle.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.foodrecycle.setLayoutManager(layoutManager);
    }

}