package com.hfad.ezyfoodyassignment.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.ezyfoodyassignment.DBHelper;
import com.hfad.ezyfoodyassignment.Models.OrderModel;
import com.hfad.ezyfoodyassignment.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.viewHolder>{

    ArrayList<OrderModel> orderlist;
    Context context;

    public OrderAdapter(ArrayList<OrderModel> orderlist, Context context) {
        this.orderlist = orderlist;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.detail_order, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final OrderModel model = orderlist.get(position);
        holder.orderimage.setImageResource(model.getOrderImage());
        holder.ordername.setText(model.getOrdername());
        holder.orderprice.setText(model.getOrderprice());
        holder.qty.setText(model.getQty());

        String price = model.getOrderprice();
        String qty = model.getQty();

        int x = Integer.parseInt(price);
        int y = Integer.parseInt(qty);
        int z = (x*y);

        String totalprice =  Integer.toString(z);

        holder.total.setText(totalprice);

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View view) {
                DBHelper helper = new DBHelper(context);
                if (helper.deletedOrder(model.getOrdernum()) > 0) {
                    Toast.makeText(context,"it's deleted",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context,"ERROR!",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return orderlist.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView orderimage;
        TextView ordername, orderprice, qty, total;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
            orderimage = itemView.findViewById(R.id.orderimage);
            ordername = itemView.findViewById(R.id.ordername);
            orderprice = itemView.findViewById(R.id.orderprice);
            qty = itemView.findViewById(R.id.orderqty);
            total = itemView.findViewById(R.id.total);
        }
    }

}
