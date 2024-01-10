package DAM1.UF6.Examen;

public class Person {
    private int idPerson;
    private String nom;
    private int birth;

    public Person(int idPerson, String nom, int birth) {
        this.idPerson = idPerson;
        this.nom = nom;
        this.birth = birth;
    }

    public Person() {
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idPerson=" + idPerson +
                ", nom='" + nom + '\'' +
                ", birth=" + birth +
                '}' + "\n";
    }
}

