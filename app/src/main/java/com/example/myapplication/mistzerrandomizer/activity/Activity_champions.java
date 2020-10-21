package com.example.myapplication.mistzerrandomizer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.mistzerrandomizer.R;
import com.example.myapplication.mistzerrandomizer.adapter.ChampionAdapter;
import com.example.myapplication.mistzerrandomizer.model.Champion;

import java.util.ArrayList;
import java.util.List;

public class Activity_champions extends AppCompatActivity {

    private RecyclerView list;
    private List<Champion> champions;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.champions);

        final List<Champion> champions = new ArrayList<>();
        champions.add(new Champion("Akali", true));
        champions.add(new Champion("Brand", false));

        list = (RecyclerView) findViewById(R.id.list_champions);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(new ChampionAdapter(champions) {
            @Override
            public void onItemClick(View v) {

            }
        });
    }
}
