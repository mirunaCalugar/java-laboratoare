package lab3;

public class Parabola {
    private int a,b,c;
    public Punct varf;

    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        varf=new Punct((-b/(2*a)), (-b*b+4*a*c)/(4*a));
    }
    @Override
    public String toString() {
        return "f(x)= " + a+"x^2 + "+b+"x + "+c;
    }
    public Punct Mijloc(Parabola par) {
        return varf.Mijloc(par.varf);
    }

    public Punct Mijloc(Parabola par1, Parabola par2) {
        return par1.varf.Mijloc(par2.varf);
    }

    public double Lungime(Parabola par) {
        return varf.Distanta(par.varf);
    }

    public double Lungime(Parabola par1, Parabola par2) {
        return par1.varf.Distanta(par2.varf);
    }


}
