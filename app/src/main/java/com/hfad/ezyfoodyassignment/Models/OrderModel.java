package com.hfad.ezyfoodyassignment.Models;

public class OrderModel {

    int orderImage;
    String ordername, orderprice, qty, totalprice, ordernum;

    public OrderModel(int orderImage, String ordername, String orderprice, String qty, String totalprice, String ordernum) {
        this.orderImage = orderImage;
        this.ordername = ordername;
        this.orderprice = orderprice;
        this.qty = qty;
        this.totalprice = totalprice;
        this.ordernum = ordernum;
    }

    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public String getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(String orderprice) {
        this.orderprice = orderprice;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

//    public String getTotalprice() {
//        return totalprice;
//    }
//
//    public void setTotalprice(String totalprice) {
//        this.totalprice = totalprice;
//    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }
}
