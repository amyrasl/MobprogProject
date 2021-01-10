package com.hfad.ezyfoodyassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.hfad.ezyfoodyassignment.Models.ItemModel;
import com.hfad.ezyfoodyassignment.databinding.ActivityMainBinding;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    public static Vector<ItemModel> theOrder = new Vector<>();
    Button drinkbtn, snackbtn, foodbtn, topupbtn, historybtn, locationbtn;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);

        drinkbtn = findViewById(R.id.drinkbtn);
        snackbtn = findViewById(R.id.snackbtn);
        foodbtn = findViewById(R.id.foodbtn);
        topupbtn = findViewById(R.id.topupbtn);
        historybtn = findViewById(R.id.historybtn);

        foodbtn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), FoodActivity.class);
            startActivity(intent);
        });

        drinkbtn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), DrinkActivity.class);
            startActivity(intent);
        });

        snackbtn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SnackActivity.class);
            startActivity(intent);
        });

        topupbtn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), TopupActivity.class);
            startActivity(intent);
        });

        historybtn.setOnClickListener(v -> {
            //
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this,OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void gotolocation(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}