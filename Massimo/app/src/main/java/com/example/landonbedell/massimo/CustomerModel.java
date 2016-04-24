package com.example.landonbedell.massimo;

import java.util.ArrayList;

public class CustomerModel {
    private static CustomerModel currentCustomer = null;
    private ArrayList<FoodModel> pendingRatings;
    private String name;

    public CustomerModel(String name){
        this.name = name;
        this.pendingRatings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public static void setCurrentCustomer(CustomerModel customer){
        currentCustomer = customer;
    }

    public static CustomerModel getCurrentCustomer(){
        return currentCustomer;
    }

    public void clearPendingRatings(){
        pendingRatings.clear();
    }

    public void removePendingRatings(FoodModel food){
        pendingRatings.remove(food);
    }

    public void addPendingRatings(FoodModel food){
        pendingRatings.add(food);
    }

    public ArrayList<FoodModel> getPendingRatings(){
        return pendingRatings;
    }

}
