package com.example.landonbedell.massimo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class Rating {
    private static ArrayList<Rating> allRatings = new ArrayList<>();
    private String customer_name;
    protected Ratable item;
    protected float ratingNum;

    public Rating(String name, Ratable item, float ratingNum)
    {
        this.customer_name = name;
        this.item = item;
        this.ratingNum = ratingNum;
        allRatings.add(this);
    }

    static public ArrayList<Ratable> getRecommendation(ArrayList<Rating> preferenceArray)
    {

        ArrayList<Ratable> recommendations = new ArrayList<>();
        for(Rating custRating: preferenceArray)
        {
            for(Rating rating: allRatings)
            {
                if((rating.item == custRating.item) && (Math.abs(rating.ratingNum-custRating.ratingNum) > 2))
                {
                    recommendations.addAll(getCustTopChoices(rating.customer_name));
                }
            }

        }
        Set<Ratable> hs = new HashSet<>();
        hs.addAll(recommendations);
        recommendations.clear();
        recommendations.addAll(hs);
        return  recommendations;
    }
    static public ArrayList<Ratable> getCustTopChoices(String cust_id)
    {
        ArrayList<Ratable> top = new ArrayList<>();
        for(Rating rating: allRatings)
        {
            if((cust_id.equals(rating.customer_name)) && (rating.ratingNum > 3) )
            {
                top.add(rating.item);
            }

        }
        return top;
    }

    public static ArrayList<Rating> generateRatings()
    {
        FoodModel f1 = new FoodModel("Hamburger",3.00);
        FoodModel f2 = new FoodModel("Pizza",4.00);
        FoodModel f3 = new FoodModel("Sushi",6.75);
        FoodModel f4 = new FoodModel("Burrito",4.00);
        FoodModel f5 = new FoodModel("Cheese burger",5.00);
        FoodModel f6 = new FoodModel("Spam",1.00);
        FoodModel f7 = new FoodModel("Mac & Cheese",3.25);


        ArrayList<Rating> ratings = new ArrayList<>();
        ratings.add(new Rating("Joe",f1,4));
        ratings.add(new Rating("Joe",f2,5));
        ratings.add(new Rating("Joe",f3,2));
        ratings.add(new Rating("Joe",f4,3));

        ratings.add(new Rating("Emma",f1,3));
        ratings.add(new Rating("Emma",f2,3));
        ratings.add(new Rating("Emma",f3,5));
        ratings.add(new Rating("Emma",f4,5));
        return ratings;
    }
}
