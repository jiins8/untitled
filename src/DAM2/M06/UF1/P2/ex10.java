package DAM2.M06.UF1.P2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class ex10 {
    public static void main(String[] args) {
        String rutaArxiu = "0_palabras_todas_no_conjugaciones.txt";
        String rutaArxiuRandom = "0_palabras_todas_no_conjugaciones_RANDOM.txt";

        try {
            Path ruta = Paths.get(rutaArxiu);
            List<String> llistatParaules = Files.readAllLines(ruta);

            Collections.shuffle(llistatParaules);

            escriureParaulesDesordenades(rutaArxiuRandom, llistatParaules);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void escriureParaulesDesordenades(String rutaArxiu, List<String> paraules) throws IOException {
        BufferedWriter escriptor = new BufferedWriter(new FileWriter(rutaArxiu));

        for (String paraula : paraules) {
            escriptor.write(paraula);
            escriptor.newLine();
        }
        escriptor.close();
    }
}
