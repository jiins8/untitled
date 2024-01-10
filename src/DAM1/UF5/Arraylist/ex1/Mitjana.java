package DAM1.UF5.Arraylist.ex1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Mitjana {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> notes = new ArrayList<>();
        introdueixValors(sc, notes);
        System.out.println(sumaValors(notes));
        System.out.println(sumaValorsIterator(notes));
        System.out.println(mitjana(notes));
    }

    public static void introdueixValors(Scanner sc, ArrayList<Double> notes) {

        double nota = sc.nextDouble();
        while (nota != -1) {
            notes.add(nota);
            nota = sc.nextDouble();
        }
    }

    public static double sumaValors(ArrayList<Double> notes) {
        double suma = 0;
        for (Double nota : notes) {
            suma += nota;
        }
        return suma;
    }

    public static double sumaValorsIterator(ArrayList<Double> notes) {
        double suma = 0;
        Iterator<Double> iterator = notes.iterator();
        while (iterator.hasNext()) {
            suma += iterator.next();
        }
        return suma;
    }

    public static double mitjana(ArrayList<Double> notes) {
        double suma = sumaValors(notes);
        double mitjana = suma / notes.size();
        return mitjana;
    }
}