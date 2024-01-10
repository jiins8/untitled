package DAM2.M06.UF1.ExamenAnyPassat;

import java.io.IOException;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pizzeria {

    private static void copyFile(Path sourcePath, Path targetPath) throws IOException {
        if (Files.exists(sourcePath)) {
            if (Files.isDirectory(sourcePath)) {
                if (!Files.exists(targetPath)) {
                    Files.createDirectories(targetPath);
                }

                try (DirectoryStream<Path> stream = Files.newDirectoryStream(sourcePath)) {
                    for (Path entry : stream) {
                        copyFile(entry, targetPath.resolve(entry.getFileName()));
                    }
                }
            } else {
                Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }

    public static void ferBackup() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_H_mm");
        String dataHoraActual = dateFormat.format(new Date());

        String directoriBackup = "pizzeria_backup_" + dataHoraActual;

        try {
            Path directoriActual = Paths.get("pizzeria").toAbsolutePath(); // Set the source directory path
            Path directoriBackups = Paths.get("backups").toAbsolutePath();
            Path directoriBackupComplet = directoriBackups.resolve(directoriBackup); // Set the target directory path

            if (!Files.exists(directoriBackups)) {
                Files.createDirectories(directoriBackups);
            }

            if (!Files.exists(directoriBackupComplet)) {
                Files.createDirectories(directoriBackupComplet);
            }

            Path arxiuComandes = directoriActual.resolve("comandes.xml");
            if (Files.exists(arxiuComandes)) {
                Files.delete(arxiuComandes);
            }

            copyFile(directoriActual, directoriBackupComplet);

            System.out.println("Backup realitzat amb èxit a " + directoriBackupComplet.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ferBackup();
    }

}
