package com.example.landonbedell.massimo;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.app.Activity;

import java.util.ArrayList;

public class RateActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<FoodModel> adapter;
    private ArrayList<FoodModel> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_view);
        listView = (ListView)findViewById(R.id.list_view);
        setLisData();
        adapter = new RatingListViewAdapter(this, R.layout.single_rating, arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(onItemClickListener());
    }

    private AdapterView.OnItemClickListener onItemClickListener() {
        return new AdapterView.OnItemClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Dialog dialog = new Dialog(RateActivity.this);
                dialog.setContentView(R.layout.layout_dialog);
                dialog.setTitle("Movie details");

                TextView name = (TextView) dialog.findViewById(R.id.food_name);
                TextView starRate = (TextView) dialog.findViewById(R.id.rate);

                FoodModel food = (FoodModel) parent.getAdapter().getItem(position);
                name.setText("Food name: " + food.getFoodName());
                starRate.setText("Your rate: " + food.getRatingStar());

                dialog.show();
            }
        };
    }

   private void setLisData() {
        arrayList = new ArrayList<>();
        arrayList.add(new FoodModel("Taco", 2.00, 1));
        arrayList.add(new FoodModel("Burger", 3.00, 1));
        arrayList.add(new FoodModel("Pizza", 4.00, 1));
    }
}