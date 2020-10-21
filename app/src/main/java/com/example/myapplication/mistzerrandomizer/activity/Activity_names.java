package com.example.myapplication.mistzerrandomizer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.mistzerrandomizer.R;

import java.util.ArrayList;

public class Activity_names extends AppCompatActivity {

    public final static String EXTRA_LIST_SUMMONER = "EXTRA_LIST_SUMMONER";

    public boolean sum_Valid(String s){
        return (!s.isEmpty() && s.length()<=16);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names);

        Button button_continue = findViewById(R.id.button_names);
        button_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText edit_1 = (EditText) findViewById(R.id.text_name1);
                EditText edit_2 = (EditText) findViewById(R.id.text_name2);
                EditText edit_3 = (EditText) findViewById(R.id.text_name3);
                EditText edit_4 = (EditText) findViewById(R.id.text_name4);
                EditText edit_5 = (EditText) findViewById(R.id.text_name5);
                EditText edit_6 = (EditText) findViewById(R.id.text_name6);
                EditText edit_7 = (EditText) findViewById(R.id.text_name7);
                EditText edit_8 = (EditText) findViewById(R.id.text_name8);
                EditText edit_9 = (EditText) findViewById(R.id.text_name9);
                EditText edit_10 = (EditText) findViewById(R.id.text_name10);

                ArrayList<String> summoner_list = new ArrayList<String>();

                String summoner_1 = edit_1.getText().toString();
                String summoner_2 = edit_2.getText().toString();
                String summoner_3 = edit_3.getText().toString();
                String summoner_4 = edit_4.getText().toString();
                String summoner_5 = edit_5.getText().toString();
                String summoner_6 = edit_6.getText().toString();
                String summoner_7 = edit_7.getText().toString();
                String summoner_8 = edit_8.getText().toString();
                String summoner_9 = edit_9.getText().toString();
                String summoner_10 = edit_10.getText().toString();

                summoner_list.add(summoner_1);
                summoner_list.add(summoner_2);
                summoner_list.add(summoner_3);
                summoner_list.add(summoner_4);
                summoner_list.add(summoner_5);
                summoner_list.add(summoner_6);
                summoner_list.add(summoner_7);
                summoner_list.add(summoner_8);
                summoner_list.add(summoner_9);
                summoner_list.add(summoner_10);

                if (sum_Valid(summoner_1) && sum_Valid(summoner_2) &&
                        sum_Valid(summoner_3) && sum_Valid(summoner_4) &&
                        sum_Valid(summoner_5) && sum_Valid(summoner_6) &&
                        sum_Valid(summoner_7) && sum_Valid(summoner_8) &&
                        sum_Valid(summoner_9) && sum_Valid(summoner_10)) {
                    Intent Activity_result_intent = new Intent(getApplicationContext(), Activity_result.class);
                    Activity_result_intent.putExtra(EXTRA_LIST_SUMMONER, summoner_list);
                    startActivity(Activity_result_intent);
                }
            }
        });

    }
}
