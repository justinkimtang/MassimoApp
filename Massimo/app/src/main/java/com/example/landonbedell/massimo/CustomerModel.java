package com.example.landonbedell.massimo;

import java.util.ArrayList;

public class CustomerModel {
    private static CustomerModel currentCustomer = null;
    private ArrayList<Rating> pendingRatings;
    private ArrayList<Rating> customerRatings;
    private ArrayList<Ratable> recommendations;
    private String name;

    public CustomerModel(String name){
        this.name = name;
        this.pendingRatings = new ArrayList<>();
        this.customerRatings = new ArrayList<>();
        this.recommendations = new ArrayList<>();
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

    public void requestRecommendations(ArrayList<Rating> customerRatings)
    {
        Recommender recommender = new BasicRecommender();
        for(Rating item: customerRatings)
        {
            recommendations = item.accept(recommender,recommendations);
        }

    }

    public void clearPendingRatings(){
        pendingRatings.clear();
    }

    public void removePendingRatings(Rating rating){
        pendingRatings.remove(rating);
    }

    public void addPendingRatings(Ratable item)
    {
        Rating rating = new Rating(item,0);
        pendingRatings.add(rating);
    }

    public ArrayList<Rating> getPendingRatings(){
        return pendingRatings;
    }

}
