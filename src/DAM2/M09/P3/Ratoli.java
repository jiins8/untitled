package DAM2.M09.P3;

import java.util.ArrayList;

public class Ratoli extends Thread {
    private String nom;
    private int numSegonsMenjar;

    public Ratoli(String nom) {
        this.nom = nom;
    }

    public int getNumSegonsMenjar() {
        return numSegonsMenjar;
    }

    public void setNumSegonsMenjar(int numSegonsMenjar) {
        this.numSegonsMenjar = numSegonsMenjar;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void menja(){
        System.out.println("El ratolí " + nom + " ha començat a menjar");
        System.out.println("El ratolí " + nom + " està menjant");
        System.out.println("El ratolí " + nom + " ha acabat de menjar");
    }
    @Override
    public void run(){
        this.menja();
    }

    public static void main(String[] args) {
    }
}
