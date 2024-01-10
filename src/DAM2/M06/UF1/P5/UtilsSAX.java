package DAM2.M06.UF1.P5;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class UtilsSAX {
    public String obrirITractarXMLAmbSAX(File fitxer, MySAXHandler handler){
        String resultat = "";
        //Obtenció de la factoria de parsers SAX
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            //Creació d'un parser SAX
            SAXParser parser = factory.newSAXParser();

            //Parsejar el document XML i tractar-ho amb el manegador
            parser.parse(fitxer, handler);

            //Obtenir el resultat del tractament fet pel manegador
            resultat = handler.getResultat();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return resultat;
    }

    public void parseXMLWithHandler(File file, MySAXHandler handler) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(file, handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}