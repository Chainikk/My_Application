package com.example.myapplication11;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListAdapter extends ArrayAdapter<Item> {
    private final LayoutInflater inflater;
    private final int layout;
    private final List<Item> items;

    public ListAdapter(@NonNull Context context, int resource, List<Item> items) {
        super(context, resource, items);
        this.inflater = LayoutInflater.from(context);
        this.layout = resource;
        this.items = items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);
        TextView textView = view.findViewById(R.id.textViewItem);
        ImageView imageView = view.findViewById(R.id.imageViewItem);
        Item item = items.get(position);
        textView.setText(item.getText());
        imageView.setImageResource(item.getImageResource());


        return view;
    }
}
