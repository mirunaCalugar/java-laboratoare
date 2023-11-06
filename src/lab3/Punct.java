package lab3;

public class Punct {
    private int x;
    private int y;

    public Punct(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public double Distanta(Punct p) {
        return Math.hypot((x-p.x)*(x-p.x), (y-p.y)*(y-p.y));
    }

    public Punct Mijloc(Punct p) {
        Punct a=new Punct((x+p.x)/2, (y+p.y)/2);
        return a;
    }

}
