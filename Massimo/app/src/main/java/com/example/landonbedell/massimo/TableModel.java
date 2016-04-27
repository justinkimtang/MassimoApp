package com.example.landonbedell.massimo;

import java.util.Observable;

/**
 * Created by branden on 26/04/16.
 */
public class TableModel extends Observable {
    private OrderModel order = new OrderModel();

    public void setFood(FoodModel food){
        order.setFood(food);
        order.addSelectable();
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

    public void addSelected(int item, int uID) { order.addSelected(item, uID);    }

    public boolean has(int item, int uID) {
        return order.has(item, uID);
    }

    public boolean takeable(int item){ return order.isTakeable(item);}



    public void removeSelected(int item) { order.removeSelected(item);}

    public boolean isEmpty() {return order.isEmpty();}

    public void selectAll(int uID) {   order.selectAll(uID); }

}
