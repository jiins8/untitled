package DAM2.M06.UF1.P3;

import java.util.Arrays;
import java.util.List;

public class ex1 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        System.out.print("Enteros: ");
        integers.forEach(integer -> {
            System.out.print(integer);
            if (integers.indexOf(integer) < integers.size() - 1) {
                System.out.print("-");
            }
        });
    }
}
