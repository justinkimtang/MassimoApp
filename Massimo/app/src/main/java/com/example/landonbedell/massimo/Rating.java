package com.example.landonbedell.massimo;

import java.util.ArrayList;

public class Rating {
    static int idCount = 0;
    private int rating_id;
    protected Ratable item;
    protected float ratingNum;

    public Rating(Ratable item, float ratingNum)
    {
        this.rating_id = nextId();
        this.item = item;
        this.ratingNum = ratingNum;
    }
    public int nextId(){
        idCount = idCount +1;
        return idCount;
    }
    public ArrayList<Ratable> accept(Recommender recommender, ArrayList<Ratable> recommmendations){
        return recommender.getRecommendation(recommmendations);
    }
}
