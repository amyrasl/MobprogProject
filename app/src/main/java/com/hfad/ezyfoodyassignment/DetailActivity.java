package com.hfad.ezyfoodyassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hfad.ezyfoodyassignment.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;
    int qty = 0;
    TextView jml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        jml = (TextView)findViewById(R.id.theqty);

        final int image = getIntent().getIntExtra("image",0);
        final String name = getIntent().getStringExtra("name");
        final int price = Integer.parseInt(getIntent().getStringExtra("price"));

        binding.detailimage.setImageResource(image);
        binding.detailname.setText(name);
        binding.detailprice.setText(String.format("%d",price));

        DBHelper helper = new DBHelper(this);

        binding.addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = helper.insertOrder(
                        name,
                        price,
                        image,
                        binding.theqty.getText().toString());

                if(isInserted){
                    Toast.makeText(DetailActivity.this, "Data has been successfully inputted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(DetailActivity.this, "Data input failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void adds(View view){
        qty++;
        jml.setText(Integer.toString(qty));
    }

    public void subs(View view){
        qty--;
        jml.setText(Integer.toString(qty));
    }


}