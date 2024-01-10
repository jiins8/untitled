package DAM2.M06.UF1.P5.titles;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TitlesHandler extends DefaultHandler {
    private String currentNodeName;
    private final ArrayList<String> sortedBookTitles = new ArrayList<>();

    public ArrayList<String> getResult() {
        sortedBookTitles.removeAll(Arrays.asList("", null));
        sortedBookTitles.sort(Comparator.naturalOrder());
        return sortedBookTitles;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentNodeName = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentNodeName.equals("Titol")) {
            String bookTitle = new String(ch, start, length);
            sortedBookTitles.add(bookTitle.strip());
        }
    }
}

