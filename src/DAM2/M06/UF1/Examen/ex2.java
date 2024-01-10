package DAM2.M06.UF1.Examen;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class ex2 {

    public static void main(String[] args) {
        String directori = "exemple";
        String copia = "exemple/tot.txt";

        try {
            concatenarFitxersTxt(directori, copia);
            System.out.println("Operació completada");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void concatenarFitxersTxt(String directori, String arxiuSortida) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(arxiuSortida))) {
            Files.walk(Paths.get(directori)).filter(Files::isRegularFile).filter(path -> path.toString().endsWith(".txt")).forEach(path -> {
                try {
                    List<String> linies = Files.readAllLines(path);
                    for (String linia : linies) {
                        bufferedWriter.write(linia + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
