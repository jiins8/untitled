package DAM2.M06.UF1.P2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ex9_1 {
    public static void main(String[] args) {
        String pathArxiu = "0_palabras_todas_no_conjugaciones.txt";

        try{
            Path path = Paths.get(pathArxiu);
            BufferedReader bufferedReader = Files.newBufferedReader(path);

            String linia;
            while ((linia = bufferedReader.readLine()) != null){
                System.out.println(linia);
            }
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
