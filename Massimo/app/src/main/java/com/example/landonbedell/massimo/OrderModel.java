package com.example.landonbedell.massimo;

/**
 * Created by branden on 23/04/16.
 */

import java.util.ArrayList;
public class OrderModel {

    private ArrayList<FoodModel> order = new ArrayList<FoodModel>();
    private ArrayList<Integer> selected = new ArrayList<Integer>();

    public void removeSelected(int itemNum){
        int index = selected.indexOf(itemNum);
        selected.remove(index);
    }

    public void addSelected(int itemNum){
        selected.add(itemNum);
    }

    public boolean isEmpty(){
        return selected.isEmpty();
    }

    public boolean has(int item){
        return  selected.contains(item);
    }

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

    public void selectAll(){
        int sizeSelected = getOrderSize();
        for (int i = 0; i < sizeSelected; i++)
        {
            selected.add(i);
        }
    }

    public void clearOrder(){
        order.clear();
    }
}
