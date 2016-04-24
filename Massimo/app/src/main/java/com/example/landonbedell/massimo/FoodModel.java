package com.example.landonbedell.massimo;

/**
 * Created by branden on 23/04/16.
 */
public class FoodModel
{
    static int idCount = 0;
    private int item_id;
    private float ratingStar;
    private String foodName;
    private double foodPrice;


    public FoodModel(){}

    public FoodModel(String foodName, double foodPrice)
    {
        this.item_id = nextId();
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public FoodModel(String foodName, double foodPrice, int ratingStar)
    {
        this.item_id = nextId();
        this.ratingStar = ratingStar;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public int nextId(){
        idCount = idCount +1;
        return idCount;
    }

    public int getItem_id(){ return item_id;}
    public double getFoodPrice()
    {
        return foodPrice;
    }

    public String getFoodName()
    {
        return foodName;
    }

    public float getRatingStar() {
        return ratingStar;
    }

    public void setRatingStar(float ratingStar) {
        this.ratingStar = ratingStar;
    }

    public void setFoodName(String foodName)
    {
        this.foodName = foodName;
    }

    public void setFoodPrice(double foodPrice)
    {
        this.foodPrice = foodPrice;
    }

    public String printString(){
        return this.foodName + "\t" + this.foodPrice;
    }
}
