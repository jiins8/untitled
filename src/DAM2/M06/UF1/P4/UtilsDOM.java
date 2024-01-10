package DAM2.M06.UF1.P4;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UtilsDOM {
    public Document obrirXMLAmbDOM(File fitxer) {
        Document doc = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(fitxer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;
    }

    public String recorrerDOM(Document doc) {
        StringBuilder sortida = new StringBuilder();
        Node arrel = doc.getFirstChild();

        // Print the heading
        sortida.append("Llibres:\nLlibres de la biblioteca\n");

        NodeList nodelist = arrel.getChildNodes();

        // Processar els nodes fills
        Node node;
        for (int i = 0; i < nodelist.getLength(); i++) {
            node = nodelist.item(i);
            // Exclude the specific text content "Llibres de la biblioteca"
            if (node.getNodeType() != Node.TEXT_NODE || !node.getNodeValue().trim().equals("Llibres de la biblioteca")) {
                // Crida al nou mètode recorrerNode per processar tot el contingut del node
                sortida.append(recorrerNode(node));
            }
        }

        return sortida.toString();
    }
    private String recorrerNode(Node node) {
        StringBuilder sortida = new StringBuilder();

        if (node.getNodeType() == Node.ELEMENT_NODE) {
            sortida.append(node.getNodeName()).append(":").append("\n");

            NamedNodeMap attrs = node.getAttributes();
            Node attr;

            for (int i = 0; i < attrs.getLength(); i++) {
                attr = attrs.item(i);
                sortida.append(attr.getNodeName()).append(": ").append(attr.getNodeValue()).append("\n");

                try {
                    if ("publicat_el".equals(attr.getNodeName())) {
                        int anyPublicacio = Integer.parseInt(attr.getNodeValue());
                        int edatLlibre = LocalDate.now().getYear() - anyPublicacio;
                        sortida.append("Edat llibre: ").append(edatLlibre).append("\n");
                    }
                } catch (NumberFormatException e) {
                    // Handle the exception if needed
                }
            }

            NodeList nodeFills = node.getChildNodes();
            for (int i = 0; i < nodeFills.getLength(); i++) {
                Node fill = nodeFills.item(i);
                // Crida recursiva per processar tot el contingut del node fill
                sortida.append(recorrerNode(fill));
            }
            sortida.append("\n");
        } else if (node.getNodeType() == Node.TEXT_NODE) {
            sortida.append(node.getNodeValue().trim().replaceAll("\n", ""));
        }
        return sortida.toString();
    }
    public List<String> getTotsElsTitols(Document doc) {
        List<String> titols = new ArrayList<>();

        NodeList nodesTitols = doc.getElementsByTagName("Titol");

        for (int i = 0; i < nodesTitols.getLength(); i++) {
            titols.add(nodesTitols.item(i).getChildNodes().item(0).getNodeValue());
        }

        titols.sort(Comparator.naturalOrder());

        return titols;
    }
}