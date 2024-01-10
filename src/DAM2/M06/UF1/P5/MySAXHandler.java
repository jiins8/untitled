package DAM2.M06.UF1.P5;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class MySAXHandler extends DefaultHandler {
    private final StringBuilder resultat = new StringBuilder();
    private String etiqueta = "";

    private final ArrayList<String> llistaTitols = new ArrayList<>();
    private int count = 0;

    private String autorCerca;
    public MySAXHandler() {

    }
    public MySAXHandler(String autorCerca) {
        this.autorCerca = autorCerca;
    }

    public String getResultat() {
        return resultat.toString();
    }

    @Override
    public void startDocument() throws SAXException {
        resultat.append("Iniciant el tractament del document XML\n");
    }

    @Override
    public void endDocument() throws SAXException {
        resultat.append("Fi del tractament del document XML\n");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.etiqueta = qName;

        if ("Llibre".equalsIgnoreCase(qName)) {
            count++;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("Llibre".equalsIgnoreCase(qName)) {
            resultat.append("Llibre: id: ").append(count).append("\n");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String text = new String(ch, start, length);
        resultat.append(text.replaceAll("\n", "").trim());

        if ("Llibres".equalsIgnoreCase(this.etiqueta)) {
            resultat.append("\n");
        }

        if ("Titol".equalsIgnoreCase(this.etiqueta)) {
            llistaTitols.add(text.trim());
        }
    }

    public ArrayList<String> getTitols() {
        llistaTitols.sort(String::compareTo);
        return llistaTitols;
    }

    public int getCount() {
        return count;
    }
}