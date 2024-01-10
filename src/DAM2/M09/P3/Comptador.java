package DAM2.M09.P3;

public class Comptador implements Runnable {
    private int inici;
    private int fi;

    public Comptador(int inici, int fi) {
        if (inici > fi) {
            this.inici = fi-1;
        } else {
            this.inici = inici;
        }
        this.fi = fi;
    }
    public int getinici() {
        return inici;
    }

    public void setinici(int inici) {
        this.inici = inici;
    }

    public int getFi() {
        return fi;
    }

    public void setFi(int fi) {
        this.fi = fi;
    }

    public void run() {
        int index = getinici();
        while (index <= getFi()) {
            System.out.println(Thread.currentThread().getName()+": "+index);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("An error has been occurred trying to sleep the Thread.");
            }
            index++;
        }
    }
}
