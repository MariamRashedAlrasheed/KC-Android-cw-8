package com.example.myapplicationcw7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
         ArrayList<Items> itemsArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.itemName);
        TextView textView1 = findViewById(R.id.itemPrice);
        ImageView ImageView = findViewById(R.id.itemImage);
        Intent intent = new Intent();
        String name = "cheese";
        Items item1 = new Items("cheese",R.drawable.cheese, 2.900);
        Items item2 = new Items("chocolate", R.drawable.chocolate, 6.750);
        Items item3 = new Items("coffee", R.drawable.coffee, 2.600);
        Items item4 = new Items("donut", R.drawable.donut, 5.250);
        Items item5 = new Items("fries", R.drawable.fries,4.500);
        Items item6 = new Items("honey", R.drawable.honey, 9.990);

        itemsArrayList.add(item1);
        itemsArrayList.add(item2);
        itemsArrayList.add(item3);
        itemsArrayList.add(item4);
        itemsArrayList.add(item5);
        itemsArrayList.add(item6);

        ItemAdapter itemAdapter = new ItemAdapter(this,0, itemsArrayList);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(itemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Items currentItems = itemsArrayList.get(i);
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("Items",currentItems);
                 startActivity(intent);
            }
        });





        }
    }