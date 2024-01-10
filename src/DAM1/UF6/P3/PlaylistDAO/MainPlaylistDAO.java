package DAM1.UF6.P3.PlaylistDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MainPlaylistDAO {
    public void menu() {
        System.out.println("Diguis quina opció vols executar:\n"
                + "1) Llista els playlists\n"
                + "2) Selecciona una playlist\n"
                + "3) Introdueix una playlist\n"
                + "4) Modifica una playlist\n"
                + "5) Elimina una playlist\n"
                + "0) Sortir\n"
        );
    }

    public static void main(String[] args) throws SQLException {
        Connection c = Connexio.getConnection();
        MainPlaylistDAO mainPlaylistDAO = new MainPlaylistDAO();
        PlaylistDao playlistDao = new PlaylistDaoImplementacio();
        mainPlaylistDAO.menu();
        Scanner sc = new Scanner(System.in);
        int opcio = sc.nextInt();
        sc.nextLine();
        while (opcio != 0) {
            switch (opcio) {
                case 1: {
                    System.out.println(playlistDao.getPlaylist());
                    break;
                }
                case 2: {
                    System.out.println("Introdueix quina playlist vols veure");
                    int idPlaylist = sc.nextInt();
                    sc.nextLine();
                    System.out.println(playlistDao.read(idPlaylist));
                    break;
                }
                case 3: {
                    System.out.println("Introdueix nom");
                    String name = sc.next();
                    System.out.println("Creat playlist: " + playlistDao.create(new Playlist(0, name)));
                    break;
                }
                case 4: {
                    System.out.println("Introdueix quina playlist vols modificar");
                    int idPlaylist = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introdueix el nom");
                    String nom = sc.next();
                    playlistDao.update(new Playlist(idPlaylist, nom));
                    break;
                }
                case 5: {
                    System.out.println("Introdueix quina playlist vols eliminar");
                    int idPlaylist = sc.nextInt();
                    playlistDao.delete(idPlaylist);
                    break;
                }
                case 0: {

                }
                default: {
                    System.out.println("Introdueix un nombre valid del 0 al 5");
                    break;
                }
            }
            mainPlaylistDAO.menu();
            opcio = sc.nextInt();
            sc.nextLine();
        }
        c.close();
    }
}