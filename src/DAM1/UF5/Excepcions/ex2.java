package DAM1.UF5.Excepcions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean numsCorrectes = false;
        do {
            try {
                System.out.print("Introdueix un número: ");
                int num1 = scanner.nextInt();
                System.out.print("Introdueix un altre número: ");
                int num2 = scanner.nextInt();
                int resultat = num1 / num2;
                System.out.println("El resultat és: " + resultat);
                numsCorrectes = true;
            } catch (InputMismatchException e) {
                System.out.println("Has d'introduir un nombre enter: " + e);
                scanner.nextLine(); // buidar el buffer de lectura
            } catch (ArithmeticException e) {
                System.out.println("No es pot dividir per 0: " + e);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (!numsCorrectes);
    }
}
