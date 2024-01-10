package DAM1.UF6.Examen;

import java.util.ArrayList;

public class Movie {
    private int id;
    private String title;
    private int year;
    private int rating;
    private int votes;
    private String director;
    private String anyNaixament;
    private ArrayList<String > actor;

    public Movie(int id, String title, int year, int rating, int votes, String director, String anyNaixament, ArrayList<String> actor) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.votes = votes;
        this.director = director;
        this.anyNaixament = anyNaixament;
        this.actor = actor;
    }

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public ArrayList<String> getActor() {
        return actor;
    }

    public void setActor(ArrayList<String> actor) {
        this.actor = actor;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public String getAnyNaixament() {
        return anyNaixament;
    }

    public void setAnyNaixament(String anyNaixament) {
        this.anyNaixament = anyNaixament;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", votes=" + votes +
                ", director='" + director + '\'' +
                ", anyNaixament='" + anyNaixament + '\'' +
                ", actor=" + actor +
                '}' + "\n";
    }
}

