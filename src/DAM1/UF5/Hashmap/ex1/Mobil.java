package DAM1.UF5.Hashmap.ex1;

public class Mobil {
    private String marca;
    private String model;
    private int numero;

    public Mobil(String marca, String model, int numero) {
        this.marca = marca;
        this.model = model;
        this.numero = numero;
    }

    public Mobil() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Mobil{" +
                "marca='" + marca + '\'' +
                ", model=" + model +
                ", numero=" + numero +
                '}';
    }
}
