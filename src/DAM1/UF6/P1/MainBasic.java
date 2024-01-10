package DAM1.UF6.P1;

import java.sql.*;
import java.util.Scanner;

public class MainBasic {
    public void menu() {
        System.out.println("Diguis quina opció vols executar:\n"
                + "1) Llista els albums\n"
                + "2) Selecciona un sol album\n"
                + "3) Introdueix un album\n"
                + "4) Modifica un album\n"
                + "5) Elimina un album\n"
                + "6) Llista els tracks\n"
                + "7) Selecciona un sol track\n"
                + "8) Introdueix track\n"
                + "9) Modifica un track\n"
                + "10) Elimina un track\n"
                + "0) Sortir\n"
        );
    }

    public static void main(String args[]) throws SQLException {
        Album album = new Album();
        Track track = new Track();
        Scanner sc = new Scanner(System.in);
        MainBasic main = new MainBasic();
        main.menu();
        int opcio = sc.nextInt();
        sc.nextLine();

        while (opcio != 0) {
            switch (opcio) {
                case 1: {
                    System.out.println(album.llistarAlbums());
                    break;
                }
                case 2: {
                    System.out.println("Introdueix quin album vols veure");
                    int idAlbum = sc.nextInt();
                    sc.nextLine();
                    Album albumLlegit = album.seleccionaAlbum(idAlbum);
                    System.out.println(albumLlegit);
                    System.out.println();
                    break;
                }
                case 3: {
                    System.out.println("Introdueix el titol nou");
                    String titol = sc.nextLine();
                    System.out.println("Introdueix idArtista nou");
                    int idArtista = sc.nextInt();
                    sc.nextLine();
                    System.out.println(album.creaAlbum(titol, idArtista));
                    break;
                }
                case 4: {
                    System.out.println("Introdueix quin album vols modificar");
                    int idAlbum = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introdueix el nou títol");
                    String titol = sc.nextLine();
                    System.out.println("Introdueix el idArtista nou");
                    int idArtista = sc.nextInt();
                    sc.nextLine();
                    album.modificaAlbum(idAlbum, titol, idArtista);
                    break;
                }
                case 5: {
                    System.out.println("Introdueix quin album vols eliminar");
                    int idAlbum = sc.nextInt();
                    sc.nextLine();
                    album.eliminaAlbum(idAlbum);
                    break;
                }
                case 6: {
                    System.out.println(track.llistarTrack());
                    break;
                }
                case 7: {
                    System.out.println("Introdueix quin track vols veure");
                    int idTrack = sc.nextInt();
                    Track seleccionaTrack = track.seleccionaTrack(idTrack);
                    System.out.println(seleccionaTrack);
                    break;
                }
                case 8: {
                    System.out.println("Introdueix nom del track");
                    String nom = sc.next();
                    System.out.println("Introdueix ID album");
                    int idAlbum = sc.nextInt();
                    System.out.println("Introdueix ID media type");
                    int idMediaType = sc.nextInt();
                    System.out.println("Introdueix ID genre");
                    int idGenre = sc.nextInt();
                    System.out.println("Introdueix nom compositor");
                    String nomCompositor = sc.next();
                    System.out.println("Introdueix mil·lisegons");
                    int millisegons = sc.nextInt();
                    System.out.println("Introdueix bytes");
                    int bytes = sc.nextInt();
                    System.out.println("Introdueix preu unitat");
                    double preuUnitat = sc.nextInt();
                    System.out.println(track.creaTrack(nom, idAlbum, idMediaType, idGenre, nomCompositor, millisegons, bytes, preuUnitat));
                    break;
                }
                case 9: {
                    System.out.println("Introdueix quin track vols modificar");
                    int idTrack = sc.nextInt();
                    System.out.println("Introdueix el nou nom");
                    String nom = sc.next();
                    System.out.println("Introdueix el album ID nou");
                    int idAlbum = sc.nextInt();
                    System.out.println("Introdueix ID media type nou");
                    int idMediaType = sc.nextInt();
                    System.out.println("Introdueix ID genre nou");
                    int idGenre = sc.nextInt();
                    System.out.println("Introdueix nom compositor nou");
                    String nomCompositor = sc.next();
                    System.out.println("Introdueix mil·lisegons nou");
                    int millisegons = sc.nextInt();
                    System.out.println("Introdueix bytes nou");
                    int bytes = sc.nextInt();
                    System.out.println("Introdueix preu unitat nou");
                    double preuUnitat = sc.nextInt();
                    track.modificaTrack(idTrack, nom, idAlbum, idMediaType, idGenre, nomCompositor, millisegons, bytes, preuUnitat);
                    break;
                }
                case 10: {
                    System.out.println("Introdueix quin track vols eliminar");
                    int idTrack = sc.nextInt();
                    track.eliminaTrack(idTrack);
                }
                case 0: {
                    break;
                }
                default: {
                    System.out.println("Introdueix un nombre vàlid del 0 al 10");
                    break;
                }
            }

            main.menu();
            opcio = sc.nextInt();
            sc.nextLine();
        }

    }
}