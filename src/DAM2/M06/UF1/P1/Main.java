package DAM2.M06.UF1.P1;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {

    /*    for (Path path : FileSystems.getDefault().getRootDirectories()) {
            System.out.println(path);
            System.out.println(path.getParent());
        }

     */
        System.out.println("Exercici 1: Crea un programa Java que donat un directori, llisti per pantalla els fitxers i directoris que conté, " +
                "idealment, també per a cada subdirectori.");
        File directori = new File("../untitled/src/DAM2/M06");
        System.out.println(directori.exists());
        llistarFitxers(directori);

        System.out.println("Exercici 3: Crea un programa Java que llisti totes les unitats de disc que hi ha en el pc. Parteix de la classe " +
                "java.nio.file.FileSystems i usa altres classes d’aquest package");
        llistarUnitatsDisc();

        System.out.println("Exercici 4: Crea un programa Java que donada una ruta (classe Path), ens digui si existeix o no. Usa les classes " +
                "java.nio.Path i java.nio.Files. Hi ha diverses maneres de crear un objecte de tipus Path, hem de provar-los tots:\n" +
                "4.1 Path");

        String ruta = "../untitled/src/DAM2/M06";
        Path path = Path.of(ruta);
        System.out.println(Files.exists(path));

        System.out.println("\n4.2 Paths");
        Path paths = Paths.get(ruta);
        System.out.println(Files.exists(paths));

        System.out.println("\n4.3 URI");
        URI uri = Paths.get(ruta).toUri();
        Path pathURI = Paths.get(uri);
        System.out.println(Files.exists(pathURI));

        System.out.println("\n4.4 FileSystem");
        FileSystem fileSystem = FileSystems.getDefault();
        Path pathFileSystem = fileSystem.getPath(ruta);
        System.out.println(Files.exists(pathFileSystem));

        System.out.println("Exercici 5\n" +
                "5.1 Mostri per pantalla la ruta absoluta del fitxer/directori");
        System.out.println(path.toAbsolutePath());
        System.out.println("\n5.2 Mostri per pantalla el nom del fitxer / directori (sense la part corresponent a la ruta sencera)");
        System.out.println(path.getFileName());
        System.out.println("\n5.3 Mostri per pantalla la ruta sencera del directori on es trobi ubicat (directori pare)");
        System.out.println(path.getParent().toAbsolutePath());
        System.out.println("\n5.4 Mostri per pantalla cada component de la ruta os es troba el fitxer / directori");
        for (int i = 0; i < path.getNameCount(); i++) {
            System.out.println(path.getName(i));
        }
        System.out.println("\n5.5 Mostri per pantalla la unitat de disc on es troba el fitxer / directori");
        Path root = pathURI.getRoot();
        System.out.println(root);

        System.out.println("\n5.6 Mostri per pantalla si la ruta és absoluta o no, i si és relativa, informi de quina és la seva ruta absoluta");
        if (path.isAbsolute()){
            System.out.println("La ruta es absoluta: "+ path);
        }else {
            System.out.println("La ruta es relativa: " + path.toAbsolutePath());
        }


    }


    public static void llistarFitxers(File directori) {
        File llista[] = directori.listFiles();
        if (llista != null) {
            for (File file : llista) {
                System.out.println(file.getName());
                if (file.isDirectory()) {
                    llistarFitxers(file);
                    System.out.println(" ");
                }
            }
        }
    }

    public static void llistarUnitatsDisc() {
        FileSystem fileSystems = FileSystems.getDefault();
        for (FileStore fileStore : fileSystems.getFileStores()) {
            System.out.println("Nombre " + fileStore.name());
            System.out.println("Tipo " + fileStore.type());
            for (Path path : fileSystems.getRootDirectories()) {
                System.out.println("Ruta " + path.toString());
            }
            try {
                System.out.println("Espacio " + fileStore.getTotalSpace());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
