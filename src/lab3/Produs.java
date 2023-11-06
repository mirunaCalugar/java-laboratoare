package lab3;

import java.time.LocalDate;
import java.util.Date;

public class Produs {

    private String denumire;
    private double pret;
    private int cantitate;
    private LocalDate data_expirarii;
    private static double incasari=0.0;

    public Produs(String denumire, double pret, int cantitate, LocalDate data_expirarii) {
        this.denumire = denumire;
        this.pret = pret;
        this.cantitate = cantitate;
        this.data_expirarii = data_expirarii;
    }


    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public void setData_expirarii(LocalDate data_expirarii) {
        this.data_expirarii = data_expirarii;
    }

    public static void setIncasari(double incasari) {
        Produs.incasari = incasari;
    }

    public String getDenumire() {
        return denumire;
    }

    public double getPret() {
        return pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public static double getIncasari() {
        return incasari;
    }

    public LocalDate getData_expirarii() {
        return data_expirarii;
    }
    public static void actualizareIncasari(double pretProdus,int cantitateVanduta){
        incasari+=pretProdus*cantitateVanduta;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "denumire='" + denumire + '\'' +
                ", pret=" + pret +
                ", cantitate=" + cantitate +
                ", data_expirarii=" + data_expirarii +
                '}';
    }
}
