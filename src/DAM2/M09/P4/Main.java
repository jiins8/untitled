package DAM2.M09.P4;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            public String nom = "Nom per defecte";
            @Override
            public void run() {
            nom = nom + ((int) (Math.random()*100));
                System.out.println("Hola " + nom);
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();

        //Variable static
        MyRunnable r1 = new MyRunnable();
        MyRunnable r2 = new MyRunnable();
        Thread t11 = new Thread(r1);
        Thread t22 = new Thread(r2);

        MyRunnable.nomStatic = "Nou nom";
        t11.start();
        t22.start();

        //Atribut en comu
        List<String> paraules = Arrays.asList("Hola1", "Hola2", "Hola3");
        r1.setParaules(paraules);
        r2.setParaules(paraules);

        Thread t111 = new Thread(r1);
        Thread t222 = new Thread(r2);
        t111.start();
        t222.start();

        //ex2
        Thread tFuncional = new Thread(() -> System.out.println("Holaaaaaaa"));
        tFuncional.start();

        //ex3

    }



}
