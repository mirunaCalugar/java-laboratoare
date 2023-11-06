package lab3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Parabola>parabole=new ArrayList<Parabola>();
        String input="src/input";
        try(BufferedReader reader=new BufferedReader(new FileReader(input))){
            String linie;
            while ((linie= reader.readLine())!=null) {
                String[] parts=linie.split(" ");

                int int1=Integer.parseInt(parts[0]);
                int int2=Integer.parseInt(parts[1]);
                int int3=Integer.parseInt(parts[2]);
                parabole.add(new Parabola(int1, int2, int3));

            }
        }catch( IOException e){
            e.printStackTrace();

        }
        for(Parabola p:parabole) {
            System.out.println(p.toString());
            System.out.println(p.Mijloc(parabole.get(1)).toString());
        }




    }
}
