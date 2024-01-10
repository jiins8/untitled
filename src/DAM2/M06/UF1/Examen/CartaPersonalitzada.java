package DAM2.M06.UF1.Examen;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.TreeSet;

public class CartaPersonalitzada {

    public static TreeSet<String> ingredientsAEscollir(File pizzesXML) {
        TreeSet<String> ingredientsSet = new TreeSet<>();

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {
                boolean inIngredient = false;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes)
                        throws SAXException {
                    if (qName.equalsIgnoreCase("ingredient")) {
                        inIngredient = true;
                    }
                }

                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    if (inIngredient) {
                        String ingredient = new String(ch, start, length).trim();
                        if (!ingredient.isEmpty()) {
                            ingredientsSet.add(ingredient);
                        }
                        inIngredient = false;
                    }
                }
            };

            saxParser.parse(pizzesXML, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ingredientsSet;
    }



    public static void main(String[] args) {

        File pizzesXML = new File("pizzes.xml");
        TreeSet<String> ingredientsSet = ingredientsAEscollir(pizzesXML);

            System.out.println("INGREDIENTS ORDEANATS ALFABETICAMENT");
            for (String ingredient : ingredientsSet) {
                System.out.println(ingredient);
        }
    }
}
