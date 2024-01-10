package DAM2.M06.UF1.ExamenAnyPassat;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Comanda {public static double calculaCaixa(Path comandesXML) {
    double caixa = 0.0;

    try {
        // Crear un objecte DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Crear un objecte DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parsejar el fitxer XML i obtenir l'objecte Document
        Document document = builder.parse(comandesXML.toFile());

        // Obtindre la llista d'elements total dins de comandes
        NodeList totalNodes = document.getElementsByTagName("total");

        // Sumar tots els totals
        for (int i = 0; i < totalNodes.getLength(); i++) {
            Node totalNode = totalNodes.item(i);
            if (totalNode.getNodeType() == Node.ELEMENT_NODE) {
                caixa += Double.parseDouble(totalNode.getTextContent());
            }
        }

        // Afegir el valor de la caixa al fitxer si encara no existeix
        NodeList caixaNodes = document.getElementsByTagName("caixa");
        if (caixaNodes.getLength() == 0) {
            Element comandesElement = (Element) document.getElementsByTagName("comandes").item(0);
            Element caixaElement = document.createElement("caixa");
            caixaElement.appendChild(document.createTextNode(String.valueOf(caixa)));
            comandesElement.appendChild(caixaElement);

            // Actualitzar el fitxer amb el nou node "caixa"
            Files.write(comandesXML, documentToString(document).getBytes());
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return caixa;
}

    private static String documentToString(Document document) {
        // Converteix l'objecte Document a una cadena de text XML
        try {
            // Crear un objecte DOMSource
            DOMSource domSource = new DOMSource(document);

            // Crear un objecte StringWriter
            StringWriter writer = new StringWriter();

            // Crear un objecte StreamResult amb el StringWriter
            StreamResult result = new StreamResult(writer);

            // Crear un objecte TransformerFactory
            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            // Crear un objecte Transformer
            Transformer transformer = transformerFactory.newTransformer();

            // Transformar DOMSource a StreamResult (escriure a StringWriter)
            transformer.transform(domSource, result);

            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    public static void main(String[] args) {
        // Prova del mètode calculaCaixa
        Path comandesXML = Paths.get("pizzeria/comandes.xml"); // Ajusta la ruta segons el teu directori
        double totalCaixa = calculaCaixa(comandesXML);
        System.out.println("La caixa total és: " + totalCaixa);
    }
}
