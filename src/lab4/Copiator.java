package lab4;

public class Copiator extends Echipament{
    private int p_ton;
    private FormatCopiere format;

    public Copiator(String denumire, Integer nr_inv, double pret, String zona_magazin, Stare stare, int p_ton, FormatCopiere format) {
        super(denumire, nr_inv, pret, zona_magazin, stare);
        this.p_ton = p_ton;
        this.format = format;
    }

    public int getP_ton() {
        return p_ton;
    }

    public void setP_ton(int p_ton) {
        this.p_ton = p_ton;
    }

    public FormatCopiere getFormat() {
        return format;
    }

    public void setFormat(FormatCopiere format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return super.toString()+ "Copiator{" +
                "p_ton='" + p_ton + '\'' +
                ", format=" + format +
                '}';
    }
}
