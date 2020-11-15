package com.example.myapplication.mistzerrandomizer.storage.utility;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract public class JsonFileStorage<T> extends FileStorage<T> {
    private final static String EXTENSION = ".json";
    private final static String DATA = "data";
    private final static String CHAMP_NAME = "champ_name";

    protected JSONObject json;

    public JsonFileStorage(Context context, String name) {
        super(context, name, EXTENSION);
    }

    protected abstract JSONObject objectToJsonObject(T object);

    protected abstract T jsonObjectToObject(JSONObject jsonObject);

    @Override
    protected void create() {
        json = new JSONObject();
        try {
            json.put(DATA, new JSONObject());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initialize(String value) {
        try {
            json = new JSONObject(value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String getValue() {
        return json.toString();
    }

    @Override
    public void insert(T object, String name) {
        try {
            json.getJSONObject(DATA).put(name, objectToJsonObject(object));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        write();
    }

    @Override
    public List<T> findAll() {
        List<T> list = new ArrayList<>();
        try {
            Iterator<String> iterator = json.getJSONObject(DATA).keys();
            while (iterator.hasNext()) {
                list.add(jsonObjectToObject(json.getJSONObject(DATA).getJSONObject(iterator.next())));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public T find(String id) {
        T object = null;
        try {
            object = jsonObjectToObject(json.getJSONObject(DATA).getJSONObject("" + id));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public int size() {
        int size = 0;
        try {
            size = json.getJSONObject(DATA).length();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return size;
    }

    @Override
    public void update(int id, T object) {
        try {
            json.getJSONObject(DATA).put("" + id, objectToJsonObject(object));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        write();
    }
}
