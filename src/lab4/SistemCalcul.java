package lab4;

public class SistemCalcul extends Echipament{
    private String tip_mon;
    private double vit_proc;
    private int c_HDD;
    private SistemOperare sist_op;

    public SistemCalcul(String denumire, Integer nr_inv, Float pret, String zona_magazin, Stare stare, String tip_mon, double vit_proc, int c_HDD, SistemOperare sist_op) {
        super(denumire, nr_inv, pret, zona_magazin, stare);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_HDD = c_HDD;
        this.sist_op = sist_op;
    }

    public String getTip_mon() {
        return tip_mon;
    }

    public void setTip_mon(String tip_mon) {
        this.tip_mon = tip_mon;
    }

    public double getVit_proc() {
        return vit_proc;
    }

    public void setVit_proc(double vit_proc) {
        this.vit_proc = vit_proc;
    }

    public int getC_HDD() {
        return c_HDD;
    }

    public void setC_HDD(int c_HDD) {
        this.c_HDD = c_HDD;
    }

    public SistemOperare getSist_op() {
        return sist_op;
    }

    public void setSist_op(SistemOperare sist_op) {
        this.sist_op = sist_op;
    }

    @Override
    public String toString() {
        return super.toString()+"SistemeCalcul{" +
                "tip_mon='" + tip_mon + '\'' +
                ", vit_proc='" + vit_proc + '\'' +
                ", c_HDD='" + c_HDD + '\'' +
                ", sist_op=" + sist_op +
                '}';
    }
}
