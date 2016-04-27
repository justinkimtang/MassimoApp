package com.example.landonbedell.massimo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class RatingListViewAdapter extends ArrayAdapter<Rating> {

    private AppCompatActivity activity;
    private List<Rating> itemList;

    public RatingListViewAdapter(AppCompatActivity context, int resource, List<Rating> objects) {
        super(context, resource, objects);
        this.activity = context;
        this.itemList = objects;
    }

    @Override
    public Rating getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public void remove(Rating r) {
        itemList.remove(r);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.single_rating, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
            //holder.ratingBar.getTag(position);
        }

        holder.ratingBar.setOnRatingBarChangeListener(onRatingChangedListener(holder, position));
        holder.submitOne.setOnClickListener(onClickListener(holder,position));
        holder.ratingBar.setTag(position);
        holder.ratingBar.setRating(getItem(position).ratingNum);
        holder.itemName.setText(getItem(position).item.getName());

        return convertView;
    }

    private RatingBar.OnRatingBarChangeListener onRatingChangedListener(final ViewHolder holder, final int position) {
        return new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Rating item = getItem(position);
                item.ratingNum = v;
                Log.i("Adapter", "star: " + v);
            }
        };
    }
    private ImageButton.OnClickListener onClickListener(final ViewHolder holder, final int position){
        return new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rating r = getItem(position);
                CustomerModel.getCurrentCustomer().submitPendingRatings(r);
                remove(r);
                notifyDataSetChanged();
            }
        };
    }




    private static class ViewHolder {
        private RatingBar ratingBar;
        private TextView itemName;
        private ImageButton submitOne;
        public ViewHolder(View view) {
            ratingBar = (RatingBar) view.findViewById(R.id.rate_img);
            itemName = (TextView) view.findViewById(R.id.text);
            submitOne = (ImageButton) view.findViewById(R.id.submitOneRating);
        }
    }
}