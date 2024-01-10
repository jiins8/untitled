package DAM2.M06.UF1.P2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ex9_2 {
    public static void main(String[] args) {
        String rutaArxiu = "0_palabras_todas_no_conjugaciones.txt";
        String rutaLiniesSenars = "linies_senars.txt";
        String rutaLiniesParells = "linies_parells.txt";

        try {
            Path ruta = Paths.get(rutaArxiu);
            BufferedReader lector = Files.newBufferedReader(ruta);

            BufferedWriter escriptorSenars = new BufferedWriter(new FileWriter(rutaLiniesSenars));
            BufferedWriter escriptorParells = new BufferedWriter(new FileWriter(rutaLiniesParells));

            String linia;
            int numeroLinia = 1;

            while ((linia = lector.readLine()) != null) {
                String[] paraules = linia.split(" ");
                if (numeroLinia % 2 == 0) {
                    escriureEnFitxer(escriptorParells, paraules);
                } else {
                    escriureEnFitxer(escriptorSenars, paraules);
                }
                numeroLinia++;
            }

            lector.close();
            escriptorSenars.close();
            escriptorParells.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void escriureEnFitxer(BufferedWriter escriptor, String[] paraules) throws IOException {
        for (String paraula : paraules) {
            escriptor.write(paraula);
            escriptor.write(" ");
        }
        escriptor.newLine();
    }
    }

