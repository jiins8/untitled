package DAM2.M06.UF1.ExamenAnyPassat;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Carta {
    public static List<String> idiomes() {
    List<String> idiomes = new ArrayList<>();

    try {
        // Obtenir el directori actual
        Path directoriActual = Paths.get("pizzeria");

        // Recórrer els directoris dins de "pizzeria"
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directoriActual)) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    idiomes.add(entry.getFileName().toString());
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return idiomes;
}

    public static List<Pizza> pizzes(Path pizzesXML) {
        List<Pizza> pizzes = new ArrayList<>();

        try {
            // Crear un objecte DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Crear un objecte DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parsejar el fitxer XML i obtenir l'objecte Document
            Document document = builder.parse(pizzesXML.toFile());

            // Obtindre la llista d'elements pizza
            NodeList pizzaNodes = document.getElementsByTagName("pizza");

            // Recórrer la llista d'elements pizza i afegir-los a la llista de Pizzes
            for (int i = 0; i < pizzaNodes.getLength(); i++) {
                Node pizzaNode = pizzaNodes.item(i);
                if (pizzaNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element pizzaElement = (Element) pizzaNode;

                    // Crear un objecte Pizza i afegir-lo a la llista
                    Pizza pizza = new Pizza();
                    pizza.setNom(pizzaElement.getAttribute("nom"));
                    pizza.setPreu(Double.parseDouble(pizzaElement.getAttribute("preu")));

                    // Obtindre la llista d'ingredients
                    NodeList ingredientsNodes = pizzaElement.getElementsByTagName("ingredient");
                    List<String> ingredientsList = new ArrayList<>();
                    for (int j = 0; j < ingredientsNodes.getLength(); j++) {
                        ingredientsList.add(ingredientsNodes.item(j).getTextContent());
                    }
                    pizza.setIngredients(ingredientsList);

                    pizzes.add(pizza);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pizzes;
    }

    public static void main(String[] args) {
        // Prova del mètode idiomes
        List<String> idiomes = idiomes();

        if (!idiomes.isEmpty()) {
            System.out.println("Idiomes disponibles a la carta:");
            for (String idioma : idiomes) {
                System.out.println(idioma);
            }
        } else {
            System.out.println("No s'han trobat idiomes a la carta.");
        }

        // Prova del mètode pizzes
        Path pizzesXML = Paths.get("pizzeria/catala/pizzes.xml"); // Ajusta el path segons el teu directori
        List<Pizza> pizzesList = pizzes(pizzesXML);

        if (!pizzesList.isEmpty()) {
            System.out.println("\nPizzes disponibles a la carta:");
            for (Pizza pizza : pizzesList) {
                System.out.println(pizza);
            }
        } else {
            System.out.println("No s'han trobat pizzes a la carta.");
        }
    }


//ANOTHER WAY OF DOING IT USING FILES:

/*
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

public class Carta {

    public static List<String> idiomes() {
        try {
            // Obtenir el directori actual
            Path directoriActual = Paths.get("pizzeria");

            // Recórrer els directoris dins de "pizzeria"
            return Files.list(directoriActual)
                    .filter(Files::isDirectory)
                    .map(path -> path.getFileName().toString())
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
            return null; // or handle the exception as needed
        }
    }

    public static void main(String[] args) {
        // Prova del mètode idiomes
        List<String> idiomes = idiomes();

        if (idiomes != null && !idiomes.isEmpty()) {
            System.out.println("Idiomes disponibles a la carta:");
            for (String idioma : idiomes) {
                System.out.println(idioma);
            }
        } else {
            System.out.println("No s'han trobat idiomes a la carta.");
        }
    }
}

 */
}
