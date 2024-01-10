package DAM2.M09.P2;

import java.io.*;

public class Lector {
    public static void main(String[] args) {
        String JavaCommand = "/Users/jinsh/.jdks/openjdk-19.0.1/bin/java.exe";
        String param = "";

        ProcessBuilder processBuilder = new ProcessBuilder(JavaCommand, param);
        try {
            Process processEscriptor = processBuilder.start();
            System.out.println(processEscriptor.pid());
            System.out.println(processEscriptor.info());

            //Escriure un numero a l'escriptor
            int numLinies = 6;
            OutputStream out = processEscriptor.getOutputStream();
            BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(out));
            bufOut.write("" + numLinies);
            bufOut.flush();
            bufOut.newLine();

            InputStream in = processEscriptor.getInputStream();
            BufferedReader bufIn= new BufferedReader(new InputStreamReader(in));
            String missatge = bufIn.readLine();
            System.out.println("L'escriptor diu: " + missatge);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
