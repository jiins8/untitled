package DAM1.UF5.Hashmap.ex1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        HashMap<String, Mobil> inventari = new HashMap<String, Mobil>();

        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        main.menu();
        int opcio = sc.nextInt();
        while (opcio != 0) {
            switch (opcio) {
                case 1:
                    main.afegirMobil(sc, inventari);
                    break;
                case 2:
                    main.treureMobil(sc, inventari);
                    break;
                case 3:
                    main.buscarMobilPerDni(inventari, sc);
                    break;
                case 4:
                    main.buscarDniPerMobil(inventari, sc);
                    break;

            }
            main.menu();
            opcio = sc.nextInt();
        }
    }

    public void menu() {
        System.out.println("\n" +
                "Selecciona una opcio" + "\n" +
                "1. Afegir mobil" + "\n" +
                "2. Treure mobil" + "\n" +
                "3. Buscar mobil a partir d'un DNI" + "\n" +
                "4. Buscar DNI a partir del numero de mobil" + "\n" +
                "0. Sortir");
    }

    public void afegirMobil(Scanner sc, HashMap<String, Mobil> inventari) {
        Mobil mobil = new Mobil();
        System.out.println("Introdueix la marca");
        mobil.setMarca(sc.next());
        System.out.println("Introdueix el model");
        sc.nextLine();
        mobil.setModel(sc.nextLine());
        System.out.println("Introdueix el numero");
        mobil.setNumero(sc.nextInt());
        System.out.println("Introdueix DNI de l'alumne");
        inventari.put(sc.next(), mobil);
    }

    public void treureMobil(Scanner sc, HashMap<String, Mobil> inventari) {
        System.out.println("Introdueix el DNI del mobil que vols eliminar");
        String dni = sc.next();
        if (inventari.containsKey(dni)) {
            inventari.remove(dni);
            System.out.println("Mobil eliminat");
        } else {
            System.out.println("No s'ha trobar el DNI");
        }
    }

    public void buscarMobilPerDni(HashMap<String, Mobil> inventari, Scanner sc) {
        System.out.println("Introdueix el DNI per buscar el mòbil:");
        String dni = sc.next();
        if (inventari.containsKey(dni)) {
            Mobil mobil = inventari.get(dni);
            System.out.println("DNI: " + dni + ". Numero: " + mobil.getNumero());
        } else {
            System.out.println("No s'ha trobat cap mòbil associat al DNI " + dni);
        }
    }

    public void buscarDniPerMobil(HashMap<String, Mobil> inventari, Scanner sc) {
        System.out.println("Introdueix el numero per buscar el DNI");
        int num = sc.nextInt();
        String dni;
        for (Map.Entry<String, Mobil> entry : inventari.entrySet()) {
            Mobil mobil = entry.getValue();
            if (mobil.getNumero() == num) {
                dni = entry.getKey();
                System.out.println("Numero: " + mobil.getNumero() + ". DNI: " + dni);
            }
        }
    }
}
