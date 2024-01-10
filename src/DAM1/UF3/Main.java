package DAM1.UF3;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        File directori = new File("../untitled/src/DAM1.UF3/Fitxers/ex7");

        File llista[] = directori.listFiles();

        main.menu();
        int opcio = sc.nextInt();
        while (opcio != 0) {
            switch (opcio) {
                case 1:

                    break;
            }
            main.menu();
            opcio = sc.nextInt();
        }


    }

    public void menu() {
        System.out.println("Introdueix una opcio" + "\n" +
                "1. Mostra entradas directori per ordre alfabetica" + "\n" +
                "2. Mostra entradas directori per ordre de modificacio" + "\n" +
                "3. Mostra entradas directori per ordre de tamany (mes gran a mes petit)" + "\n" +
                "0. Sortir");
    }
    public void ordreAlfabetic(){

    }


}
