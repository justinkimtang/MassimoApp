package com.example.landonbedell.massimo;

/**
 * Created by branden on 23/04/16.
 */
import android.app.Application;


public class OrderController extends Application{
    private OrderModel order = new OrderModel();
    //private OrderView view = new OrderView();

    public FoodModel getFood(int foodPos){
        return order.getFood(foodPos);
    }

    public void setFood(FoodModel food){
        order.setFood(food);
    }

    public int getOrderSize(){
        return order.getOrderSize();
    }

    public void removeFood(int foodPos){
        order.removeFood(foodPos);
    }

    public void clearOrder(){
        order.clearOrder();
    }
    public void updateView(){

    }

}


