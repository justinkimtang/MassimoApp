package com.example.landonbedell.massimo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.RatingBar;
import android.view.View.OnTouchListener;
import java.util.ArrayList;

/**
 * Created by landonbedell on 4/27/16.
 */
public class RatableListViewAdapter extends BaseAdapter{

    private static ArrayList<Ratable> ratables;
    private static LayoutInflater mInflater;

    public RatableListViewAdapter(Context homeFragment, ArrayList<Ratable> results)
    {
        ratables = results;
        mInflater = LayoutInflater.from(homeFragment);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return ratables.size();
    }

    @Override
    public Ratable getItem(int arg0) {
        // TODO Auto-generated method stub
        return ratables.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.single_ratable, null);
            holder = new ViewHolder();
            holder.txtname = (TextView) convertView.findViewById(R.id.text);
            holder.rating = (RatingBar) convertView.findViewById(R.id.rate_img);


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtname.setText(ratables.get(position).getName());
        holder.rating.setRating(ratables.get(position).getRatingStar());
        holder.rating.setFocusable(false);
        holder.rating.setIsIndicator(true);
        return convertView;
    }

    static class ViewHolder{
        TextView txtname;
        RatingBar rating;
    }

}
