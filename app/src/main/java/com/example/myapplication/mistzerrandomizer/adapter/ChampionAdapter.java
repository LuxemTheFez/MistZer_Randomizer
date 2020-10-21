package com.example.myapplication.mistzerrandomizer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.mistzerrandomizer.R;
import com.example.myapplication.mistzerrandomizer.model.Champion;

import java.util.List;


public abstract class ChampionAdapter extends RecyclerView.Adapter<ChampionAdapter.ChampionHolder> {
    private List<Champion> champions;

    public ChampionAdapter(List<Champion> champions) {
        this.champions = champions;
    }

    class ChampionHolder extends RecyclerView.ViewHolder {

        public ImageView img;

        public ChampionHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_champion);
        }
    }

    @NonNull
    @Override
    public ChampionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_champion, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick(v);
            }
        });
        return new ChampionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChampionAdapter.ChampionHolder holder, int position) {
        holder.img.setImageResource(R.drawable.akali);
        System.out.println("teeeeeeeeeeeeeeeest");
    }

    @Override
    public int getItemCount() {
        return champions.size();
    }

    public abstract void onItemClick(View v);
}
