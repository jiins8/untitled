package DAM2.M09.P6;

public class Passatger implements Runnable {
    private Bus bus;

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public void pujarAlBus() {
        synchronized (this.bus) {
            while (this.bus.estaPle()) {
                try {
                    this.bus.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            this.bus.pujar();
            System.out.println("El passatger " + Thread.currentThread().getName() + " puja al bus");
        }
    }

    public void baixarDelBus() {
        synchronized (this.bus) {
            this.bus.notify();
            this.bus.baixar();
            System.out.println("El passatge " + Thread.currentThread().getName() + " baixa del bus");
        }
    }

    @Override
    public void run() {
        while (true) {
            this.pujarAlBus();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.baixarDelBus();
        }
    }
}
