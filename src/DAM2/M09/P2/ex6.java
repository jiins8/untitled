package DAM2.M09.P2;

import java.io.IOException;

public class ex6 {
    public static void main(String[] args) {

        String comanda1 = "notepad";
        try{
            Process process = Runtime.getRuntime().exec(comanda1);
            Thread.sleep(2000);
            //process.destroy();

            int codiFi = process.waitFor();
            System.out.println("Proces finalitzat: "+ process.pid() + " Info: " + process.info() + " Exit value: " + process.exitValue());

        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
