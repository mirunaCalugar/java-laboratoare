package lab1;

import java.util.Random;

public class ex5 {
    public static void main(String[] args) {
        Random random=new Random();
        int numar= random.nextInt(20);
        if(isFibo(numar))
            System.out.println("Numarul "+numar+" apartine sirului lui Fibonacci");
        else
            System.out.println("Numarul "+numar+" nu apartine sirului lui Fibonacci");
    }
    public static boolean isFibo(int n){
        int a=0;
        int b=1;
        while(b<n){
            int urmatorul=a+b;
            a=b;
            b=urmatorul;
        }
        return b==n;
    }
}
