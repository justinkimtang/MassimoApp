package com.example.landonbedell.massimo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by branden on 23/04/16.
 */
public class PayView extends AppCompatActivity {
    ArrayAdapter<String> arrayAdapter;
    double total;
    private ListView tipList;
    TextView totalDisplay;
    OrderController orderController;
    int uID = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        orderController = (OrderController)getApplicationContext();
        totalDisplay = (TextView)findViewById(R.id.total);
        total = orderController.getTotal(uID);
        displayTotal(0.0);
        tipList = (ListView)findViewById(R.id.tipViewList);
        createListView();
        tipList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    updateTipDisp(position);
            }
        });

    }

    public void displayTotal(double tip){
        totalDisplay.setText("\nTotal:\n" + String.format("$%.2f*", total*(1+tip)));
    }

    public void updateTipDisp(int position){
        ArrayList<Integer> positions = new ArrayList<Integer>(){{ add(0); add(1); add(2); }};
        positions.remove(position);
        tipList.getChildAt(position).setBackgroundColor(Color.rgb(204,255,102));
        int pos;
        for (int i = 0; i < positions.size(); i++){
            pos = positions.get(i);
            tipList.getChildAt(pos).setBackgroundColor(0x125688);
        }
        if (position == 0) displayTotal(0.15);
        else if (position == 1) displayTotal(0.18);
        else displayTotal(0.20);
    }

    public void createListView(){
        ArrayList<String> tipAmount = new ArrayList<String>(){{
            add("%15 (" + String.format("$%.2f", total*.15) + ")");
            add("%18 (" + String.format("$%.2f", total*.18) + ")");
            add("%20 (" + String.format("$%.2f", total*.2) + ")");
        }};
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tipAmount);
        tipList.setAdapter(arrayAdapter);

    }

    public void pay(View view){
        CustomerModel cust = CustomerModel.getCurrentCustomer();
        System.out.println(orderController.getOrderSize());
        for(int i = 0; i < orderController.getOrderSize(); i++){
            cust.addPendingRatings(orderController.getFood(i));
        }
        Intent i = new Intent(getBaseContext(), RateActivity.class);
        startActivity(i);
    }
}
