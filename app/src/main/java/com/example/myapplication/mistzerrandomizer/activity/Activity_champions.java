package com.example.myapplication.mistzerrandomizer.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.mistzerrandomizer.R;
import com.example.myapplication.mistzerrandomizer.adapter.ChampionAdapter;
import com.example.myapplication.mistzerrandomizer.dialog.Updatable;
import com.example.myapplication.mistzerrandomizer.model.Champion;
import com.example.myapplication.mistzerrandomizer.storage.ChampionJsonFileStorage;

import java.util.List;

public class Activity_champions extends AppCompatActivity implements Updatable {

    private RecyclerView list;
    private List<Champion> champions;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champions);

        champions = ChampionJsonFileStorage.get(getApplicationContext()).findAll();;

        list = (RecyclerView) findViewById(R.id.list_champions);
        list.setLayoutManager(new GridLayoutManager(this, 3));
        list.setAdapter(new ChampionAdapter(getApplicationContext()) {
            @Override
            public void onItemClick(View v) {
                Champion champion = champions.get(list.getChildViewHolder(v).getAdapterPosition());
                champion.toggle_Est_choisi();
                ChampionJsonFileStorage.get(getApplicationContext()).insert(champion, (String) v.getTag());
                ((ChampionAdapter) list.getAdapter()).setChampions();
                list.getAdapter().notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    public void update() {
        list.getAdapter().notifyDataSetChanged();
        onResume();
    }
}
