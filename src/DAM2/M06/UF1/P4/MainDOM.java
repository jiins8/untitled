package DAM2.M06.UF1.P4;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainDOM {
    public static void main(String[] args) {
        MainDOM m = new MainDOM();

        String nomFitxerXML = "LlibresXML_AmbIDS.xml";
        File fitxerXML = new File(nomFitxerXML);
        UtilsDOM utilsDOM = new UtilsDOM();

        Document doc = utilsDOM.obrirXMLAmbDOM(fitxerXML);
        String sortida = utilsDOM.recorrerDOM(doc);
        System.out.println(sortida);

        System.out.println(utilsDOM.getTotsElsTitols(doc));

        m.addNewBook(doc, "Bleach", "Tite Kubo", 2004, true);
        m.saveXML(doc, "LlibresXML_NOU.xml");
        System.out.println(m.maxID(doc));
    }
    public void addNewBook(Document document, String title, String author, int publishYear, boolean includeID) {
        System.out.println("Creating new book...");
        Node bookNode = document.createElement("Llibre");
        Node bookTitle = document.createElement("Titol");
        Node bookAuthor = document.createElement("Autor");
        Node bookTitleText = document.createTextNode(title);
        Node bookAuthorText = document.createTextNode(author);
        bookTitle.appendChild(bookTitleText);
        bookAuthor.appendChild(bookAuthorText);

        ((Element) bookNode).setAttribute("publicat_el", String.valueOf(publishYear));
        if (includeID) {
            ((Element) bookNode).setAttribute("id", String.valueOf(maxID(document) + 1));
        }
        bookNode.appendChild(bookTitle);
        bookNode.appendChild(bookAuthor);

        document.getFirstChild().appendChild(bookNode);
        System.out.println("New book created successfully.");
    }

    public void saveXML(Document document, String XMLFileName) {
        Source source = new DOMSource(document);
        try {
            System.out.println("Saving DOM into XML file...");
            Result result = new StreamResult(Files.newBufferedWriter(Path.of(XMLFileName)));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            System.out.println("DOM saved into XML successfully.");
        } catch (IOException | TransformerException e) {
            System.out.println("An error has been occurred trying to save the XML file.");
        }
    }
    public int maxID(Document doc) {
        NodeList llibres = doc.getElementsByTagName("Llibre");
        int max = -1;
        for (int i = 0; i < llibres.getLength(); i++) {
            int id = Integer.parseInt(
                    llibres.item(i).getAttributes().getNamedItem("id").getNodeValue()
            );

            max = Math.max(id, max);
        }
        return max;
    }
}