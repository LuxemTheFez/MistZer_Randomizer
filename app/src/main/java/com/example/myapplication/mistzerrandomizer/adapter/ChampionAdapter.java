package com.example.myapplication.mistzerrandomizer.adapter;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.mistzerrandomizer.R;
import com.example.myapplication.mistzerrandomizer.model.Champion;
import com.example.myapplication.mistzerrandomizer.storage.ChampionJsonFileStorage;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public abstract class ChampionAdapter extends RecyclerView.Adapter<ChampionAdapter.ChampionHolder> {

    private List<Champion> champions;

    static class ChampionHolder extends RecyclerView.ViewHolder {

        public ImageView img;

        public ChampionHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_champion);
        }
    }

    private final Context context;

    public ChampionAdapter(Context context) {
        this.context = context;
        champions = ChampionJsonFileStorage.get(context.getApplicationContext()).findAll();
        System.out.println(champions);
    }

    public void setChampions(){
        champions = ChampionJsonFileStorage.get(context.getApplicationContext()).findAll();
    }

    public void setChamp(ChampionAdapter.ChampionHolder holder, int position, boolean estChoisi){
        setLocked(holder.img);
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
        Champion champion = champions.get(position);
        holder.img.setImageResource(context.getResources().getIdentifier(champion.getImg(), "drawable", context.getPackageName()));
        holder.itemView.setTag(champion.getImg());
        if (!champion.isEst_choisi()){
            System.out.println(champion);
            setLocked(holder.img);
        }

    }

    @Override
    public int getItemCount() {
        return champions.size();
    }

    public abstract void onItemClick(View v);

    public static void  setLocked(ImageView v)
    {
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);  //0 means grayscale
        ColorMatrixColorFilter cf = new ColorMatrixColorFilter(matrix);
        v.setColorFilter(cf);
        v.setImageAlpha(128);   // 128 = 0.5
    }

}
