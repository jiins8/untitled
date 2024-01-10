package DAM2.M09.P3;

public class ComptadorMain {
    public static void main(String[] args) {
        Comptador comptador1 = new Comptador(10, 20);
        Comptador comptador2 = new Comptador(20, 30);
        Comptador comptador3 = new Comptador(30, 40);

        Thread comptador1Thread = new Thread(comptador1);
        Thread comptador2Thread = new Thread(comptador2);
        Thread comptador3Thread = new Thread(comptador3);

        comptador1Thread.start();
        comptador2Thread.start();
        comptador3Thread.start();
    }
}
