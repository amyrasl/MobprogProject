package com.hfad.ezyfoodyassignment.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hfad.ezyfoodyassignment.DetailActivity;
import com.hfad.ezyfoodyassignment.Models.ItemModel;
import com.hfad.ezyfoodyassignment.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.viewholder>{

    ArrayList<ItemModel> itemlist;
    Context context;

    public ItemAdapter(ArrayList<ItemModel> itemlist, Context context) {
        this.itemlist = itemlist;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.detail_item, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final ItemModel model = itemlist.get(position);
        holder.itemImage.setImageResource(model.getImage());
        holder.name.setText(model.getItemname());
        holder.price.setText(model.getItemprice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("image",model.getImage());
                intent.putExtra("name",model.getItemname());
                intent.putExtra("price",model.getItemprice());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemlist.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        ImageView itemImage;
        TextView name, price;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.orderimage);
            name = itemView.findViewById(R.id.ordername);
            price = itemView.findViewById(R.id.orderprice);
        }
    }
}
