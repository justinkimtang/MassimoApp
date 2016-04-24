package com.example.landonbedell.massimo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by branden on 23/04/16.
 */
public class OrderView extends Activity {
    private ArrayList<String> foodNames = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_view);

        final OrderController orderController = new OrderController();

        FoodModel burger = new FoodModel("Burger", 8.75, 1);
        FoodModel fries = new FoodModel("Fries", 3.25, 1);
        FoodModel tacos = new FoodModel("Tacos", 8.75, 1);
        orderController.setFood(burger);
        orderController.setFood(fries);
        orderController.setFood(tacos);


        ListView foodList = (ListView)findViewById(R.id.foodViewList);



    }

    public void getFoodNames(OrderController ctrl){
        int orderSize = ctrl.getOrderSize();

    }
}
