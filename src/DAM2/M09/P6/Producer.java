package DAM2.M09.P6;

public class Producer implements Runnable{
    private static int counter = 0;

    private int num = 0;
    private SynchStack stack = new SynchStack();

    public Producer(){
        this.num = counter++;
    }

    public void setStack(SynchStack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        char c;
        for(int i=0; i<200; i++){
            //Calculem un caràcter a l'atzar
            c= (char) ((Math.random() * 26) + 'A');
            System.out.println("Producer " + num + ": " + c);
            try {
                Thread.sleep((int) (Math.random() * 300));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
