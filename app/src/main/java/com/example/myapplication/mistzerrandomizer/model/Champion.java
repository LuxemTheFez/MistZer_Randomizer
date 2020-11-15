package com.example.myapplication.mistzerrandomizer.model;

import java.io.Serializable;

public class Champion implements Serializable {
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
    public void toggle_Est_choisi(){
        if (est_choisi == true){
            est_choisi = false;
        } else {
            est_choisi = true;
        }
    }

    public String toString() { return name+" "+est_choisi; }
}
