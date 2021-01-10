package com.hfad.ezyfoodyassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TopupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);
    }

    public void showingtoast(View view){
        Toast.makeText(TopupActivity.this, "Successfully inputted", Toast.LENGTH_SHORT).show();
    }
}