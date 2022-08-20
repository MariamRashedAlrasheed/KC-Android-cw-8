package com.example.myapplicationcw7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.details_activity);super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();

        TextView itemNameTextView = findViewById(R.id.itemName);
        TextView itemPriceTextView = findViewById(R.id.itemPrice);
        ImageView itemImageView = findViewById(R.id.itemImage);

        Items currentItem = (Items) bundle.getSerializable("Items");

        itemNameTextView.setText(currentItem.getItemName());
        itemPriceTextView.setText(currentItem.getItemPrice()+"");
        itemImageView.setImageResource(currentItem.getItemImage());

    }
}