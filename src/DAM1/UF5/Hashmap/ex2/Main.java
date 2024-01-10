package DAM1.UF5.Hashmap.ex2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Jugador> jugadors = new HashMap<>();
        Main main = new Main();
        main.menu();
        int opcio = sc.nextInt();
        while (opcio != 0) {
            switch (opcio) {
                case 1:
                    main.afegirJugador(jugadors, sc);
                    break;
                case 2:
                    main.buscarJugadorPerDorsal(jugadors, sc);
                    break;
                case 3:
                    main.buscarJugadorPerNom(jugadors, sc);
                    break;
                case 4:
                    main.llistarJugadorsPerDorsal(jugadors);
                    break;
                case 5:
                    main.llistarJugadorPerEdat(jugadors);
                    break;
                case 6:
                    main.llistarJugadorPerPosicio(jugadors);
                    break;
            }
            main.menu();
            opcio = sc.nextInt();
        }
    }

    public void menu() {
        System.out.println("\n" +
                "Selecciona una opcio" + "\n" +
                "1. Introduir jugador" + "\n" +
                "2. Buscar jugador per dorsal" + "\n" +
                "3. Buscar jugador per nom" + "\n" +
                "4. Llistar jugadors ordenats per numero de dorsal" + "\n" +
                "5. Llistar jugadors per edat" + "\n" +
                "6. Llistar jugador per posicio" + "\n" +
                "0. Sortir" + "\n");

    }

    public void afegirJugador(HashMap<Integer, Jugador> jugadors, Scanner sc) {
        Jugador jugador = new Jugador();
        System.out.println("Introdueix nom");
        jugador.setNom(sc.next());
        System.out.println("Introdueix edat");
        jugador.setEdat(sc.nextInt());
        System.out.println("Introdueix posicio");
        jugador.setPosicio(sc.next());
        System.out.println("Introdueix num dorsal");
        jugadors.put(sc.nextInt(), jugador);
    }

    public void buscarJugadorPerDorsal(HashMap<Integer, Jugador> jugadors, Scanner sc) {
        System.out.println("Introdueix el dorsal per buscar el jugador");
        int dorsal = sc.nextInt();
        if (jugadors.containsKey(dorsal)) {
            Jugador jugador = jugadors.get(dorsal);
            System.out.println("Dorsal: " + dorsal + " " + jugador);
        } else System.out.println("No existeix aquest dorsal");
    }

    public void buscarJugadorPerNom(HashMap<Integer, Jugador> jugadors, Scanner sc) {
        System.out.println("Introdueix el nom del jugador");
        String nom = sc.next();
        boolean trobat = false;
        for (Map.Entry<Integer, Jugador> entry : jugadors.entrySet()) {
            Jugador jugador = entry.getValue();
            if (jugador.getNom().equals(nom)) {
                System.out.println(jugador);
                trobat = true;
            }
        }
        if (!trobat) System.out.println("No existeix aquest nom");
    }

    public void llistarJugadorsPerDorsal(HashMap<Integer, Jugador> jugadors) {
        List<Integer> dorsals = new ArrayList<>(jugadors.keySet());
        Collections.sort(dorsals);
        for (Integer dorsal : dorsals) {
            Jugador jugador = jugadors.get(dorsal);
            System.out.println("Dorsal: " + dorsal + ". " + jugador);
        }
    }
    public void llistarJugadorPerEdat(HashMap<Integer, Jugador> jugadors){
        List<Jugador> jugadorList = new ArrayList<>(jugadors.values());
        jugadorList.sort((j1, j2) -> Integer.compare(j1.getEdat(), j2.getEdat()));
        for (Jugador jugador : jugadorList) {
            System.out.println(jugador);
        }
    }
    public void llistarJugadorPerPosicio(HashMap<Integer, Jugador> jugadors){
        List<Jugador> jugadorList = new ArrayList<>(jugadors.values());
        jugadorList.sort((j1,j2) -> j1.getPosicio().compareTo(j2.getPosicio()));
        for (Jugador jugador: jugadorList) {
            System.out.println(jugador);
        }
    }
}
