package DAM2.M06.UF1.P2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        System.out.println("1.1: Donada una ruta, imprimeix si existeix");
        Path path = Paths.get("../untitled/src/DAM2/M06/P6");
        System.out.println(Files.exists(path));

        System.out.println("\n1.2: Una altre manera de saber si existeix la ruta amb toRealPath");
        try {
            System.out.println(path.toRealPath());

        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("\n3: Amplia el programa del punt 1 per a què si la ruta no existeix, crei un directori referent a la ruta indicada");
        if (!Files.exists(path)){ // si no existeix el path que crei un directori
            try {
                Files.createDirectories(path);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        System.out.println(path.toAbsolutePath());

        System.out.println("\n5: Crea un programa que donada una ruta d’un fitxer o un directori, en faci una còpia de seguretat en un subdirectori del directori pare.");



    }
}
