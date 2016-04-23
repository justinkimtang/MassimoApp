package com.example.landonbedell.massimo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by branden on 23/04/16.
 */
public class OrderView extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_view);

        final OrderContoller orderController = new OrderContoller();

        FoodModel burger = new FoodModel("Burger", 8.75);
        FoodModel fries = new FoodModel("Fries", 3.25);
        FoodModel tacos = new FoodModel("Tacos", 8.75);
        orderController.setFood(burger);
        orderController.setFood(fries);
        orderController.setFood(tacos);

        ListView foodList = (ListView)findViewById(R.id.foodViewList);

    }
}
