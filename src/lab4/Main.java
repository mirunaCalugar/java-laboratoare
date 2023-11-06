package lab4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void serializare(List<Echipament> echipamente) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("echip.bin"))) {
            outputStream.writeObject(echipamente);
            System.out.println("Colecția a fost serializată cu succes.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Echipament> deserializare() {
        List<Echipament> echipamente = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("echip.bin"))) {
            echipamente = (List<Echipament>) inputStream.readObject();
            System.out.println("Colecția a fost deserializată cu succes.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return echipamente;
    }

    public static void main(String[] args) {
        List<Echipament>echipamente=new ArrayList<>();
        String fisierIntrare="src/echipamente.txt";
        try(BufferedReader reader=new BufferedReader(new FileReader(fisierIntrare))){
            String linie;
            while((linie=reader.readLine())!=null){
                String[] tokens = linie.split(";");
                if (tokens.length >= 5) {
                    String denumire = tokens[0].trim();
                    int nr_inv = Integer.parseInt(tokens[1].trim());
                    double pret = Double.parseDouble(tokens[2].trim());
                    String zona_mag = tokens[3].trim();
                    Stare stare = Stare.valueOf(tokens[4].trim());

                    if (denumire.equalsIgnoreCase("Imprimanta") && tokens.length == 9) {
                        int ppm = Integer.parseInt(tokens[5].trim());
                        int dpi = Integer.parseInt(tokens[6].trim());
                        int p_car = Integer.parseInt(tokens[7].trim());
                        ModTiparire modTiparire = ModTiparire.valueOf(tokens[8].trim());
                        echipamente.add(new Imprimanta(denumire, nr_inv, (float) pret, zona_mag, stare, ppm, dpi, p_car, modTiparire));
                    } else if (denumire.equalsIgnoreCase("Copiator") && tokens.length == 7) {
                        int p_ton = Integer.parseInt(tokens[5].trim());
                        FormatCopiere formatCopiere = FormatCopiere.valueOf(tokens[6].trim());
                        echipamente.add(new Copiator(denumire, nr_inv, pret, zona_mag, stare, p_ton, formatCopiere));
                    } else if (denumire.equalsIgnoreCase("SistemCalcul") && tokens.length == 9) {
                        String tip_mon = tokens[5].trim();
                        double vit_proc = Double.parseDouble(tokens[6].trim());
                        int c_hdd = Integer.parseInt(tokens[7].trim());
                        SistemOperare sistemOperare = SistemOperare.valueOf(tokens[8].trim());
                        echipamente.add(new SistemCalcul(denumire, nr_inv, (float) pret, zona_mag, stare, tip_mon, vit_proc, c_hdd, sistemOperare));
                    }
                }

            }

        }catch(IOException e){
            e.printStackTrace();

        }
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Meniu:");
            System.out.println("1. Afișarea tuturor echipamentelor");
            System.out.println("2. Afișarea imprimantelor");
            System.out.println("3. Afișarea copiatoarelor");
            System.out.println("4. Afișarea sistemelor de calcul");
            System.out.println("5. Modificarea stării unui echipament");
            System.out.println("6. Setarea modului de tipărire pentru o imprimantă");
            System.out.println("7. Setarea formatului de copiere pentru copiatoare");
            System.out.println("8. Instalarea unui sistem de operare pe un sistem de calcul");
            System.out.println("9. Afișarea echipamentelor vândute");
            System.out.println("10. Serializare colecție în 'echip.bin'");
            System.out.println("11. Deserializare colecție din 'echip.bin'");
            System.out.println("12. Ieșire");

            System.out.print("Introduceți opțiunea: ");
            int opțiune = scanner.nextInt();

            switch (opțiune) {
                case 1:
                    for (Echipament e : echipamente) {
                        System.out.println(e);
                    }
                    break;

                case 2:
                    for (Echipament e : echipamente) {
                        if (e instanceof Imprimanta) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 3:
                    for (Echipament e : echipamente) {
                        if (e instanceof Copiator) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 4:
                    for (Echipament e : echipamente) {
                        if (e instanceof SistemCalcul) {
                            System.out.println(e);
                        }
                    }
                    break;


                case 5:
                    System.out.print("Introduceți numărul de inventar al echipamentului de modificat: ");
                    int nrInvModificat = scanner.nextInt();
                    boolean gasit = false;

                    for (Echipament e : echipamente) {
                        if (e.getNr_inv() == nrInvModificat) {
                            System.out.println("Starea actuală a echipamentului " + e.getDenumire() + " este: " + e.getStare());
                            System.out.print("Introduceți noua stare (ACHIZITIONAT, EXPUS sau VANDUT): ");
                            String stareNoua = scanner.next();

                            try {
                                Stare stareNouaEnum = Stare.valueOf(stareNoua.toUpperCase());
                                e.setStare(stareNouaEnum);
                                System.out.println("Starea a fost modificată cu succes.");
                                gasit = true;
                                break;
                            } catch (IllegalArgumentException ex) {
                                System.out.println("Starea introdusă nu este validă.");
                                break;
                            }
                        }
                    }

                    if (!gasit) {
                        System.out.println("Echipamentul cu numărul de inventar " + nrInvModificat + " nu a fost găsit.");
                    }
                    break;


                case 6:
                    System.out.print("Introduceți numărul de inventar al imprimantei de modificat: ");
                    int nrInvImprimanta = scanner.nextInt();
                    boolean gasitImprimanta = false;

                    for (Echipament e : echipamente) {
                        if (e instanceof Imprimanta && e.getNr_inv() == nrInvImprimanta) {
                            Imprimanta imprimanta = (Imprimanta) e;
                            System.out.println("Modul de tipărire actual al imprimantei " + imprimanta.getDenumire() + " este: " + imprimanta.getTiparire());
                            System.out.print("Introduceți noul mod de tipărire (COLOR sau ALB_NEGRU): ");
                            String modTiparireNou = scanner.next();

                            try {
                                ModTiparire modTiparireNouEnum = ModTiparire.valueOf(modTiparireNou.toUpperCase());
                                imprimanta.setTiparire(modTiparireNouEnum);
                                System.out.println("Modul de tipărire a fost modificat cu succes.");
                                gasitImprimanta = true;
                                break;
                            } catch (IllegalArgumentException ex) {
                                System.out.println("Modul de tipărire introdus nu este valid.");
                                break;
                            }
                        }
                    }

                    if (!gasitImprimanta) {
                        System.out.println("Imprimanta cu numărul de inventar " + nrInvImprimanta + " nu a fost găsită sau nu este o imprimantă.");
                    }
                    break;


                case 7:
                    System.out.print("Introduceți numărul de inventar al copiatorului de modificat: ");
                    int nrInvCopiator = scanner.nextInt();
                    boolean gasitCopiator = false;

                    for (Echipament e : echipamente) {
                        if (e instanceof Copiator && e.getNr_inv() == nrInvCopiator) {
                            Copiator copiator = (Copiator) e;
                            System.out.println("Formatul de copiere actual al copiatorului " + copiator.getDenumire() + " este: " + copiator.getFormat());
                            System.out.print("Introduceți noul format de copiere (A3 sau A4): ");
                            String formatCopiereNou = scanner.next();

                            try {
                                FormatCopiere formatCopiereNouEnum = FormatCopiere.valueOf(formatCopiereNou.toUpperCase());
                                copiator.setFormat(formatCopiereNouEnum);
                                System.out.println("Formatul de copiere a fost modificat cu succes.");
                                gasitCopiator = true;
                                break;
                            } catch (IllegalArgumentException ex) {
                                System.out.println("Formatul de copiere introdus nu este valid.");
                                break;
                            }
                        }
                    }

                    if (!gasitCopiator) {
                        System.out.println("Copiatorul cu numărul de inventar " + nrInvCopiator + " nu a fost găsit sau nu este un copiator.");
                    }
                    break;


                case 8:
                    System.out.print("Introduceți numărul de inventar al sistemului de calcul de modificat: ");
                    int nrInvSistemCalcul = scanner.nextInt();
                    boolean gasitSistemCalcul = false;

                    for (Echipament e : echipamente) {
                        if (e instanceof SistemCalcul && e.getNr_inv() == nrInvSistemCalcul) {
                            SistemCalcul sistemCalcul = (SistemCalcul) e;
                            System.out.println("Sistemul de operare actual al sistemului de calcul " + sistemCalcul.getDenumire() + " este: " + sistemCalcul.getSist_op());
                            System.out.print("Introduceți noul sistem de operare (WINDOWS sau LINUX): ");
                            String sistemOperareNou = scanner.next();

                            try {
                                SistemOperare sistemOperareNouEnum = SistemOperare.valueOf(sistemOperareNou.toUpperCase());
                                sistemCalcul.setSist_op(sistemOperareNouEnum);
                                System.out.println("Sistemul de operare a fost instalat cu succes.");
                                gasitSistemCalcul = true;
                                break;
                            } catch (IllegalArgumentException ex) {
                                System.out.println("Sistemul de operare introdus nu este valid.");
                                break;
                            }
                        }
                    }

                    if (!gasitSistemCalcul) {
                        System.out.println("Sistemul de calcul cu numărul de inventar " + nrInvSistemCalcul + " nu a fost găsit sau nu este un sistem de calcul.");
                    }
                    break;

                case 9:
                    for (Echipament e : echipamente) {
                        if (e.getStare() == Stare.vandut) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 10:
                    serializare(echipamente);
                    break;

                case 11:
                    echipamente = deserializare();
                    break;

                case 12:
                    running = false;
                    break;

                default:
                    System.out.println("Opțiune invalidă!");
                    break;
            }
        }
    }
}



