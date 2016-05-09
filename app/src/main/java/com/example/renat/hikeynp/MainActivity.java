package com.example.renat.hikeynp;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;

    //making variables for each button
    private static Button trail_map_button;
    private static Button todo_list_button;
    private static Button photos_button;
    private static Button best_hikes_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //show icon in action bar
        toolbar.setLogo(R.drawable.ic_launcher);

        //defining methods for opening new activities on button click
        OnClickTrailMap();
        OnClickTodoList();
        OnClickPhotos();
        OnClickBestHikes();

        expandableListView = (ExpandableListView)findViewById(R.id.exp_listview);
        List<String> Headings = new ArrayList<String>();
        List<String> L1 = new ArrayList<String>();
        List<String> L2 = new ArrayList<String>();
        List<String> L3 = new ArrayList<String>();
        List<String> L4 = new ArrayList<String>();
        List<String> L5 = new ArrayList<String>();
        List<String> L6 = new ArrayList<String>();
        List<String> L7 = new ArrayList<String>();

        HashMap<String,List<String>> ChildList = new HashMap<String,List<String>>();
        String heading_items[] = getResources().getStringArray(R.array.header_titles);
        String l1[] = getResources().getStringArray(R.array.details);
        String l2[] = getResources().getStringArray(R.array.seasons);
        String l3[] = getResources().getStringArray(R.array.camping_and_lodging);
        String l4[] = getResources().getStringArray(R.array.shops_shuttles_and_tours);
        String l5[] = getResources().getStringArray(R.array.maps_and_guidebooks);
        String l6[] = getResources().getStringArray(R.array.food_and_drink);
        String l7[] = getResources().getStringArray(R.array.other_activities);

        for(String title : heading_items){
            Headings.add(title);
        }

        for(String title : l1){
            L1.add(title);
        }

        for(String title : l2){
            L2.add(title);
        }

        for(String title : l3){
            L3.add(title);
        }

        for(String title : l4){
            L4.add(title);
        }

        for(String title : l5){
            L5.add(title);
        }

        for(String title : l6){
            L6.add(title);
        }

        for(String title : l7){
            L7.add(title);
        }

        ChildList.put(Headings.get(0), L1);
        ChildList.put(Headings.get(1), L2);
        ChildList.put(Headings.get(2), L3);
        ChildList.put(Headings.get(3), L4);
        ChildList.put(Headings.get(4), L5);
        ChildList.put(Headings.get(5), L6);
        ChildList.put(Headings.get(6), L7);

        MyAdapter myAdapter = new MyAdapter(this,Headings,ChildList);
        expandableListView.setAdapter(myAdapter);
    }

    //method for opening trail google map activity
    public void OnClickTrailMap(){
        trail_map_button = (Button)findViewById(R.id.trail_map_button);
        trail_map_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent1 = new Intent("com.google.android.gms.maps.SupportMapFragment");
                        startActivity(intent1);
                    }
                }
        );
    }

    //method for opening your to-do list
    public void OnClickTodoList(){
        todo_list_button = (Button)findViewById(R.id.todo_list_button);
        todo_list_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent2 = new Intent("com.example.renat.hikeynp.todo_list");
                        startActivity(intent2);
                    }
                }
        );
    }

    //method for opening gallery of your own photos
    public void OnClickPhotos(){
        photos_button = (Button)findViewById(R.id.photos_button);
        photos_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent3 = new Intent("com.example.renat.hikeynp.photos");
                        startActivity(intent3);
                    }
                }
        );
    }

    //method for opening best hikes activity
    public void OnClickBestHikes(){
        best_hikes_button = (Button)findViewById(R.id.best_hikes_button);
        best_hikes_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent4 = new Intent("com.example.renat.hikeynp.best_hikes");
                        startActivity(intent4);
                    }
                }
        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
