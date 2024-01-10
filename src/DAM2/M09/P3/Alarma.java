package DAM2.M09.P3;

import java.time.LocalDateTime;

public class Alarma implements Runnable {

    private LocalDateTime hora;
    private String recordatori;

    public Alarma(int hora, int minut, String recordatori) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        this.hora = LocalDateTime.of(currentDateTime.getYear(), currentDateTime.getMonth(), currentDateTime.getDayOfMonth(), hora, minut);
        this.recordatori = recordatori;
    }
    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(int hora, int minut) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        this.hora = LocalDateTime.of(currentDateTime.getYear(), currentDateTime.getMonth(), currentDateTime.getDayOfMonth(), hora, minut);
    }

    public String getRecordatori() {
        return recordatori;
    }

    public void setRecordatori(String recordatori) {
        this.recordatori = recordatori;
    }
    @Override
    public void run() {
        while (true) {
            LocalDateTime currentDateTime = LocalDateTime.now();
            if (currentDateTime.isAfter(getHora())) {
                System.out.println(getHora().toString().replace("-","/").replace("T", " ")+" - Recordatori: "+getRecordatori());
                break;
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("An error has been occurred trying to sleep the Thread.");
                }
            }
        }
    }
}
