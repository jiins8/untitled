package DAM1.UF6.P1;

public class Genre {
    private int genreId;
    private String name;

    public Genre(int genreId, String name) {
        this.genreId = genreId;
        this.name = name;
    }

    public int getGenreId() {
        return genreId;
    }

    public String getName() {
        return name;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreId=" + genreId +
                ", name='" + name + '\'' +
                '}';
    }

}

