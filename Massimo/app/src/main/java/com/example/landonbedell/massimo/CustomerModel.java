package com.example.landonbedell.massimo;

import java.util.ArrayList;

public class CustomerModel {
    private static CustomerModel currentCustomer = null;
    private ArrayList<Rating> pendingRatings;
    private ArrayList<Rating> customerRatings;

    private ArrayList<Ratable> recommendations = new ArrayList<>();
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
    public ArrayList<Ratable> getRecommendations() {
        requestRecommendations();
        return recommendations;
    }
    public static CustomerModel getCurrentCustomer(){
        return currentCustomer;
    }

    public void requestRecommendations()
    {
        recommendations = Rating.getRecommendation(customerRatings);
    }

    public void clearPendingRatings(){
        pendingRatings.clear();
    }

    public void removePendingRatings(Rating rating){
        pendingRatings.remove(rating);
    }

    public void submitPendingRatings(Rating rating)
    {
        customerRatings.add(rating);
        pendingRatings.remove(rating);
    }

    public void addPendingRatings(Ratable item)
    {
        Rating rating = new Rating(name,item,0);
        pendingRatings.add(rating);
    }

    public ArrayList<Rating> getPendingRatings(){
        return pendingRatings;
    }

}
