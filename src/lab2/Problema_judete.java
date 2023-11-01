package lab2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Problema_judete {
    public static void main(String[] args) throws FileNotFoundException {
        String input = "src/judete_in.txt";
        String[] judete = null; // Declarare array de județe

        try {
            BufferedReader reader = new BufferedReader(new FileReader(input));

            String line;
            int i =0;
            int numberOfLines = 0;
            // Determină numărul de linii (județe) din fișier
            while (reader.readLine() != null) {
                numberOfLines++;
            }

            // Reinițializează reader pentru a începe de la începutul fișierului
            reader.close();
            reader = new BufferedReader(new FileReader(input));

            judete = new String[numberOfLines]; // Inițializare array de județe

            while ((line = reader.readLine()) != null) {
                judete[i] = line;
                i++;
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (judete == null) {
            System.out.println("Nu s-au putut citi datele din fisier");
            return;
        }

        Arrays.sort(judete);
        System.out.println("Județele ordonate alfabetic:");
        for (String judet : judete) {
            System.out.println(judet);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti judetul cautat ");
        String judetCautat = scanner.nextLine();
        int pozitia = Arrays.binarySearch(judete, judetCautat);

        if (pozitia >= 0) {
            System.out.println("Județul " + judetCautat + " se află pe poziția " + (pozitia + 1) + " în vectorul ordonat.");
        } else {
            System.out.println("Județul " + judetCautat + " nu a fost găsit în lista de județe.");
        }
    }

}
