package DAM2.M09.P5;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        MyStack pila = new MyStack();

        ProductorPila productorPila = new ProductorPila();
        productorPila.setPila(pila);

        ConsumidorPila consumidorPila = new ConsumidorPila();
        consumidorPila.setPila(pila);

        Thread tProductor = new Thread(productorPila);
        Thread tConsumidor = new Thread(consumidorPila);
        tProductor.start();
        tConsumidor.start();

        while (true){
            Thread.sleep(1000);
            System.out.println(pila);
        }
    }


}
