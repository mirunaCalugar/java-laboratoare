package lab1;

import java.io.*;

public class ex2 {
    public static void main(String[] args) throws IOException {
        System.out.println("Succes");
        String input = "src/in.txt";
        String output = "src/out.txt";
        try {

            BufferedReader reader = new BufferedReader(new FileReader(input));
            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter(output));
            String line;
            double sum = 0;
            double min = Double.MAX_VALUE;
            double max = -Double.MIN_VALUE;
            double medieAritmetica = 0;
            int nr = 0;//numar termenii
            while ((line = reader.readLine()) != null) {
                double number = Double.parseDouble(line);
                sum = sum + number;
                min = Math.min(min, number);
                max = Math.max(max, number);
                nr++;


            }
            if (nr > 0) {
                medieAritmetica = sum / nr;
                System.out.println("Suma" + sum);
                System.out.println("Media aritmetica" + medieAritmetica);
                System.out.println("minim " + min);
                System.out.println("maxim " + max);
                writer.write("Sum: " + sum + "\n");
                writer.write("Medie aritmetica: " + medieAritmetica + "\n");
                writer.write("Min: " + min + "\n");
                writer.write("Max: " + max + "\n");
            } else {
                System.out.println("No numbers in the input file.");
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }}

