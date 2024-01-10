package DAM2.M09.P3;

public class Main {
    public static void main(String[] args) {
        Ratoli mickey = new Ratoli("Mickey");
        Ratoli minnie = new Ratoli("Minnie");
        Ratoli jerry = new Ratoli("Jerry");

        mickey.setNumSegonsMenjar(3);
        minnie.setNumSegonsMenjar(5);
        jerry.setNumSegonsMenjar(2);

        mickey.start();
        minnie.start();
        jerry.start();
    }
}
