package DAM2.M06.UF1.P2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ex5 {
    public static void main(String[] args) {
        String pathName = "prova/hola.txt";
        Path path = Path.of(pathName);

        if(!Files.isDirectory(path)){
            Path copyPath = path.toAbsolutePath().getParent().getParent().resolve(path.getFileName());
            System.out.println(copyPath);

            try {
                Files.copy(path, copyPath);
            }catch (IOException e){
                e.printStackTrace();
            }
    }
}
}
