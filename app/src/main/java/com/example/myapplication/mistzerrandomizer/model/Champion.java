package com.example.myapplication.mistzerrandomizer.model;

public class Champion {
    protected String name;
    protected boolean est_choisi;
    protected String img;

    public Champion(String name, String img, boolean est_choisi) {
        this.name = name;
        this.img = img.toLowerCase();
        this.est_choisi = est_choisi;
    }

    public String getName() {
        return name;
    }
    public String getImg() { return img; }
    public boolean isEst_choisi() {
        return est_choisi;
    }

    public String toString() { return name+" "+est_choisi; }
}
