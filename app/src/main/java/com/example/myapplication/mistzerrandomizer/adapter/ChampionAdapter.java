package com.example.myapplication.mistzerrandomizer.adapter;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.mistzerrandomizer.R;
import com.example.myapplication.mistzerrandomizer.model.Champion;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
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
        champions = new ArrayList<>();
        try {
            JSONObject obj = new JSONObject(loadJSON());
            JSONObject data = obj.getJSONObject("data");

            for (Iterator<String> iter = data.keys(); iter.hasNext();){
                String key = iter.next();
                try {
                    JSONObject champ_data = (JSONObject) data.get(key);
                    champions.add(new Champion(champ_data.getString("id"), champ_data.getBoolean("estChoisi")));

                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        }catch (JSONException e){
            e.printStackTrace();
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
        System.out.println(champions);

        Champion champion = champions.get(position);
        holder.img.setImageResource(context.getResources().getIdentifier(champion.getName(), "drawable", context.getPackageName()));
        holder.itemView.setTag(champion.getName());
        if (!champion.isEst_choisi()){
            setLocked(holder.img);
        }

    }

    @Override
    public int getItemCount() {
        return champions.size();
    }

    public abstract void onItemClick(View v);

    private String loadJSON() {
        String json = null;
        try {
            InputStream is = context.getResources().openRawResource(R.raw.champion_test);
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

    public static void  setLocked(ImageView v)
    {
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);  //0 means grayscale
        ColorMatrixColorFilter cf = new ColorMatrixColorFilter(matrix);
        v.setColorFilter(cf);
        v.setImageAlpha(128);   // 128 = 0.5
    }
}
