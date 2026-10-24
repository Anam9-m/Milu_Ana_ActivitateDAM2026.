package com.example.milu_ana_activitatedam2026;

import java.io.Serializable;

public class Magazin implements Serializable {
    private String denumire;
    private int suprafata;
    private boolean nonStop;
    private String tip;
    private String oras;
    private float rating;
    private boolean areParcare;

    public Magazin(String denumire, int suprafata, boolean nonStop,
                   String tip, String oras, float rating, boolean areParcare) {
        this.denumire = denumire;
        this.suprafata = suprafata;
        this.nonStop = nonStop;
        this.tip = tip;
        this.oras = oras;
        this.rating = rating;
        this.areParcare = areParcare;
    }

    public String getDenumire() { return denumire; }
    public void setDenumire(String denumire) { this.denumire = denumire; }
    public int getSuprafata() { return suprafata; }
    public void setSuprafata(int suprafata) { this.suprafata = suprafata; }
    public boolean isNonStop() { return nonStop; }
    public void setNonStop(boolean nonStop) { this.nonStop = nonStop; }
    public String getTip() { return tip; }
    public void setTip(String tip) { this.tip = tip; }
    public String getOras() { return oras; }
    public void setOras(String oras) { this.oras = oras; }
    public float getRating() { return rating; }
    public void setRating(float rating) { this.rating = rating; }
    public boolean isAreParcare() { return areParcare; }
    public void setAreParcare(boolean areParcare) { this.areParcare = areParcare; }

    @Override
    public String toString() {
        return "Magazin: " + denumire + ", " + suprafata + " mp, non-stop: " + nonStop +
                ", tip: " + tip + ", oraș: " + oras + ", rating: " + rating +
                ", parcare: " + areParcare;
    }
}
