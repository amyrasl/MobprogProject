package com.hfad.ezyfoodyassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.hfad.ezyfoodyassignment.Adapters.OrderAdapter;
import com.hfad.ezyfoodyassignment.Models.OrderModel;
import com.hfad.ezyfoodyassignment.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper helper = new DBHelper(this);
        ArrayList<OrderModel> listorderarr = helper.getOrder();

        OrderAdapter adapter = new OrderAdapter(listorderarr,this);
        binding.orderrecycle.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.orderrecycle.setLayoutManager(layoutManager);
    }
}