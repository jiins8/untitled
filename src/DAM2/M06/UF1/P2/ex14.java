package DAM2.M06.UF1.P2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ex14 {
    public static void main(String[] args) {

        Path sourcePath = Path.of("prova").toAbsolutePath();

        System.out.println(calculateSize(sourcePath));

    }
    private static long calculateSize(Path path) {
        long size;

        try {
            if (Files.isDirectory(path)) {
                size = Files.walk(path).filter(p -> !Files.isDirectory(p)).mapToLong(ex14::sizeSenseExcepcio).sum();
            } else {
                size = Files.size(path);
            }
        } catch (IOException e) {
            System.err.println(e);
            return 0;
        }
        return size;
    }

    private static long sizeSenseExcepcio(Path path) {
        try {
            return Files.size(path);
        } catch (IOException e) {
            System.err.println(e);
        }
        return 0;
    }

}
