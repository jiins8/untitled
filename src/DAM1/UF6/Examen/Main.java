package DAM1.UF6.Examen;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public void menu() {
        System.out.println("Digues quina opcio vols executar:\n" +
                "1) Llistar una pelicula\n" +
                "2) Llistar rating d'una pelicula\n"+
                "3) Llistar peliculas amb mes vots\n" +
                "4) Llistar pelicules de l'actor o actora\n" +
                "0) Sortir ");
    }

    public static void main(String[] args) throws SQLException {
        Connection c = Connexio.getConnection();
        Main main = new Main();
        MovieDao movieDao = new MovieDaoImpl();
        Movie movie = new Movie();
        RatingDao ratingDao = new RatingDaoImplements();
        main.menu();
        Scanner sc = new Scanner(System.in);
        int opcio = sc.nextInt();
        sc.nextLine();

        while (opcio != 0) {
            switch (opcio) {
                case 1: {
                    System.out.println("Introdueix id de pelicula que vols veure");
                    int idMovie = sc.nextInt();
                    sc.nextLine();
                    System.out.println(movieDao.read(idMovie));
                    break;
                }
                case 2:{
                    System.out.println("Introduex id de pelicula que vols veure el rating");
                    System.out.println(ratingDao.read(movie));
                }
            }
            main.menu();
            opcio = sc.nextInt();
            sc.nextLine();
        }
        c.close();
    }
}
