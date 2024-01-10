package DAM1.UF2;

import java.util.Scanner;

public class Main {
    static int[][] taula1;
    static int[][] taula2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        taula1 = new int[5][5];
        taula2 = new int[5][5];

        menu();
        int opcio = sc.nextInt();
        while (opcio != 0) {
            switch (opcio) {
                case 1:
                    System.out.println("Taula 1:");
                    mostrarTaula(taula1);
                    System.out.println("Taula 2:");
                    mostrarTaula(taula2);
                    break;
                case 2:
                    System.out.println("Taula 1");
                    colocarVaixell(sc, taula1);
                    System.out.println("Taula 2");
                    colocarVaixell(sc, taula2);
                    break;
                case 3:
                    System.out.println("Taula 1:");
                    main.imprimirTaula(taula1);
                    System.out.println("Taula 2:");
                    main.imprimirTaula(taula2);
                    break;
                case 4:
                    llencarMisil();
            }
            menu();
            opcio = sc.nextInt();
        }
    }

    public static void menu() {
        System.out.println("Selecciona una opcio\n" +
                "1. Crear partida\n" +
                "2. Posiciona vaixells\n" +
                "3. Visualitza partida\n" +
                "4. Llançar missil\n" +
                "5. Rebre misil\n" +
                "0. Finalitza partida");

    }

    public static void mostrarTaula(int[][] taula) {
        for (int i = 0; i < taula.length; i++) {
            for (int j = 1; j < taula.length; j++) {
                System.out.print("A ");
            }
            System.out.println("A");
        }
    }

    public static void colocarVaixell(Scanner sc, int[][] taula) {
        int numVaixell = 3;
        for (int i = 1; i <= numVaixell; i++) {
            System.out.println("Col·loca vaixell num " + i);
            System.out.println("Posicio x");
            int x = sc.nextInt();
            System.out.println("Posicio y");
            int y = sc.nextInt();
            System.out.println("Orientacio horitzontal (h), vertical (v)");
            String orientacio = sc.next();

            if (comprovarPosicio(x, y, taula) && comprovarOrientacio(orientacio) && !comprovarSolapament(x, y, orientacio, taula)) {
                if (orientacio.equals("h")) {
                    for (int j = y; j < y + 3; j++) {
                        taula[x][j] = 1;
                    }
                } else if (orientacio.equals("v")) {
                    for (int j = x; j < x + 3; j++) {
                        taula[j][y] = 1;
                    }
                }
            } else {
                System.out.println("Posicio o orientacio no vàlida o vaixells es xoquen");
                i--;
            }
        }
    }

    public static boolean comprovarPosicio(int x, int y, int[][] taula) {
        if (x >= 0 && x < taula.length && y >= 0 && y < taula.length) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean comprovarOrientacio(String orientacio) {
        if (orientacio.equals("h") || orientacio.equals("v")) {
            return true;
        } else {
            return false;
        }
    }

    public void imprimirTaula(int[][] taula) {
        for (int i = 0; i < taula.length; i++) {
            for (int j = 0; j < taula[i].length; j++) {
                if (taula[i][j] == 1) {
                    System.out.print("V ");
                } else {
                    System.out.print("A ");
                }
            }
            System.out.println();
        }
    }

    public static boolean comprovarSolapament(int x, int y, String orientacio, int[][] taula) {
        if (orientacio.equals("h")) {
            for (int j = y; j < y + 3; j++) {
                if (taula[x][j] == 1) {
                    return true;
                }
            }
        } else if (orientacio.equals("v")) {
            for (int j = x; j < x + 3; j++) {
                if (taula[j][y] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void llencarMisil() {

    }
}
