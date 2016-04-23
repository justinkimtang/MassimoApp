package com.example.landonbedell.massimo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;


import java.util.ArrayList;

/**
 * Created by branden on 23/04/16.
 */
public class OrderView extends AppCompatActivity {
    private ArrayList<String> foodNames = new ArrayList<String>();
    private SwipeRefreshLayout swipeContainer;
    private Toolbar toolbar;

    private ListView foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        

        final OrderController orderController = new OrderController();
        foodList = (ListView)findViewById(R.id.foodViewList);
        FoodModel burger = new FoodModel("Burger", 8.75);
        FoodModel fries = new FoodModel("Fries", 3.25);
        FoodModel tacos = new FoodModel("Tacos", 8.75);
        orderController.setFood(burger);
        orderController.setFood(fries);
        orderController.setFood(tacos);
        updateFoodNamesList(orderController);
        updateListView();

        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                FoodModel drink = new FoodModel("Drink", 2.75);
                orderController.setFood(drink);
                updateFoodNamesList(orderController);
                updateListView();
                swipeContainer.setRefreshing(false);
            }
        });
    }

    public void updateFoodNamesList(OrderController ctrl){
        int prevOrderSize = foodNames.size();
        int newOrderSize = ctrl.getOrderSize();
        for (int i = prevOrderSize; i < newOrderSize; i++){
            foodNames.add(ctrl.getFood(i).getFoodName());
        }

    }

    public void updateListView(){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,foodNames);
        foodList.setAdapter(arrayAdapter);


    }

}
