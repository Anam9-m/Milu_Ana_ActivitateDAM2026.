package com.example.seminar4;
import java.io.Serializable;

public class Magazin implements Serializable {
    private String denumire;
    private int nrAngajati;
    private float suprafata;
    private String oras;
    private String tip;
    private boolean areParcare;
    private boolean nonStop;
    private float rating;

    public Magazin(String denumire, int nrAngajati, float suprafata, String oras,
                   String tip, boolean areParcare, boolean nonStop, float rating) {
        this.denumire = denumire;
        this.nrAngajati = nrAngajati;
        this.suprafata = suprafata;
        this.oras = oras;
        this.tip = tip;
        this.areParcare = areParcare;
        this.nonStop = nonStop;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return denumire + ", " + nrAngajati + " angajati, " + suprafata + " mp, " + oras +
                ", " + tip + ", parcare: " + areParcare + ", non-stop: " + nonStop +
                ", rating: " + rating;
    }
}