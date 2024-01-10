package DAM1.UF5.Hashset.ex2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    HashSet<Tasca> toBeDone = new HashSet<>();
    HashSet<Tasca> doing = new HashSet<>();
    HashSet<Tasca> done = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        main.menu();
        int opcio = sc.nextInt();
        while (opcio != 0) {
            switch (opcio) {
                case 1:
                    main.afegirTasca();
                    break;
                case 2:
                    main.toBeDoneADoing(sc);
                    break;
                case 3:
                    main.toDoingADDone(sc);
                    break;
                case 4:
                    main.llistarTasques();
                    break;

            }
            main.menu();
            opcio = sc.nextInt();
        }

    }

    public void afegirTasca() {
        Scanner sc = new Scanner(System.in);
        Tasca tasca = new Tasca();
        System.out.println("Introdueix nom de la tasca");
        tasca.setNom(sc.next());
        System.out.println("Introdueix descripcio");
        tasca.setDescripcio(sc.next());
        toBeDone.add(tasca);
    }

    public void menu() {
        System.out.println("");
        System.out.println("Selecciona una opcio" + "\n" +
                "1. Afegir tasca" + "\n" +
                "2. Moure tasca TO BE DONE --> DOING" + "\n" +
                "3. Moure tasca DOING --> DONE" + "\n" +
                "4. Mostrar estat de les tasques" + "\n" +
                "0. Sortir");
    }

    public void toBeDoneADoing(Scanner sc) {
        boolean trobat = false;
        System.out.println("");
        System.out.println("Introdueix el nom de la tasca que vols moure");
        llistarTascaToBeDone();
        String nomTasca = sc.next();
        Iterator<Tasca> iterator = toBeDone.iterator();
        while (iterator.hasNext()) {
            Tasca tasca = iterator.next();
            if (tasca.getNom().contains(nomTasca)) {
                iterator.remove();
                doing.add(tasca);
                trobat = true;
                System.out.println("Tasca mogut correctament");
            }
        }
        if (!trobat) {
            System.out.println("No s'ha trobat la tasca");
        }
    }

    public void toDoingADDone(Scanner sc) {
        boolean trobat = false;
        System.out.println("");
        System.out.println("Introdueix el nom de la tasca que vols moure");
        llistarTascaDoing();
        String nomTasca = sc.next();
        Iterator<Tasca> iterator = doing.iterator();
        while (iterator.hasNext()) {
            Tasca tasca = iterator.next();
            if (tasca.getNom().contains(nomTasca)) {
                iterator.remove();
                done.add(tasca);
                trobat = true;
                System.out.println("Tasca mogut correctament");
            }
        }
        if (!trobat) {
            System.out.println("No s'ha trobat la tasca");
        }
    }

    public void llistarTasques() {
        llistarTascaToBeDone();
        System.out.println("");
        llistarTascaDoing();
        System.out.println("");
        llistarTascaDone();

    }

    public void llistarTascaToBeDone() {
        System.out.println("TO BE DONE LIST");
        for (Tasca tasca : toBeDone) {
            System.out.println(tasca);
        }
    }

    public void llistarTascaDoing() {
        System.out.println("DOING LIST");
        for (Tasca tasca : doing) {
            System.out.println(tasca + "\n");
        }
    }

    public void llistarTascaDone() {
        System.out.println("DONE LIST");
        for (Tasca tasca : done) {
            System.out.println(tasca + "\n");
        }
    }
}

