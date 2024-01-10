package DAM1.UF5.Hashset.ex1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Loteria {
    HashSet<Integer> sac = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Loteria loteria = new Loteria();
        loteria.boles();

        Jugador jugador1 = new Jugador("X6311993B", loteria.generarBoleto());
        Jugador jugador2 = new Jugador("48784877A", loteria.generarBoleto());
        Jugador jugador3 = new Jugador("55315115T", loteria.generarBoleto());
        Jugador jugador4 = new Jugador("15881353R", loteria.generarBoleto());


        ArrayList<Jugador> jugadors = new ArrayList<>();
        jugadors.add(jugador1);
        jugadors.add(jugador2);
        jugadors.add(jugador3);
        jugadors.add(jugador4);

        for (Jugador jugador: jugadors) {
            System.out.println(jugador);
        }
    }
    public void boles(){
        for (int i = 0; i <= 100; i++) {
            sac.add(i);
        }
    }
    public HashSet<Integer> generarBoleto(){
        HashSet<Integer>boleto = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            int num = (int) (Math.random()* 100);
            boleto.add(num);
        }
        return boleto;
    }
    public void guanyador(){



    }
}
