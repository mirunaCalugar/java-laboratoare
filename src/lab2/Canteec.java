package lab2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Canteec {
    public static void main(String[] args) {
        String input="src/cantec_in.txt";
        String output="cantec_out.txt";
        List<Vers> versuri = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(input));
            String line;
            while ((line = reader.readLine()) != null) {
                versuri.add(new Vers(line));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(output));
            for (Vers vers : versuri) {
                writer.write(vers.getVers() + " (" + vers.numarCuvinte() + " cuvinte, " + vers.numarVocale() + " vocale)");
                if (vers.procesareVers()) {
                    writer.write(vers.getVers().toUpperCase());
                }
                if (vers.getVers().matches(".*[aeiouAEIOU]$")) {
                    writer.write(" *");
                }
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
