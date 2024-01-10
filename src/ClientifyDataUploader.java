import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientifyDataUploader {
    public static void main(String[] args) {
        // URL de la API de Clientify
        String clientifyApiUrl = "https://api.clientify.net/v1/";

        // Clave de API proporcionada por Clientify
        String apiKey = "c5b6325daa345e3c6d50c57bed7d52f3633a198b";

        // Datos de conexión a la base de datos SQLite
        String dbUrl = "jdbc:sqlite:prueba.db";

        try (Connection connection = DriverManager.getConnection(dbUrl);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, first_name, other_columns FROM tu_tabla");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Configurar el cliente HTTP
            HttpClient httpClient = HttpClient.newHttpClient();

            while (resultSet.next()) {
                // Preparar los datos para enviar a la API
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String otherColumns = resultSet.getString("other_columns");

                // Construir el cuerpo de la solicitud HTTP
                String requestBody = String.format("{\"id\": %d, \"first_name\": \"%s\", \"other_columns\": \"%s\"}", id, firstName, otherColumns);

                // Realizar la solicitud POST a la API de Clientify
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(clientifyApiUrl + "endpoint"))
                        .header("Content-Type", "application/json")
                        .header("Authorization", "Bearer " + apiKey)
                        .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                        .build();

                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

                // Verificar la respuesta de la API
                if (response.statusCode() == 200) {
                    System.out.println("Datos para " + firstName + " enviados correctamente.");
                } else {
                    System.err.println("Error al enviar datos para " + firstName + " - Código de estado: " + response.statusCode());
                }
            }

        } catch (SQLException | InterruptedException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
