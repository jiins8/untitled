package DAM2.M06.UF1.ExamenAnyPassat;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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

    public static List<Pizza> cercarPizzaAmbIngredient(File pizzesXML, String ingredient) {
        List<Pizza> pizzasWithIngredient = new ArrayList<>();

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {
                boolean inPizza = false;
                boolean inIngredient = false;
                Pizza currentPizza = null;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes)
                        throws SAXException {
                    if (qName.equalsIgnoreCase("pizza")) {
                        inPizza = true;
                        currentPizza = new Pizza();
                    } else if (qName.equalsIgnoreCase("ingredient")) {
                        inIngredient = true;
                    }
                }

                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    if (inIngredient && inPizza) {
                        String currentIngredient = new String(ch, start, length).trim();
                        if (!currentIngredient.isEmpty()) {
                            currentPizza.getIngredients().add(currentIngredient);
                        }
                        inIngredient = false;
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("pizza")) {
                        inPizza = false;
                        if (currentPizza.getIngredients().contains(ingredient)) {
                            pizzasWithIngredient.add(currentPizza);
                        }
                    }
                }
            };
            saxParser.parse(pizzesXML, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return pizzasWithIngredient;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File pizzesXML = new File("pizzeria/catala/pizzes.xml"); // Ajusta la ruta segons el teu directori
        TreeSet<String> ingredientsSet = ingredientsAEscollir(pizzesXML);

        if (!ingredientsSet.isEmpty()) {
            System.out.println("Ingredients disponibles a triar:");
            for (String ingredient : ingredientsSet) {
                System.out.println(ingredient);
            }
        } else {
            System.out.println("No s'han trobat ingredients a triar.");
        }

        System.out.println("\nIndica un ingredient per a la cerca de pizzes");
        String ingredientToSearch = sc.nextLine(); // Ajusta l'ingredient que vols buscar
        List<Pizza> pizzasWithIngredient = cercarPizzaAmbIngredient(pizzesXML, ingredientToSearch);

        if (!pizzasWithIngredient.isEmpty()) {
            System.out.println("Pizzes amb l'ingredient '" + ingredientToSearch + "':");
            for (Pizza pizza : pizzasWithIngredient) {
                System.out.println(pizza);
            }
        } else {
            System.out.println("No s'han trobat pizzes amb l'ingredient '" + ingredientToSearch + "'.");
        }
    }
}
