package DAM2.M06.UF1.Examen;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ex1 {
    public static void main(String[] args) throws IOException {
        File directori = new File("exemple");
        //comptador(directori);

        long countDirectories= Files.walk(Paths.get("exemple")).parallel().filter(p -> p.toFile().isDirectory()).count();
        System.out.println("Num directoris: " + countDirectories);


        long countFiles= Files.walk(Paths.get("exemple")).parallel().filter(p -> p.toFile().isFile()).count();
        System.out.println("Num fitxers: " + countFiles);

    }
    public static void comptador(File directori){
        File llista[] = directori.listFiles();
        int numDirectoris = 0;
        int numFitxers = 0;
        if (llista!= null){
            for (File file:llista) {
                if(file.isDirectory()){
                    numDirectoris++;
                    comptador(file);
                    System.out.println("");
                }else if(file.isFile()){
                    numFitxers++;
                }
            }
            System.out.println("Num directoris: " + numDirectoris);
            System.out.println("Num fitxers: " + numFitxers);
        }

    }

}
