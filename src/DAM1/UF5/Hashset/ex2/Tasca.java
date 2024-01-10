package DAM1.UF5.Hashset.ex2;

public class Tasca {
    private String nom;
    private String descripcio;

    public Tasca(String nom, String descripcio) {
        this.nom = nom;
        this.descripcio = descripcio;
    }

    public Tasca() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    @Override
    public String toString() {
        return "Tasca{" +
                "nom='" + nom + '\'' +
                ", descripcio='" + descripcio + '\'' +
                '}';
    }
}
