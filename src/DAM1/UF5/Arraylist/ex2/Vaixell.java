package DAM1.UF5.Arraylist.ex2;

public class Vaixell {
    private String nom;
    private double preu;
    private int edat;

    public Vaixell(String nom, double preu, int edat) {
        this.nom = nom;
        this.preu = preu;
        this.edat = edat;
    }

    public Vaixell() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    @Override
    public String toString() {
        return "Vaixell{" +
                "nom='" + nom + '\'' +
                ", preu=" + preu +
                ", edat=" + edat +
                '}';
    }
}

