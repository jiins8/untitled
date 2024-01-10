package DAM2.M09.P6;

public class Bus {
    private final int numSeients = 6;
    private int getNumSeientsLliures = numSeients;

    public void pujar() {
        if (!estaPle())
            this.getNumSeientsLliures--;

    }

    public void baixar() {
        if (this.numSeients != 0)
            this.getNumSeientsLliures++;
    }

    public boolean estaPle() {
        return this.getNumSeientsLliures == 0;
    }
}
