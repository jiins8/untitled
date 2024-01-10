package DAM1.UF5.Arraylist.ex2;

import java.util.ArrayList;
import java.util.Scanner;

public class Port {
    ArrayList<Vaixell> vaixells = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Port port = new Port();
        port.menu();
        int opcio = sc.nextInt();
        while (opcio != 0){
            switch (opcio){
                case 1:
                    port.afegirVaixell(sc);
                    break;
                case 2:
                    port.buscarVaixell(sc);
                    break;
                case 3:
                    port.modificarVaixell(sc);
                    break;
                case 4:
                    port.eliminarVaixell(sc);
                    break;
                case 5:
                    port.llistarVaixells();
                    break;
            }
            port.menu();
            opcio = sc.nextInt();
        }


    }
    public void menu(){
        System.out.println("");
        System.out.println("Selecciona una opcio");
        System.out.println("1. Afegir vaixell");
        System.out.println("2. Buscar vaixell");
        System.out.println("3. Modificar vaixell");
        System.out.println("4. Eliminar vaixell");
        System.out.println("5. Llistar vaixells");
        System.out.println("0. Sortir");
    }

    public void afegirVaixell(Scanner sc){
        Vaixell vaixell = new Vaixell();
        System.out.println("Nom del vaixell");
        vaixell.setNom(sc.next());
        System.out.println("Preu del vaixell");
        vaixell.setPreu(sc.nextDouble());
        System.out.println("Edat del vaixell");
        vaixell.setEdat(sc.nextInt());
        vaixells.add(vaixell);
    }
    public void llistarVaixells(){
        int i = 0;
        for (Vaixell vaixell: vaixells) {
            System.out.println(i + " "+ vaixell);
            i++;
        }
    }
    public void modificarVaixell(Scanner sc){
        System.out.println("Selecciona el vaixell que vols modificar");
        llistarVaixells();
        int numVaixell = sc.nextInt();
        Vaixell vaixell = vaixells.get(numVaixell);
        System.out.println("Introdueix el nou nom del vaixell:");
        vaixell.setNom(sc.next());
        System.out.println("Introdueix el nou preu del vaixell:");
        vaixell.setPreu(sc.nextDouble());
        System.out.println("Introdueix la nova edat del vaixell:");
        vaixell.setEdat(sc.nextInt());
    }
    public void eliminarVaixell(Scanner sc){
        System.out.println("Selecciona el vaixell que vols eliminar");
        llistarVaixells();
        int numVaixell = sc.nextInt();
        vaixells.remove(numVaixell);
        System.out.println("Vaixell eliminat");
    }
    public void buscarVaixell(Scanner sc){
        System.out.println("Introdueix el nom del vaixell");
        String nom = sc.next();
        boolean trobat = false;
        for (Vaixell vaixell: vaixells) {
            if (vaixell.getNom().equals(nom)){
                System.out.println("Vaixell trobat");
                System.out.println(vaixell);
                trobat = true;
                break;
            }
        }
        if (!trobat){
            System.out.println("No existeix aquest nom");
        }
    }
}
