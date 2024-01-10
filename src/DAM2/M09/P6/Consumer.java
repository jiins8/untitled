package DAM2.M09.P6;

public class Consumer implements Runnable{
    private static int counter = 0;

    private int num = 0;
    private SynchStack stack = new SynchStack();

    public Consumer(){
        this.num = counter++;
    }

    public void setStack(SynchStack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        char c;
        for(int i=0; i<200; i++){
            //Treiem un caràcter de la pila
            c= this.stack.pop();
            System.out.println("Consumer " + num + ": " + c);
            try {
                Thread.sleep((int) (Math.random() * 300));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
