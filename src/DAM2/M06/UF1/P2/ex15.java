package DAM2.M06.UF1.P2;

import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class ex15 {
    public static void main(String[] args) {
        String path = "../untitled/src/DAM2/M06/P2";

        String cadena = "ex1";

     try{
         Stream<Path> fitxers = Files.find(Paths.get(path), Integer.MAX_VALUE, (p, attributes) -> p.getFileName().toString().startsWith(cadena));

         fitxers.forEach(System.out::println);
     }catch (IOException e){
         e.printStackTrace();
     }
    }
}
