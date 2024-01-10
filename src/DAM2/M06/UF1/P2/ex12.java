package DAM2.M06.UF1.P2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ex12 {
    public static void main(String[] args) {

        Path sourcePath = Path.of("prova").toAbsolutePath();
        Path targetPath = Path.of("prova.copy").toAbsolutePath();

        try {
            copyFile(sourcePath, targetPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void copyFile(Path sourcePath, Path targetPath) throws IOException {
        if (Files.exists(sourcePath)) {
            if (!Files.exists(targetPath)) {
                Files.copy(sourcePath, targetPath);

                if (Files.isDirectory(sourcePath)) {
                    Files.list(sourcePath)
                            .forEach(f -> {
                                try {
                                    copyFile(sourcePath.resolve(f.getFileName()), targetPath.resolve(f.getFileName()));
                                } catch (IOException e) {
                                    System.err.println("Something went wrong while copying " + sourcePath.resolve(f.getFileName()));
                                    throw new RuntimeException(e);
                                }
                            });
                }
            }
        }
    }
}
