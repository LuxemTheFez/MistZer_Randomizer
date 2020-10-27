package com.example.myapplication.mistzerrandomizer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.mistzerrandomizer.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> champion = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button start_button = findViewById(R.id.start_button);
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

        Button option_button = findViewById(R.id.options_button);
        option_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Activity_options = new Intent(getApplicationContext(), Activity_champions.class);
                startActivity(Activity_options);
            }
        });
    }


}