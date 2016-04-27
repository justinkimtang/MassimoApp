package com.example.landonbedell.massimo;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.app.Activity;

import java.util.ArrayList;

public class RateActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<Rating> adapter;
    private ArrayList<Rating> arrayList;
    private CustomerModel customer = CustomerModel.getCurrentCustomer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_view);
        listView = (ListView)findViewById(R.id.list_view);
        arrayList = customer.getPendingRatings();
        adapter = new RatingListViewAdapter(this, R.layout.single_rating, arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(onItemClickListener());
        submitButtonListener();
        exitButtonListener();
    }

    private AdapterView.OnItemClickListener onItemClickListener() {
        return new AdapterView.OnItemClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Dialog dialog = new Dialog(RateActivity.this);
                dialog.setContentView(R.layout.layout_dialog);
                dialog.setTitle("Food details");

                TextView name = (TextView) dialog.findViewById(R.id.food_name);
                TextView starRate = (TextView) dialog.findViewById(R.id.rate);

                Rating rating = (Rating) parent.getAdapter().getItem(position);
                name.setText("Food name: " + rating.item.getName());
                starRate.setText("Your rate: " + rating.ratingNum);

                dialog.show();
            }
        };
    }
    public void exitButtonListener() {
        ImageButton exitBtn = (ImageButton) findViewById(R.id.exit);

        assert exitBtn != null;
        exitBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), MainActivity.class);
                startActivity(i);

            }

        });
    }
    public void submitButtonListener() {
        Button submitBtn = (Button) findViewById(R.id.submitRating);

        assert submitBtn != null;
        submitBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                customer.clearPendingRatings();
                Intent i = new Intent(getBaseContext(), MainActivity.class);
                startActivity(i);

            }

        });
    }
}