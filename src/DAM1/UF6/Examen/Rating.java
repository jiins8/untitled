package DAM1.UF6.Examen;

public class Rating {
    private int movieId;
    private int rating;
    private int votes;

    public Rating(int movieId, int rating, int votes) {
        this.movieId = movieId;
        this.rating = rating;
        this.votes = votes;
    }

    public Rating() {
    }

    public int getRating() {
        return rating;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "rating=" + rating +
                ", votes=" + votes +
                '}' + "\n";
    }
}
