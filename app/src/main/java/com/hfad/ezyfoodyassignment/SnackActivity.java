package com.hfad.ezyfoodyassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.hfad.ezyfoodyassignment.Adapters.ItemAdapter;
import com.hfad.ezyfoodyassignment.Models.ItemModel;
import com.hfad.ezyfoodyassignment.databinding.ActivityDrinkBinding;
import com.hfad.ezyfoodyassignment.databinding.ActivitySnackBinding;

import java.util.ArrayList;

public class SnackActivity extends AppCompatActivity {
    ActivitySnackBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySnackBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<ItemModel> snackarr = new ArrayList<>();

        snackarr.add(new ItemModel(R.drawable.snack1, "Pempek", "12000"));
        snackarr.add(new ItemModel(R.drawable.snack2, "Cireng", "5000"));

        ItemAdapter adapter = new ItemAdapter(snackarr,this);
        binding.snackrecycle.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.snackrecycle.setLayoutManager(layoutManager);
    }
}