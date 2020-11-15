package com.example.myapplication.mistzerrandomizer.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.mistzerrandomizer.R;
import com.example.myapplication.mistzerrandomizer.model.Champion;
import com.example.myapplication.mistzerrandomizer.storage.ChampionJsonFileStorage;

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
    }

    public void setChampions(){
        champions = ChampionJsonFileStorage.get(context.getApplicationContext()).findAll();
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
        Drawable d = context.getDrawable(context.getResources().getIdentifier(champion.getImg(), "drawable", context.getPackageName()));

        if (!champion.isEst_choisi()){
            ColorMatrix matrix = new ColorMatrix();
            matrix.setSaturation(0);
            ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);

            d.setColorFilter(filter);
       } else {
            ColorMatrix matrix = new ColorMatrix();
            matrix.setSaturation(1);
            ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);

            d.setColorFilter(filter);
        }
        holder.img.setImageDrawable(d);
        holder.itemView.setTag(champion.getImg());

    }

    @Override
    public int getItemCount() {
        return champions.size();
    }

    public abstract void onItemClick(View v);
}
