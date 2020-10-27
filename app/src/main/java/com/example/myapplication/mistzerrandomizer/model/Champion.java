package com.example.myapplication.mistzerrandomizer.model;

public class Champion {
    protected String name;
    protected boolean est_choisi;

    public Champion(String name, boolean est_choisi) {
        this.name = name.toLowerCase();
        this.est_choisi = est_choisi;
    }

    public String getName() {
        return name;
    }
    public boolean isEst_choisi() {
        return est_choisi;
    }

    public String toString() { return name+" "+est_choisi; }
}
