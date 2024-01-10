package DAM2.M06.UF1.P3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Alumne alumne1 = new Alumne("Jinshuo", "Xia", "DAM", Arrays.asList("M6", "M9"), 8);

        Alumne alumne2 = new Alumne("Waly", "Razaq", "DAM", Arrays.asList("M6", "M9", "M2"), 3);

        Alumne alumne3 = new Alumne("Ate", "Muhammad", "DAM", Arrays.asList("M6", "M9"), 5);

        Alumne alumne4 = new Alumne("David", "Ramirez", "DAM", Arrays.asList("M6"), 2);

        Alumne alumne5 = new Alumne("Jin", "Xia", "DAM", Arrays.asList("M6", "M13"), 8);


        List<Alumne> alumnes = Arrays.asList(alumne1, alumne2, alumne3, alumne4, alumne5);

        Stream<Alumne> alumneStream1 = alumnes.stream();
        Stream<Alumne> alumneStream2 = Stream.of(alumne1, alumne2, alumne3);

        //Imprimir per pantalla l'array
        //alumnes.forEach(System.out::println);
        //alumneStream1.forEach(System.out::println);

        //Donat un Stream, imprimir per pantalla la següent informació
        System.out.println("Exercici 5");
        alumnes.forEach(a -> System.out.println(a.getNom() + " " + a.getCognom() + ": " + a.getCicle()));

        //Filtrar alumnes que no fan DAM
        alumnes.stream().filter(a -> a.getCicle().equalsIgnoreCase("DAM")).forEach(System.out::println);
        System.out.println("Exercici 6: Imprimir alumens que fan 2 o més mòduls");
        alumnes.stream().filter(a -> a.getModuls().size()>= 2).forEach(System.out::println);


        System.out.println("Exercici 7: Escriure en majuscula els noms");
        Stream<String> noms = alumnes.stream().map(Alumne::getNom);
        noms.forEach(a -> System.out.println(a.toUpperCase()));

        //Ordenar alumnes per la nota
        Comparator<Alumne> comparatorPerNota = (o1, o2) -> (int) (o1.getNota() - o2.getNota());
        Collections.sort(alumnes, comparatorPerNota);
        System.out.println(alumnes);

        System.out.println("Exercici 8: Ordenar per cognom i per nom");
        Collections.sort(alumnes, (o1, o2) -> o1.getCognom().compareToIgnoreCase(o2.getCognom()));
        alumnes.sort(Comparator.comparing(Alumne::getCognom).thenComparing(Alumne::getNom));
        System.out.println(alumnes);

        System.out.println("Exercici 9: Numero d'alumnes que te l'stream ");
        System.out.println(alumnes.stream().count());

        System.out.println("Exercici 10: Imprimeix COGNOM, NOM");
        alumnes.stream().forEach(a -> System.out.println(a.getCognom().toUpperCase() +", " + a.getNom().toUpperCase()));

        System.out.println("Exercici 11: Llista ordenada per la quantitat de moduls utilitzant sorted");
        alumnes.stream().sorted(Comparator.comparingInt(a -> a.getModuls().size()*-1)).forEach(System.out::println);
        System.out.println("Otra solucion");
        Comparator<Alumne> comparatorAlumenPerModuls = ((a1, a2) -> a2.getModuls().size() - a1.getModuls().size());
        alumnes.stream().sorted(comparatorAlumenPerModuls).forEach(System.out::println);

        System.out.println("Exercici 12: Imprimeix llista amb alumnes repetits i un altre llista sense repetits");
        alumneStream1 = Stream.of(alumne1, alumne2, alumne3, alumne4, alumne5);
        Stream<Alumne> al = alumneStream1.distinct();
        al.forEach(System.out::println);

        System.out.println("Exercici 13: Mitjana de totes les notes");
        double average = alumnes.stream().mapToDouble(Alumne::getNota).average().orElse(0d);
        System.out.println(average);

        System.out.println("Exercici 14: Alumnes amb nota igual o superior a 5");
        alumnes.stream().filter(a -> a.getNota() >= 5).forEach(System.out::println);

        System.out.println("Exercici 15: Imprimeix alumne amb nota més alta");
        Optional<Alumne> alumneMillorNota = alumnes.stream().max((a1, a2) -> {
            if (a1.getNota() == a2.getNota())
                return 0;
            if (a1.getNota() > a2.getNota())
                return 1;
            else return -1;
        });
        System.out.println(alumneMillorNota);

        System.out.println("Una altre manera de fer-ho");
        Optional<Alumne> notaMax = alumnes.stream().max(Comparator.comparing(Alumne::getNota));
        System.out.println(notaMax);

        System.out.println("Exercici 16: Imprimeix el nom y els moduls");

        Map<String, List<String>> map = alumnes.stream().collect(Collectors.toMap(Alumne::getNom, Alumne::getModuls));
        System.out.println(map);
    }
}
