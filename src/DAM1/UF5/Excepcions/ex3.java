package DAM1.UF5.Excepcions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[10];
        try {
            for (int i = 0; i < array.length; i++) {
                array[i] = sc.nextInt();
            }
            System.out.print("Introdueix una posició de l'array del 0-9");
            int posicio = sc.nextInt();
            System.out.println("Posicio: " + posicio + ", numero: " + array[posicio]);
        } catch (InputMismatchException e) {
            System.out.println("Has d'introduir un nombre enter: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No existeix aquesta posicio: " + e);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
