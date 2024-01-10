package DAM2.M09.P3;

import java.util.ArrayList;
import java.util.Scanner;

public class AlarmaMain {

    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Alarma> alarmas = new ArrayList<>();
    public static void crearAlarma() {
        int hora;
        while (true) {
            System.out.print("\nEscriu l'hora del recordatori: ");
            hora = sc.nextInt();
            if (hora > 23 || hora < 0) {
                System.out.println("S'ha proporcionat un valor incorrecte.");
            } else {
                break;
            }
        }
        int minut;
        while (true) {
            System.out.print("\nEscriu el minut del recordatori: ");
            minut = sc.nextInt();
            if (minut > 59 || minut < 0) {
                System.out.println("S'ha proporcionat un valor incorrecte.");
            } else {
                break;
            }
        }
        sc.nextLine();
        System.out.print("\nEscriu el recordatori: ");
        String recordatori = sc.nextLine();

        alarmas.add(new Alarma(hora, minut, recordatori));
        System.out.println("\nS'ha creat l'alarma.");
    }
    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("0. Donar inici a les alarmes");
            System.out.println("1. Crear nova alarma");
            System.out.print("\nEscriu una opció: ");
            int option = sc.nextInt();
            if (option == 0) {
                break;
            } else if (option == 1) {
                crearAlarma();
            } else {
                System.out.println("S'ha proporcionat una opció no vàlida.");
            }
        }
        for (Alarma alarma: alarmas) {
            Thread alarmaThread = new Thread(alarma);
            alarmaThread.start();
        }
        if (!alarmas.isEmpty()) {
            System.out.println("\nS'han iniciat totes les alarmes.\n");
        } else {
            System.out.println("\nNo s'ha creat cap alarma.");
        }
    }
}
