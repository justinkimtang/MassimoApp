package com.example.landonbedell.massimo;

import java.util.Observable;

/**
 * Created by branden on 26/04/16.
 */
public class TableModel extends Observable {
    private OrderModel order = new OrderModel();

    public void setFood(FoodModel food){
        order.setFood(food);
        setChanged();
        notifyObservers(order);
    }

    public void removeFood(int foodPos){
        order.removeFood(foodPos);
        setChanged();
        notifyObservers(order);
    }

    public void clearOrder(){
        order.clearOrder();
        setChanged();
        notifyObservers(order);
    }



}
