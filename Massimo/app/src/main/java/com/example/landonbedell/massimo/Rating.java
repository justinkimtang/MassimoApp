package com.example.landonbedell.massimo;

import java.util.ArrayList;
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
        return recommendations;
    }
    static public ArrayList<Ratable> getCustTopChoices(String cust_id)
    {
        ArrayList<Ratable> top = new ArrayList<>();
        for(Rating rating: allRatings)
        {
            if((cust_id.equals(rating.customer_name)) && (rating.ratingNum > 3))
            {
                top.add(rating.item);
            }

        }
        return top;
    }
}
