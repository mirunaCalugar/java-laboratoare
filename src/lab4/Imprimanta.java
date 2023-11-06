package lab4;

public class Imprimanta extends Echipament{
    private Integer ppm;
    private Integer rezolutie;
    private Integer p_car;
    private ModTiparire tiparire;

    public Imprimanta(String denumire, Integer nr_inv, Float pret, String zona_magazin, Stare stare, Integer ppm, Integer rezolutie, Integer p_car, ModTiparire tiparire) {
        super(denumire, nr_inv, pret, zona_magazin, stare);
        this.ppm = ppm;
        this.rezolutie = rezolutie;
        this.p_car = p_car;
        this.tiparire = tiparire;
    }

    public Integer getPpm() {
        return ppm;
    }

    public void setPpm(Integer ppm) {
        this.ppm = ppm;
    }

    public Integer getRezolutie() {
        return rezolutie;
    }

    public void setRezolutie(Integer rezolutie) {
        this.rezolutie = rezolutie;
    }

    public Integer getP_car() {
        return p_car;
    }

    public void setP_car(Integer p_car) {
        this.p_car = p_car;
    }

    public ModTiparire getTiparire() {
        return tiparire;
    }

    public void setTiparire(ModTiparire tiparire) {
        this.tiparire = tiparire;
    }

    @Override
    public String toString() {
        return super.toString()+ "Imprimanta{" +
                "ppm=" + ppm +
                ", rezolutie=" + rezolutie +
                ", p_car=" + p_car +
                ", tiparire=" + tiparire +
                '}';
    }
}
