package lab2;

import java.util.Scanner;

public class exercitiul3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceți șirul de caractere inițial: ");
        String inputString = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder(inputString);

        System.out.print("Introduceți șirul de caractere pentru inserare: ");
        String stringToInsert = scanner.nextLine();

        System.out.print("Introduceți poziția de inserare: ");
        int positionToInsert = scanner.nextInt();

        // Inserăm șirul de caractere în poziția specificată
        stringBuilder.insert(positionToInsert, stringToInsert);

        System.out.println("Șirul după inserare: " + stringBuilder.toString());

        System.out.print("Introduceți poziția de început a porțiunii de șters: ");
        int positionToDelete = scanner.nextInt();
        System.out.print("Introduceți numărul de caractere de șters: ");
        int numberOfCharactersToDelete = scanner.nextInt();

        // Ștergem porțiunea specificată a șirului de caractere
        stringBuilder.delete(positionToDelete, positionToDelete + numberOfCharactersToDelete);

        System.out.println("Șirul după ștergere: " + stringBuilder.toString());

        scanner.close();

    }
}
