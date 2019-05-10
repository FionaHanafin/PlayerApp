package com.example.playerapp;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] names;
    private final Integer[] ages;
    private final Integer[] height;
    private final String[] nation;
    private final Integer[] imgs;
    public static boolean[] bool;
    View rowView;
    LayoutInflater inflater;
    CheckBox checkBox;Button b;
    public MyListAdapter(Activity context, String[] name, Integer[] ages, Integer[] height, String[] nation, Integer[] img, boolean[] booleans) {
        super(context, R.layout.items, name);
        this.context=context;
        this.names=name;
        this.ages=ages;
        this.height = height;
        this.nation = nation;
        this.imgs=img;
        this.bool = booleans;
    }
    public static boolean[] getArray(){
        return bool;
    }
    public View getView(final int position, View view, ViewGroup parent) {
        inflater=context.getLayoutInflater();
        rowView=inflater.inflate(R.layout.items, null,true);

        TextView titleText = rowView.findViewById(R.id.text);
        ImageView imageView = rowView.findViewById(R.id.image);
        TextView subtitleText = rowView.findViewById(R.id.text2);
        checkBox = rowView.findViewById(R.id.check);
        titleText.setText(names[position]);
        imageView.setImageResource(imgs[position]);
        subtitleText.setText(nation[position]);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!bool[position]) {
                    bool[position] = true;
                }else {
                    bool[position] =false;
                }
            }
        });
        return rowView;
    }
}