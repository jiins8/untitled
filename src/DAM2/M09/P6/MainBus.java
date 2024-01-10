package DAM2.M09.P6;

public class MainBus {
    public static void main(String[] args) {
        Bus bus = new Bus();
        for (int i = 0; i < 10; i++) {
            Passatger passatger = new Passatger();
            passatger.setBus(bus);
            new Thread(passatger).start();


        }
    }
}
