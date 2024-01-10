package DAM2.M06.UF1.P3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ex3 {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "David"));

        // Saluda a cada nombre en la lista
        for (String nombre : nombres) {
            System.out.println("Hola, " + nombre + "!");
        }
    }
}
