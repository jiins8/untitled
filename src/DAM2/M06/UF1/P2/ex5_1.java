package DAM2.M06.UF1.P2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

//copiar un arxiu i crear un altre amb el mateix contingut
public class ex5_1 {
    public static void main(String[] args) {
        String pathName = "prova/hola.txt";
        Path path = Path.of(pathName);

        if(!Files.isDirectory(path)){
           Path copyPath = path.toAbsolutePath().getParent().getParent().resolve(path.getFileName());

            System.out.println(copyPath);
            try {
                Files.copy(path, copyPath, StandardCopyOption.REPLACE_EXISTING); // si el directori ja existeix que el sobreescrigui
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}