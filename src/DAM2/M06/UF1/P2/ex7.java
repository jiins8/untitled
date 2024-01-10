package DAM2.M06.UF1.P2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ex7 {
    public static void main(String[] args) {

        System.out.println("7.1 Crear un programa que escrigui per pantalla el contingut d’un fitxer usant Files.copy()");
        Path path = Path.of("hola.txt");

        try{
            Files.copy(path, System.out);

        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("7.2 Crear un programa que escrigui en un fitxer tot el que es teclegi usant Files.copy()");
        Path path2 = Path.of("teclat.txt");
        try{
            Files.copy(System.in, path2, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
