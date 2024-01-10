package DAM2.M09.P5;

public class ConsumidorPila implements Runnable {
    private MyStack pila;

    public MyStack getPila() {
        return pila;
    }

    public void setPila(MyStack pila) {
        this.pila = pila;
    }

    @Override
    public void run() {
        while (true) {
            this.pila.pop();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
