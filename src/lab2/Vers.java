package lab2;

import java.util.Random;

public class Vers {
    private String vers;

    public Vers(String vers) {
        this.vers = vers;
    }

    public String getVers() {
        return vers;
    }

    public int numarCuvinte(){
    String[] cuvinte= vers.split("\\s+");
        return cuvinte.length;
    }
    public int numarVocale(){
        int numVocale = 0;
        for (char c : vers.toCharArray()) {
            if ("AEIOUaeiou".indexOf(c) != -1) {
                numVocale++;
            }
        }
        return numVocale;

    };
    public boolean procesareVers(){
        Random rand = new Random();
        double probabilitate = rand.nextDouble();
        return probabilitate < 0.1;

    };
}
