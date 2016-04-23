package com.example.landonbedell.massimo;

/**
 * Created by branden on 23/04/16.
 */
public class FoodModel
{
    private String foodName;
    private double foodPrice;

    public FoodModel(){}

    public FoodModel(String foodName, double foodPrice)
    {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public double getFoodPrice()
    {
        return foodPrice;
    }

    public String getFoodName()
    {
        return foodName;
    }

    public void setFoodName(String foodName)
    {
        this.foodName = foodName;
    }

    public void setFoodPrice(double foodPrice)
    {
        this.foodPrice = foodPrice;
    }
}
