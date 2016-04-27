package com.example.landonbedell.massimo;

/**
 * Created by branden on 23/04/16.
 */
import android.app.Application;

import java.util.Observable;
import java.util.Observer;


public class OrderController extends Application implements Observer{
    private OrderModel order;
    private OrderView view = new OrderView();

    @Override
    public void update(Observable observable, Object order){
        this.order = (OrderModel)order;
    }

    public FoodModel getFood(int foodPos){
        return order.getFood(foodPos);
    }



    public int getOrderSize(){
        return order.getOrderSize();
    }



    public double getTotal(int uId) { return order.sumPrice(uId); }

}


