package DAM2.M06.UF1.ExamenAnyPassat;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String nom;
    private double preu;
    private List<String> ingredients = new ArrayList<>();

    public Pizza() {}

    public Pizza(String nom, double preu, List<String> ingredients) {
        this.nom = nom;
        this.preu = preu;
        this.ingredients = ingredients;
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

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "nom='" + nom + '\'' +
                ", preu=" + preu +
                ", ingredients=" + ingredients +
                '}';
    }
}
