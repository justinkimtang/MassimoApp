package com.example.landonbedell.massimo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
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
    private ListView foodList;
    ArrayAdapter<String> arrayAdapter;
    OrderController orderController;
    TableModel table;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        table = new TableModel();
        orderController = (OrderController) getApplicationContext();
        table.addObserver(orderController);
        foodList = (ListView)findViewById(R.id.foodViewList);
        FoodModel burger = new FoodModel("Burger", 8.75);
        FoodModel fries = new FoodModel("Fries", 3.25);
        FoodModel tacos = new FoodModel("Tacos", 8.75);
        table.setFood(burger);
        table.setFood(fries);
        table.setFood(tacos);

        updateFoodNamesList(orderController);
        createListView();
        foodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (orderController.has(position)) {
                    orderController.removeSelected(position);
                    view.setBackgroundColor(0x125688);
                }
                else {
                    orderController.addSelected(position);
                    view.setBackgroundColor(Color.rgb(204,255,102));
                }
            }
        });

        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                FoodModel drink = new FoodModel("Beer", 2.75);
                table.setFood(drink);
                updateFoodNamesList(orderController);
                arrayAdapter.notifyDataSetChanged();
                swipeContainer.setRefreshing(false);
            }
        });

    }

    public void updateFoodNamesList(OrderController ctrl){
        int prevOrderSize = foodNames.size();
        int newOrderSize = ctrl.getOrderSize();
        for (int i = prevOrderSize; i < newOrderSize; i++){
            foodNames.add(ctrl.getFood(i).getFoodName() + ": $" + ctrl.getFood(i).getFoodPrice());
        }

    }

    public void createListView(){
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,foodNames);
        foodList.setAdapter(arrayAdapter);

    }

    public void checkout(View view){
        Context context = this;
        if (orderController.isEmpty()){
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which){
                        case DialogInterface.BUTTON_POSITIVE:
                            orderController.selectAll();
                            pay();
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            break;
                    }
                }
            };
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("You selected no items, would you like to pay for them all?").setPositiveButton("Yes", dialogClickListener)
                    .setNegativeButton("No", dialogClickListener).show();

        }
        else
            pay();
    }

    public void pay(){
        Intent i = new Intent(getBaseContext(), PayView.class);
        startActivity(i);
    }

}
