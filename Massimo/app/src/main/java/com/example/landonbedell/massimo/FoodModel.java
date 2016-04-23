package com.example.landonbedell.massimo;

/**
 * Created by branden on 23/04/16.
 */
public class FoodModel
{
    private String foodName;
    private int foodPrice;

    public FoodModel(){}

    public FoodModel(String foodName, int foodPrice)
    {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public int getFoodPrice()
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

    public void setFoodPrice(int foodPrice)
    {
        this.foodPrice = foodPrice;
    }
}
