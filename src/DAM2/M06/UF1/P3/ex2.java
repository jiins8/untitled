package DAM2.M06.UF1.P3;

import java.util.Arrays;
import java.util.List;

public class ex2 {
    public static void main(String[] args) {
        List<Double> numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);

        System.out.print("Cuadrados: ");
        numbers.forEach(number -> {
            double square = Math.pow(number, 2);
            System.out.print(square + " ");
        });
    }
}
