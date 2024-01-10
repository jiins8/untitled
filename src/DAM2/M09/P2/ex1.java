package DAM2.M09.P2;

import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();

        final String FI = "BYE";
        final String ERROR = "ERROR";
        final int CODI_ERROR= 200;

        String linia = sc.nextLine();

        while (!linia.equalsIgnoreCase(FI) && !linia.equalsIgnoreCase(ERROR)){
            System.out.println(linia);
            linia = sc.nextLine();
        }
        if (linia.equalsIgnoreCase(ERROR)){
            System.exit(CODI_ERROR);
        }

    }
}
