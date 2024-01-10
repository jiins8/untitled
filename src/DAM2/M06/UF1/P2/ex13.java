package DAM2.M06.UF1.P2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ex13 {

    public static void main(String[] args) {
        String rutaArxiu = "0_palabras_todas_no_conjugaciones.txt";
        String rutaArxiuRandom = "0_palabras_todas_no_conjugaciones_RANDOM.txt";


        try {
            Path ruta = Paths.get(rutaArxiu);
            Stream<String> linies = Files.lines(ruta);

            Stream<String> paraulesDesordenades = desordenarParaules(linies);

            escriureParaulesDesordenades(rutaArxiuRandom, paraulesDesordenades);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Stream<String> desordenarParaules(Stream<String> linies) {
        return linies.flatMap(linea -> {
            String[] paraules = linea.split(" ");
            List<String> paraulesDesordenades = Arrays.asList(paraules);
            Collections.shuffle(paraulesDesordenades);
            return paraulesDesordenades.stream();
        });
    }

    private static void escriureParaulesDesordenades(String rutaArxiu, Stream<String> paraules) throws IOException {
        // Escriu les paraules desordenades en l'arxiu
        try (BufferedWriter escriptor = new BufferedWriter(new FileWriter(rutaArxiu))) {
            paraules.forEach(paraula -> {
                try {
                    escriptor.write(paraula);
                    escriptor.newLine(); // Nova línia després de cada paraula
                } catch (IOException e) {
                    throw new RuntimeException("Error escrivint al fitxer", e);
                }
            });
        }
    }
}
