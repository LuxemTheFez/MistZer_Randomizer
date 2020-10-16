package com.example.myapplication.mistzerrandomizer.model;

import java.io.Serializable;
import java.util.ArrayList;

public class List_summoners implements Serializable {
    private ArrayList<String> list;

    public List_summoners() {
        list = new ArrayList<String>();
    }

    public ArrayList<String> getList(){
        return list;
    }
    public void add(String s){
        list.add(s);
    }
}
