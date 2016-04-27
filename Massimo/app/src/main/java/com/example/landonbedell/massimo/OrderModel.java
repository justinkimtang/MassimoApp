package com.example.landonbedell.massimo;

/**
 * Created by branden on 23/04/16.
 */

import java.util.ArrayList;
public class OrderModel {

    private ArrayList<FoodModel> order = new ArrayList<FoodModel>();
    private ArrayList<Integer> selected = new ArrayList<Integer>();

    public void removeSelected(int itemNum){
        selected.set(itemNum, -1);
    }

    public boolean isTakeable(int pos){
        if (selected.get(pos) == -1){
            return true;
        }
        else return false;
    }

    public void addSelectable() {selected.add(-1);}

    public void addSelected(int itemNum, int uID){
        selected.set(itemNum, uID);
    }

    public boolean isEmpty(){
        boolean empty = true;
        for (int i = 0; i < order.size(); i++){
            if (selected.get(i) != -1){
                empty = false;
                break;
            }
        }
        return empty;
    }

    public boolean has(int item, int uID){
        if (selected.get(item) == uID)
            return true;
        else return false;
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

    public void selectAll(int uId){
        int sizeSelected = getOrderSize();
        for (int i = 0; i < sizeSelected; i++)
        {
            selected.set(i,uId);
        }
    }

    public double sumPrice(int uId){
        double total = 0;
        int index;
        FoodModel food;
        for (int i = 0; i < selected.size(); i++){
            if (selected.get(i) == uId) {;
                food = order.get(i);
                total += food.getFoodPrice();
            }
        }
        return total;
    }

    public ArrayList<Integer> getMySelected(int uID){
        ArrayList<Integer> mySelected = new ArrayList<Integer>();
        for (int i = 0; i < order.size(); i++){
            if (selected.get(i) == uID){
                mySelected.add(i);
            }
        }
        return mySelected;
    }

    public void clearOrder(){
        order.clear();
    }
}
