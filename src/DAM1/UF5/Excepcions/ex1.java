package DAM1.UF5.Excepcions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            try {
                System.out.println("Introdueix un num > 0");
                n = sc.nextInt();
                System.out.println("Has introduit un: " + n);
            } catch (InputMismatchException e) {
                sc.nextLine();
                n = 0;
                System.out.println("Has d'introduir un nombre enter: " + e.toString());
            }
        }
        while (n <= 0);
    }
}
