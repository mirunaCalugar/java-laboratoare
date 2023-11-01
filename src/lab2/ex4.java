package lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) {
        List<Persoana> persoane = new ArrayList<>();

        try {
            File file = new File("C:\\lucru_java\\LAAB1\\src\\lab2\\persoane.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");

                if (parts.length == 2) {
                    String nume = parts[0];
                    String cnp = parts[1];

                    if (isValidCNP(cnp)) {
                        Persoana persoana = new Persoana(nume, cnp);
                        persoane.add(persoana);
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        for (Persoana persoana : persoane) {
            int varsta = persoana.getVarsta();
            if (varsta != -1) {
                System.out.println(persoana.getNume() + ", " + persoana.getCNP() + ", Vârsta: " + varsta + " ani");
            } else {
                System.out.println(persoana.getNume() + ", " + persoana.getCNP() + ", CNP invalid");
            }
        }
    }

    private static boolean isValidCNP(String cnp) {
        if (cnp.length() != 13) {
            return false;
        }

        for (char digit : cnp.toCharArray()) {
            if (!Character.isDigit(digit)) {
                return false;
            }
        }

        char firstDigit = cnp.charAt(0);
        if (firstDigit != '1' && firstDigit != '2' && firstDigit != '5' && firstDigit != '6') {
            return false;
        }

        int[] weights = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
        int controlDigit = Integer.parseInt(cnp.substring(12, 13));

        int sum = 0;
        for (int i = 0; i < 12; i++) {
            int digit = Integer.parseInt(cnp.substring(i, i + 1));
            sum += digit * weights[i];
        }

        int remainder = sum % 11;
        int computedControlDigit;
        if (remainder == 10) {
            computedControlDigit = 1;
        } else {
            computedControlDigit = remainder;
        }

        return computedControlDigit == controlDigit;
    }

}
