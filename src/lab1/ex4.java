package lab1;

import java.util.Random;

public class ex4 {
    public static void main(String[] args) {
        Random random=new Random();//creaza un obiect de tip random
        int numar1=random.nextInt(31);//genereaza un nr random intre 0 si 30
        int numar2=random.nextInt(31);
        int cmmdc=CMMDC(numar1,numar2);
        System.out.println("Numărul 1: " + numar1);
        System.out.println("Numărul 2: " + numar2);
        System.out.println("CMMD al numerelor este: " + cmmdc);

    }
    public static int CMMDC(int nr1,int nr2){
        while(nr2!=0){
            int aux=nr2;
            nr2=nr1%nr2;
            nr1=aux;
        }
        return nr1;

    }
}
