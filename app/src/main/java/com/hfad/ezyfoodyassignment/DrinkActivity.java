package com.hfad.ezyfoodyassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import com.hfad.ezyfoodyassignment.Adapters.ItemAdapter;
import com.hfad.ezyfoodyassignment.Models.ItemModel;
import com.hfad.ezyfoodyassignment.databinding.ActivityDrinkBinding;

import java.util.ArrayList;

public class DrinkActivity extends AppCompatActivity {

    ActivityDrinkBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDrinkBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<ItemModel> drinkarr = new ArrayList<>();

        drinkarr.add(new ItemModel(R.drawable.drink1, "Jambu Juice", "9000"));
        drinkarr.add(new ItemModel(R.drawable.drink2, "Mineral Water", "5000"));
        drinkarr.add(new ItemModel(R.drawable.drink3, "Orange Juice", "7000"));

        ItemAdapter adapter = new ItemAdapter(drinkarr,this);
        binding.drinkrecycle.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.drinkrecycle.setLayoutManager(layoutManager);
    }
}