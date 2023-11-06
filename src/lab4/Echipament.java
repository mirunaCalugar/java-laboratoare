package lab4;

import java.io.Serializable;

public class Echipament implements Serializable {
    private String denumire;
    private Integer nr_inv;
    private double pret;
    private String zona_magazin;
    private Stare stare;

    public Echipament(String denumire, Integer nr_inv, double pret, String zona_magazin, Stare stare) {
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_magazin = zona_magazin;
        this.stare = stare;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public Integer getNr_inv() {
        return nr_inv;
    }

    public void setNr_inv(Integer nr_inv) {
        this.nr_inv = nr_inv;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public String getZona_magazin() {
        return zona_magazin;
    }

    public void setZona_magazin(String zona_magazin) {
        this.zona_magazin = zona_magazin;
    }

    public Stare getStare() {
        return stare;
    }

    public void setStare(Stare stare) {
        this.stare = stare;
    }

    @Override
    public String toString() {
        return "Echipament{" +
                "denumire='" + denumire + '\'' +
                ", nr_inv=" + nr_inv +
                ", pret=" + pret +
                ", zona_magazin='" + zona_magazin + '\'' +
                ", stare=" + stare +
                '}';
    }
}
