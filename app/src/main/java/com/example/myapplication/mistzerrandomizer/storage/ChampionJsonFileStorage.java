package com.example.myapplication.mistzerrandomizer.storage;

import android.content.Context;

import com.example.myapplication.mistzerrandomizer.model.Champion;
import com.example.myapplication.mistzerrandomizer.storage.utility.JsonFileStorage;

import org.json.JSONException;
import org.json.JSONObject;



public class ChampionJsonFileStorage extends JsonFileStorage<Champion> {
    private static final String NAME = "Champion";
    private static final String CHAMPION_NAME = "name";
    private static final String CHAMPION_IMAGE = "image";
    private static final String CHAMPION_EST_CHOISI = "est_choisi";


    private static ChampionJsonFileStorage STORAGE;

    public static ChampionJsonFileStorage get(Context context) {
        if (STORAGE == null) STORAGE = new ChampionJsonFileStorage(context);
        
        return STORAGE;
    }

    private ChampionJsonFileStorage(Context context) {
        super(context, NAME);
    }

    @Override
    protected JSONObject objectToJsonObject(Champion object) {
        JSONObject json = new JSONObject();

        try {
            json.put(CHAMPION_NAME, object.getName());
            json.put(CHAMPION_IMAGE, object.getImg());
            json.put(CHAMPION_EST_CHOISI, object.isEst_choisi());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;
    }

    @Override
    protected Champion jsonObjectToObject(JSONObject jsonObject) {
        try {
            return new Champion(jsonObject.getString(CHAMPION_NAME),
                    jsonObject.getString(CHAMPION_IMAGE),
                    jsonObject.getBoolean(CHAMPION_EST_CHOISI));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
