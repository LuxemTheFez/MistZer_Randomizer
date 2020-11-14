package com.example.myapplication.mistzerrandomizer.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.mistzerrandomizer.R;
import com.example.myapplication.mistzerrandomizer.adapter.ChampionAdapter;
import com.example.myapplication.mistzerrandomizer.model.Champion;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Activity_champions extends AppCompatActivity {

    private RecyclerView list;
    private List<Champion> champions;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champions);

        final List<Champion> champions = new ArrayList<>();

        list = (RecyclerView) findViewById(R.id.list_champions);
        list.setLayoutManager(new GridLayoutManager(this, 3));
        list.setAdapter(new ChampionAdapter(getApplicationContext()) {
            @Override
            public void onItemClick(View v) {

            }
        });
    }
    private String loadJSON() {
        String json = null;
        try {
            InputStream is = getResources().openRawResource(R.raw.champion_test);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }catch (IOException e){
            e.printStackTrace();
        }
        return json;
    }
}
