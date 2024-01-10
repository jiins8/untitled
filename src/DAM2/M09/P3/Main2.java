package DAM2.M09.P3;

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Thread.State.values()));

        Ratoli mickey = new Ratoli("Mickey");
        Thread tMickey = new Thread(mickey);
        System.out.println(tMickey.getState());
        tMickey.start();
        System.out.println(tMickey.getState());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
    }
        System.out.println(tMickey.getState());
        System.out.println(tMickey.isAlive());

        System.out.println(tMickey.getId());
        System.out.println(tMickey.getName());
        System.out.println(tMickey.getPriority());
        tMickey.setName("Thread Mickey");
        System.out.println(tMickey.getName());
    }
}
