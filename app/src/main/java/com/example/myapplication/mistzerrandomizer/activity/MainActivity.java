package com.example.myapplication.mistzerrandomizer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.mistzerrandomizer.R;
import com.example.myapplication.mistzerrandomizer.model.Champion;
import com.example.myapplication.mistzerrandomizer.storage.ChampionJsonFileStorage;
import com.example.myapplication.mistzerrandomizer.storage.utility.JsonFileStorage;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Champion> champions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        champions = ChampionJsonFileStorage.get(getApplicationContext()).findAll();
        System.out.println("champions : " + champions);

        creationJson();

        final Button start_button = findViewById(R.id.start_button);
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Activity_names_Intent = new Intent(getApplicationContext(), Activity_names.class);
                startActivity(Activity_names_Intent);
            }
        });

        Button about_button = findViewById(R.id.about_button);
        about_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Activity_a_propos_Intent = new Intent(getApplicationContext(), Activity_a_propos.class);
                startActivity(Activity_a_propos_Intent);
            }
        });

        Button option_button = findViewById(R.id.options_button);
        option_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Activity_options = new Intent(getApplicationContext(), Activity_champions.class);
                startActivity(Activity_options);
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    private void creationJson() {
        try {
            JSONObject obj = new JSONObject(loadJSON());
            JSONObject data = obj.getJSONObject("data");
            System.out.println("Data : " + data);

            for (Iterator<String> iter = data.keys(); iter.hasNext(); ) {
                String key = iter.next();
                try {
                    JSONObject champ_data = (JSONObject) data.get(key);
                    //System.out.println("Champ data : " + champ_data);
                    Champion champion = new Champion(champ_data.getString("name"), champ_data.getString("id"),champ_data.getBoolean("estChoisi"));
                    ChampionJsonFileStorage.get(getApplicationContext()).insert(champion, champion.getImg());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}