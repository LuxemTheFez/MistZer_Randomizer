package com.example.myapplication.mistzerrandomizer.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.mistzerrandomizer.R;
import com.example.myapplication.mistzerrandomizer.model.List_summoners;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Activity_result extends AppCompatActivity {

    ArrayList<String> summoner_list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

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
        i1.setImageResource(R.drawable.masteryi);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Maitre yi", duration);
                toast.show();
            }
        });
        ImageView i2 = ((ImageView) findViewById(R.id.img_sum_2));
        i2.setImageResource(R.drawable.masteryi);
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Maitre yi", duration);
                toast.show();
            }
        });
        ImageView i3 = ((ImageView) findViewById(R.id.img_sum_3));
        i3.setImageResource(R.drawable.masteryi);
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Maitre yi", duration);
                toast.show();
            }
        });
        ImageView i4 = ((ImageView) findViewById(R.id.img_sum_4));
        i4.setImageResource(R.drawable.masteryi);
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Maitre yi", duration);
                toast.show();
            }
        });
        ImageView i5 = ((ImageView) findViewById(R.id.img_sum_5));
        i5.setImageResource(R.drawable.masteryi);
        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Maitre yi", duration);
                toast.show();
            }
        });
        ImageView i6 = ((ImageView) findViewById(R.id.img_sum_6));
        i6.setImageResource(R.drawable.masteryi);
        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Maitre yi", duration);
                toast.show();
            }
        });
        ImageView i7 = ((ImageView) findViewById(R.id.img_sum_7));
        i7.setImageResource(R.drawable.masteryi);
        i7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Maitre yi", duration);
                toast.show();
            }
        });
        ImageView i8 = ((ImageView) findViewById(R.id.img_sum_8));
        i8.setImageResource(R.drawable.masteryi);
        i8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Maitre yi", duration);
                toast.show();
            }
        });
        ImageView i9 = ((ImageView) findViewById(R.id.img_sum_9));
        i9.setImageResource(R.drawable.masteryi);
        i9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Maitre yi", duration);
                toast.show();
            }
        });
        ImageView i10 = ((ImageView) findViewById(R.id.img_sum_10));
        i10.setImageResource(R.drawable.masteryi);
        i10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Maitre yi", duration);
                toast.show();
            }
        });


    }
}
