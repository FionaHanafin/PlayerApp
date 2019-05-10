package com.example.playerapp;


import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] names;

    private final String[] nation;
    private final Drawable[] imgs;
    private boolean bool[];
    public SecondAdapter(Activity context, String[] name, String[] nation,Integer[] ages, Integer[] height, Drawable[] img) {
        super(context, R.layout.items,name);
        this.context = context;
        this.names = name;
        this.nation = nation;
        this.imgs = img;
    }

    public View getView(int position2, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView =inflater.inflate(R.layout.items, null, true);
        TextView titleText = rowView.findViewById(R.id.text);
        ImageView imageView = rowView.findViewById(R.id.image);
        TextView subtitleText = rowView.findViewById(R.id.text2);
        CheckBox c = rowView.findViewById(R.id.check);
        c.setVisibility(View.GONE);
        titleText.setText(names[position2]);
        imageView.setImageDrawable(imgs[position2]);
        subtitleText.setText(nation[position2]);
        return rowView;
    }
}