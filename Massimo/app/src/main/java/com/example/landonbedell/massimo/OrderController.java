package com.example.landonbedell.massimo;

/**
 * Created by branden on 23/04/16.
 */
import android.app.Application;

import java.util.Observable;
import java.util.Observer;


public class OrderController extends Application implements Observer{
    private OrderModel order;
    //private OrderView view = new OrderView();

    @Override
    public void update(Observable observable, Object order){
        this.order = (OrderModel)order;
    }

    public FoodModel getFood(int foodPos){
        return order.getFood(foodPos);
    }

    public boolean has(int item) { return order.has(item);  }

    public void removeSelected(int item) { order.removeSelected(item);}

    public int getOrderSize(){
        return order.getOrderSize();
    }

    public void addSelected(int item) { order.addSelected(item);    }

    public boolean isEmpty() {return order.isEmpty();}

    public void selectAll() {   order.selectAll(); }

    public double getTotal() { return order.sumPrice(); }

}


