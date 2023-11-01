package lab1;

import java.util.Scanner;

public class ex3 {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.print("Introduceți un număr");
        int n=scanner.nextInt();
        int i;
        int nrDivizori=0;
        for(i=1;i<=n;i++)
            if(n%i==0){
                nrDivizori++;
                System.out.println(i);}
        if(nrDivizori==2)
            System.out.println("N este un nr prim");
        else
            System.out.println("N nu e prim");
    }
}
