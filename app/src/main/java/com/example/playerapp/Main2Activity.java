package com.example.playerapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main2Activity extends AppCompatActivity {
    Intent i;
    Bundle b;

    boolean bool[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        i = getIntent();
        b = i.getExtras();
        setContentView(R.layout.activity_main2);
        bool = b.getBooleanArray("players");
        String names[] = {
                getResources().getString(R.string.mesut), getResources().getString(R.string.aaron), getResources().getString(R.string.alexandre),
                getResources().getString(R.string.denis), getResources().getString(R.string.granit), getResources().getString(R.string.hector),
                getResources().getString(R.string.henrikh ), getResources().getString(R.string.pierre), getResources().getString(R.string.shkodran)};
        String nationality[] = {
                getResources().getString(R.string.mesut_nat), getResources().getString(R.string.aaron_nat),getResources().getString(R.string.alexandre_nat),
                getResources().getString(R.string.denis_nat),  getResources().getString(R.string.granit_nat),  getResources().getString(R.string.hector_nat),
                getResources().getString(R.string.henrikh_nat),  getResources().getString(R.string.pierre_nat),  getResources().getString(R.string.shkodran_nat)};
        Integer ages[] = {
                (R.string.mesut_age),(R.string.aaron_age), (R.string.alexandre_age),
                (R.string.denis_age),(R.string.granit_age), (R.string.hector_age),
                (R.string.henrikh_age ), (R.string.pierre_age), (R.string.shkodran_age)};
        Integer height[] = {
                (R.string.mesut_height), (R.string.aaron_height), (R.string.alexandre_height),
                (R.string.denis_height), (R.string.granit_height), (R.string.hector_height),
                (R.string.henrikh_height ), (R.string.pierre_height), (R.string.shkodran_height)};
        Drawable pics[] = {
                getResources().getDrawable(R.drawable.ozil), getResources().getDrawable(R.drawable.aaron), getResources().getDrawable(R.drawable.alexandre),
                getResources().getDrawable(R.drawable.denis),getResources().getDrawable(R.drawable.granit),getResources().getDrawable(R.drawable.hector),
                getResources().getDrawable(R.drawable.henrikh), getResources().getDrawable(R.drawable.pierre), getResources().getDrawable(R.drawable.shkodran)};

        int j=0,x=0;

        for(int i =0;i<bool.length;i++){
            if(bool[i]){
                x++;
            }
        }
        String showNames[] = new String[x];
        String showNat[] = new String[x];
        Integer showAges[] = new Integer[x];
        Integer showHeight[] = new Integer[x];
        Drawable showpics[]  = new Drawable[x];
        for(int i =0;i<bool.length;i++){
            if(bool[i]){
                showNames[j] = names[i];
                showNat[j]=nationality[i];
                showAges[j] = ages[i];
                showpics[j] = pics[i];
                showHeight[j] = height[i];
                j++;
            }
        }
        SecondAdapter adapter= new SecondAdapter(this,showNames,showNat,showAges,showHeight,showpics);
        ListView playerLists = findViewById(R.id.list2);
        playerLists.setAdapter(adapter);

        playerLists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i;
                i = new Intent(Main2Activity.this, PlayerInfo.class);
                i.putExtra("player",bool);
                i.putExtra("pos",position);
                startActivity(i);
            }
        });
    }
}