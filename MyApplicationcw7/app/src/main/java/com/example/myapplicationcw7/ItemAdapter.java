package com.example.myapplicationcw7;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ItemAdapter extends ArrayAdapter {
    List<Items> itemsList;

    public ItemAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        itemsList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_row, parent, false);

        Items currentItems = itemsList.get(position);
        TextView itemNameTextView = view.findViewById(R.id.itemName);
        TextView itemPriceTextView = view.findViewById(R.id.itemPrice);
        ImageView itemImageTextView = view.findViewById(R.id.itemImage);

        itemNameTextView.setText(currentItems.getItemName());
        itemPriceTextView.setText(currentItems.getItemName());
        itemImageTextView.setImageResource(currentItems.getItemImage());
        ImageView removeButon = view.findViewById(R.id.removeButon);
        removeButon.setOnClickListener(new View.OnClickListener() {
            Items removeItem = itemsList.get(position);
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext()).setMessage("Are you sure you want to remove that?")
                        .setTitle("Confirmation").setPositiveButton("Remove", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                itemsList.remove(removeItem);
                                notifyDataSetChanged();
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                                   builder.show();
            }
        });
           return view;
    }
}

