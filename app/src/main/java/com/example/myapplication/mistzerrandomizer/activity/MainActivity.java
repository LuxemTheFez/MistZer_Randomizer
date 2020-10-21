package com.example.myapplication.mistzerrandomizer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.mistzerrandomizer.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> champion = new ArrayList<>();
    Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            JSONObject obj = new JSONObject(loadJSON());
            JSONObject data = obj.getJSONObject("data");

            for (Iterator<String> iter  = data.keys(); iter.hasNext();){
                String key = iter.next();
                try {
                    JSONObject test = (JSONObject) data.get(key);
                    String test_string=test.getString("id");
                    //System.out.println(test_string);
                    champion.add(test_string);
                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
            System.out.println(champion.get(random.nextInt(champion.size())));


        }catch (JSONException e){
            e.printStackTrace();
        }

        Button start_button = findViewById(R.id.start_button);
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //System.out.println("hehehehe");

                Intent Activity_names_Intent = new Intent(getApplicationContext(), Activity_names.class);
                startActivity(Activity_names_Intent);
            }
        });

        Button about_button = findViewById(R.id.about_button);
        about_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Activity_a_propos_Intent= new Intent(getApplicationContext(), Activity_a_propos.class);
                startActivity(Activity_a_propos_Intent);
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