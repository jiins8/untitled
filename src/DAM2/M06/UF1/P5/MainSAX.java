package DAM2.M06.UF1.P5;

import java.io.File;

public class MainSAX {
    public static void main(String[] args) {

        File xmlFile = new File("LlibresXML.xml");

        UtilsSAX utilsSAX = new UtilsSAX();
        MySAXHandler titlesHandler = new MySAXHandler();
        utilsSAX.parseXMLWithHandler(xmlFile, titlesHandler);
        String titlesResult = titlesHandler.getResultat();
        System.out.println("Method 1 Result:");
        System.out.println(titlesResult);

        MySAXHandler countHandler = new MySAXHandler();
        utilsSAX.parseXMLWithHandler(xmlFile, countHandler);
        int bookCount = countHandler.getCount();
        System.out.println("Method 2 Result - Number of Books: " + bookCount);

        String autorCerca = "Gogol"; // Replace with the author you want to search for
        MySAXHandler searchByAuthorHandler = new MySAXHandler(autorCerca);
        utilsSAX.parseXMLWithHandler(xmlFile, searchByAuthorHandler);
        String searchByAuthorResult = searchByAuthorHandler.getResultat();
        System.out.println("Method 3 Result - Search by Author:");
        System.out.println(searchByAuthorResult);
    }
}