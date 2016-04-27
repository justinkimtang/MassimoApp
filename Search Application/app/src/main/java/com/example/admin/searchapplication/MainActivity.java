package com.example.admin.searchapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import com.example.admin.searchapplication.ExpandableListAdapter;

public class MainActivity extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Mexican");
        listDataHeader.add("Italian");
        listDataHeader.add("Indian");

        // Adding child data
        List<String> mexican = new ArrayList<String>();
        mexican.add("Burritos");
        mexican.add("Fajitas");
        mexican.add("Tortas");
        mexican.add("Tacos");
        mexican.add("Quesadillas");


        List<String> italian = new ArrayList<String>();
        italian.add("Chicken Alfredo");
        italian.add("Chicken Carbonara");
        italian.add("Garlic Bread");
        italian.add("Pizza");
        italian.add("Caprese Salad");


        List<String> indian = new ArrayList<String>();
        indian.add("Chicken Tikka Masala");
        indian.add("Saag Paneer");
        indian.add("Dal Makhni");
        indian.add("Dosa");
        indian.add("Samosa chat");

        listDataChild.put(listDataHeader.get(0), mexican); // Header, Child data
        listDataChild.put(listDataHeader.get(1), italian);
        listDataChild.put(listDataHeader.get(2), indian);
    }
}