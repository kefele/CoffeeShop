package com.guenther.spring2.controller;

/**
 * Created by Gateway on 8/14/2017.
 */
public class Items {

    private String nameId;
    private String description;
    private int quantity;
    private float price;

    public Items(){
        nameId="";
        description="";
        quantity=0;
        price=0;

    }

    public Items(String name, String descrp,int quant, float cost){
        nameId=name;
        description=descrp;
        quantity= quant;
        price=cost;
    }


    public String getName() {
        return nameId;
    }

    public void setName(String nameId) {
        this.nameId = nameId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }





}
