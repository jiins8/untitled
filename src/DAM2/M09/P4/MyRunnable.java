package DAM2.M09.P4;

import java.util.ArrayList;
import java.util.List;

public class MyRunnable implements Runnable{
    public static String nomStatic = "Nom per defecte static";
    private List<String> paraules = new ArrayList<>();
    private boolean timeToStop = false;

    public static String getNomStatic() {
        return nomStatic;
    }

    public static void setNomStatic(String nomStatic) {
        MyRunnable.nomStatic = nomStatic;
    }

    public List<String> getParaules() {
        return paraules;
    }

    public void setParaules(List<String> paraules) {
        this.paraules = paraules;
    }

    @Override
    public void run() {
        System.out.println(nomStatic);
        System.out.println(paraules);
        while (!timeToStop){
            try {
                System.out.println("Sóc el thread "
                        + Thread.currentThread().getName());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopRunning(){
        timeToStop = true;

    }
}
