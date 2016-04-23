package com.example.landonbedell.massimo;

/**
 * Created by branden on 23/04/16.
 */

import java.util.ArrayList;
public class OrderModel {

    private ArrayList<FoodModel> order = new ArrayList<FoodModel>();

    public FoodModel getFood(int foodPos){
        return order.get(foodPos);
    }

    public void setFood(FoodModel food){
        order.add(food);
    }

    public int getOrderSize(){
        return order.size();
    }

    public void removeFood(int foodPos){
        order.remove(foodPos);
    }

    public void clearOrder(){
        order.clear();
    }
}
