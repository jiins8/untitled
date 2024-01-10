package DAM2.M06.UF1.P3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Alumne {
    private String nom;
    private String cognom;
    private String cicle;
    private List<String> moduls = new ArrayList<>();
    private float nota;

    public Alumne(String nom, String cognom, String cicle, List<String> moduls, float nota) {
        this.nom = nom;
        this.cognom = cognom;
        this.cicle = cicle;
        this.moduls = moduls;
        this.nota = nota;
    }


    public Alumne() {
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getCicle() {
        return cicle;
    }

    public void setCicle(String cicle) {
        this.cicle = cicle;
    }

    public List<String> getModuls() {
        return moduls;
    }

    public void setModuls(List<String> moduls) {
        this.moduls = moduls;
    }

    @Override
    public String toString() {
        return "alumne{" +
                "nom='" + nom + '\'' +
                ", cognom='" + cognom + '\'' +
                ", cicle='" + cicle + '\'' +
                ", moduls=" + moduls +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumne alumne = (Alumne) o;
        return nom.equalsIgnoreCase(alumne.nom) && cognom.equalsIgnoreCase(alumne.cognom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, cognom);
    }
}

