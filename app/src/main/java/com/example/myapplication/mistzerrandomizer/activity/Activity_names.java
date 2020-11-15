package com.example.myapplication.mistzerrandomizer.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.mistzerrandomizer.R;

import java.util.ArrayList;
import java.util.List;

public class Activity_names extends AppCompatActivity {

    public final static String EXTRA_LIST_SUMMONER = "EXTRA_LIST_SUMMONER";

    public boolean sum_Valid(String s){
        return (!s.isEmpty() && s.length()<=16);
    }

    public List<String> summoner_list;

    ProgressBar simpleProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names);

        final EditText edit_1 = (EditText) findViewById(R.id.text_name1);
        final TextView nom = (TextView) findViewById(R.id.name1);

        final ArrayList<String> summoner_list = new ArrayList<String>();

        simpleProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        simpleProgressBar.setProgress(0);

        nom.setText("Invocateur " + (summoner_list.size()+1));
        edit_1.setHint("Invocateur " + (summoner_list.size()+1));

        final Button button_continue = findViewById(R.id.button_names);
        button_continue.setEnabled(false);
        button_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent Activity_result_intent = new Intent(getApplicationContext(), Activity_result.class);
                Activity_result_intent.putExtra(EXTRA_LIST_SUMMONER, summoner_list);
                startActivity(Activity_result_intent);
            }

        });

        final Button button_nom = findViewById(R.id.button_nom);
        button_nom.setText("Suivant");
        button_nom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("avant : " +summoner_list.size());
                String sum = edit_1.getText().toString();
                if (sum_Valid(sum)){
                    summoner_list.add(sum);
                    nom.setText("Invocateur " + (summoner_list.size()+1));
                    edit_1.setHint("Invocateur " + (summoner_list.size()+1));

                    System.out.println(summoner_list.size());
                    edit_1.getText().clear();
                    simpleProgressBar.incrementProgressBy(10);
                    if (summoner_list.size()==10) {
                        closeKeyboard();
                        edit_1.setVisibility(View.GONE);
                        button_nom.setVisibility(View.GONE);
                        nom.setText("Cliquer sur continuer pour continuer");
                        button_continue.setEnabled(true);
                    }
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Pseudo non valide", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });





    }

    private void closeKeyboard(){
        View view = this.getCurrentFocus();
        if (view != null){
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
