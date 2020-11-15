package com.example.myapplication.mistzerrandomizer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.mistzerrandomizer.R;
import com.example.myapplication.mistzerrandomizer.model.Champion;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Activity_result extends AppCompatActivity {

    ArrayList<String> summoner_list;
    private List<Champion> champions;
    private Random random = new Random();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        Button menu_button = findViewById(R.id.button_menu);
        menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Activity_names_Intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(Activity_names_Intent);
            }
        });

        Button restart_button = findViewById(R.id.button_restart);
        restart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resultat();
            }
        });

        resultat();

    }

    private void resultat() {
        final List<Champion> champions = new ArrayList<>();
        try {
            JSONObject obj = new JSONObject(loadJSON());
            JSONObject data = obj.getJSONObject("data");

            for (Iterator<String> iter = data.keys(); iter.hasNext();){
                String key = iter.next();
                try {
                    JSONObject champ_data = (JSONObject) data.get(key);
                    if (champ_data.getBoolean("estChoisi")){
                        champions.add(new Champion(champ_data.getString("name"), champ_data.getString("image"), champ_data.getBoolean("estChoisi")));
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }

            }



        }catch (JSONException e){
            e.printStackTrace();
        }
        System.out.println(champions);
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

        //final Context context = getApplicationContext();
        final int duration = Toast.LENGTH_SHORT;

        ImageView i1 = ((ImageView) findViewById(R.id.img_sum_1));
        final Champion c1 = champions.get(random.nextInt(champions.size()));
        champions.remove(c1);
        i1.setImageResource(getResources().getIdentifier(c1.getImg(), "drawable", getPackageName()));
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), c1.getName(), duration);
                toast.show();
            }
        });
        final Champion c2 = champions.get(random.nextInt(champions.size()));
        champions.remove(c2);
        ImageView i2 = ((ImageView) findViewById(R.id.img_sum_2));
        i2.setImageResource(getResources().getIdentifier(c2.getImg(), "drawable", getPackageName()));
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), c2.getName(), duration);
                toast.show();
            }
        });
        final Champion c3 = champions.get(random.nextInt(champions.size()));
        champions.remove(c3);
        ImageView i3 = ((ImageView) findViewById(R.id.img_sum_3));
        i3.setImageResource(getResources().getIdentifier(c3.getImg(), "drawable", getPackageName()));
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),  c3.getName(), duration);
                toast.show();
            }
        });
        final Champion c4 = champions.get(random.nextInt(champions.size()));
        champions.remove(c4);
        ImageView i4 = ((ImageView) findViewById(R.id.img_sum_4));
        i4.setImageResource(getResources().getIdentifier(c4.getImg(), "drawable", getPackageName()));
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),  c4.getName(), duration);
                toast.show();
            }
        });
        final Champion c5 = champions.get(random.nextInt(champions.size()));
        champions.remove(c5);
        ImageView i5 = ((ImageView) findViewById(R.id.img_sum_5));
        i5.setImageResource(getResources().getIdentifier(c5.getImg(), "drawable", getPackageName()));
        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),  c5.getName(), duration);
                toast.show();
            }
        });
        final Champion c6 = champions.get(random.nextInt(champions.size()));
        champions.remove(c6);
        ImageView i6 = ((ImageView) findViewById(R.id.img_sum_6));
        i6.setImageResource(getResources().getIdentifier(c6.getImg(), "drawable", getPackageName()));
        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),  c6.getName(), duration);
                toast.show();
            }
        });
        final Champion c7 = champions.get(random.nextInt(champions.size()));
        champions.remove(c7);
        ImageView i7 = ((ImageView) findViewById(R.id.img_sum_7));
        i7.setImageResource(getResources().getIdentifier(c7.getImg(), "drawable", getPackageName()));
        i7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),  c7.getName(), duration);
                toast.show();
            }
        });
        final Champion c8 = champions.get(random.nextInt(champions.size()));
        champions.remove(c8);
        ImageView i8 = ((ImageView) findViewById(R.id.img_sum_8));
        i8.setImageResource(getResources().getIdentifier(c8.getImg(), "drawable", getPackageName()));
        i8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),  c8.getName(), duration);
                toast.show();
            }
        });
        final Champion c9 = champions.get(random.nextInt(champions.size()));
        champions.remove(c9);
        ImageView i9 = ((ImageView) findViewById(R.id.img_sum_9));
        i9.setImageResource(getResources().getIdentifier(c9.getImg(), "drawable", getPackageName()));
        i9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),  c9.getName(), duration);
                toast.show();
            }
        });
        final Champion c10 = champions.get(random.nextInt(champions.size()));
        champions.remove(c10);
        ImageView i10 = ((ImageView) findViewById(R.id.img_sum_10));
        i10.setImageResource(getResources().getIdentifier(c10.getImg(), "drawable", getPackageName()));
        i10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),  c10.getName(), duration);
                toast.show();
            }
        });
        System.out.println(champions);
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
