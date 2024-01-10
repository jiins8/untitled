package DAM2.M09.P6;

import java.util.Vector;

public class SynchStack {
    private Vector buffer = new Vector(400, 200);

    private int MAX_SIZE = 250;
    public synchronized void push (char c){
        this.notify();
        this.buffer.add(c);
    }


    public synchronized char pop() {
        char c;
        /*
        while (buffer.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
         */
        c = (Character) buffer.remove(buffer.size() - 1);
        System.out.printf("Tret element" + c + ". Num elements a la pila: " + buffer.size());
        return c;
    }

}
