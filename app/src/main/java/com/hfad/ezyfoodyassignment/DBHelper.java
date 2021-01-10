package com.hfad.ezyfoodyassignment;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.hfad.ezyfoodyassignment.Models.OrderModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper{

    final static String DBNAME = "mydb.db";
    final static int DBVERSION = 2;

    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table orders "+
                        "(id integer primary key autoincrement," +
                        "itemname text," +
                        "itemprice int, " +
                        "itemimg int," +
                        "itemqty int)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE if exists orders");
        onCreate(sqLiteDatabase);
    }

    //insert
    public boolean insertOrder(String itemname, int itemprice, int itemimg, String itemqty){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("itemname",itemname);
        values.put("itemprice",itemprice);
        values.put("itemimg",itemimg);
        values.put("itemqty",itemqty);
        long id = database.insert("orders",null,values);
        if(id <= 0){
            return false;
        }else{
            return true;
        }
    }

    //ambil data dari db
    public ArrayList<OrderModel> getOrder(){
        ArrayList<OrderModel> orderarr = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from orders", null);
        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){
                OrderModel model = new OrderModel(0,null,null,null,null,null);
                model.setOrdernum(cursor.getInt(0)+"");
                model.setOrdername(cursor.getString(1));
                model.setOrderprice(cursor.getInt(2) +"");
                model.setOrderImage(cursor.getInt(3));
                model.setQty(cursor.getString(4));
                orderarr.add(model);
            }
        }
        cursor.close();
        database.close();
        return orderarr;
    }

    public int deletedOrder(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("orders","id="+id,null);
    }

}
