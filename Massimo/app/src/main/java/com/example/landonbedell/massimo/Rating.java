package com.example.landonbedell.massimo;

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
}
