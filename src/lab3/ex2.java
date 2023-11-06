package lab3;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) throws IOException, ParseException {

        List<Produs>produse=new ArrayList<>();
        String fisier="src/produse.csv";

        try(  BufferedReader reader=new BufferedReader(new FileReader(fisier))) {
            String linie;
            while((linie= reader.readLine())!=null){
                String[] parti=linie.split(",");//imi despart fiecare linie din fisier in componenete separate
                 if(parti.length==4){
                     String denumire=parti[0].trim();
                     double pret=Double.parseDouble(parti[1].trim());
                     int cantitae=Integer.parseInt(parti[2].trim());
                     LocalDate data_expirarii=LocalDate.parse(parti[3].trim());
                     produse.add(new Produs(denumire,pret,cantitae,data_expirarii));
                 }
            }} catch (IOException e) {
            e.printStackTrace();
        }
        Scanner scanner=new Scanner(System.in);
        boolean run=true;
        while (run) {
            System.out.println("Meniu:");
            System.out.println("1. Afișare produse");
            System.out.println("2. Afișare produse expirate");
            System.out.println("3. Vânzare produs");
            System.out.println("4. Afișare produse cu preț minim");
            System.out.println("5. Salvare produse cu cantitate mai mică decât:");
            System.out.println("6. Ieșire");
            System.out.println("Introduceti optiunea");
            int optiune=scanner.nextInt();
            switch (optiune) {

                case 1:
                    for (Produs produs:produse){
                        System.out.println(produs);
            }
                    break;
                case 2:
                    LocalDate dataCurenta=LocalDate.now();
                    for (Produs produs:produse){
                        if(produs.getData_expirarii().isBefore(dataCurenta)){
                            System.out.println(produs);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Introduceti denumirea produsului de vanzare: ");
                    String denumireVandut=scanner.next();
                    System.out.println("Introduceti cantitatea vanduta: ");
                    int cantitateVanduta=scanner.nextInt();
                    for(Produs produs:produse){
                        if(produs.getDenumire().equalsIgnoreCase(denumireVandut)){
                            if(produs.getCantitate()>=cantitateVanduta){
                                produs.setCantitate(produs.getCantitate()-cantitateVanduta);
                                Produs.actualizareIncasari(produs.getPret(),cantitateVanduta);
                                if(produs.getCantitate()==0){
                                    produse.remove(produs);
                                }
                            }else {
                                System.out.println("Nu exista suficienta cantitate");
                            }
                            break;
                        }


                    }
                    break;
                case 4:
                    double pretMinim=produse.stream().mapToDouble(Produs::getPret).min().orElse(0.0);
                    for(Produs produs:produse){
                        if(produs.getPret()==pretMinim){
                            System.out.println(produs);
                        }
                    }
                    break;
                    case 5:
                        System.out.println("Introduceti cantitatea minima: ");
                        int cantitateMinima=scanner.nextInt();
                        try(FileWriter writer=new FileWriter("produse_mici.csv")){
                            for (Produs produs:produse){
                                if(produs.getCantitate()<cantitateMinima){
                                    writer.write(produs.getDenumire()+","+produs.getPret()+","+produs.getCantitate()+","+produs.getData_expirarii()+"\n");

                                }
                            }
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                        System.out.println("Produsele au fost salvate in fisierul produse_mici.csv");
                        break;
                case 6:
                    run=false;
                    break;
                default:
                    System.out.println("Optiune invalida");
                    break;




        }



        }


    }
}
