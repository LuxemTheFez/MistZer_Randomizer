package com.example.myapplication.mistzerrandomizer.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.mistzerrandomizer.R;
import com.example.myapplication.mistzerrandomizer.model.List_summoners;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Activity_result extends AppCompatActivity {

    ArrayList<String> summoner_list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        summoner_list = (ArrayList<String>) getIntent().getSerializableExtra(Activity_names.EXTRA_LIST_SUMMONER);

        Collections.shuffle(summoner_list);

        ((TextView) findViewById(R.id.textView_sum1)).setText(summoner_list.get(0));
        ((TextView) findViewById(R.id.textView_sum2)).setText(summoner_list.get(1));
        ((TextView) findViewById(R.id.textView_sum3)).setText(summoner_list.get(2));
        ((TextView) findViewById(R.id.textView_sum4)).setText(summoner_list.get(3));
        ((TextView) findViewById(R.id.textView_sum5)).setText(summoner_list.get(4));
        ((TextView) findViewById(R.id.textView_sum6)).setText(summoner_list.get(5));
        ((TextView) findViewById(R.id.textView_sum7)).setText(summoner_list.get(6));
        ((TextView) findViewById(R.id.textView_sum8)).setText(summoner_list.get(7));
        ((TextView) findViewById(R.id.textView_sum9)).setText(summoner_list.get(8));
        ((TextView) findViewById(R.id.textView_sum10)).setText(summoner_list.get(9));
    }
}
