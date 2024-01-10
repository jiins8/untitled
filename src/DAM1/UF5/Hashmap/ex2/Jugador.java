package DAM1.UF5.Hashmap.ex2;

public class Jugador {
    private String nom;
    private int edat;
    private String posicio;

    public Jugador(String nom, int edat, String posicio) {
        this.nom = nom;
        this.edat = edat;
        this.posicio = posicio;
    }

    public Jugador() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public String getPosicio() {
        return posicio;
    }

    public void setPosicio(String posicio) {
        this.posicio = posicio;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nom='" + nom + '\'' +
                ", edat=" + edat +
                ", posicio='" + posicio + '\'' +
                '}';
    }
}
