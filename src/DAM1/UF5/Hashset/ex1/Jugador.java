package DAM1.UF5.Hashset.ex1;

import java.util.HashSet;

public class Jugador {
    private String dni;
    HashSet<Integer> boleto;

    public Jugador(String dni, HashSet<Integer> boleto) {
        this.dni = dni;
        this.boleto = boleto;
    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public HashSet<Integer> getBoleto() {
        return boleto;
    }

    public void setBoleto(HashSet<Integer> boleto) {
        this.boleto = boleto;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "dni='" + dni + '\'' +
                ", boleto=" + boleto +
                '}';
    }
}
