package DAM1.UF6.Examen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieDaoImpl implements MovieDao{
    static Connection con = Connexio.getConnection();

    @Override
    public Movie read(int movieId) throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT movies.*, r.rating, r.votes, p.name,p.birth, s.person_id from movies join ratings r on movies.id = r.movie_id join directors d on movies.id = d.movie_id join people p on d.person_id = p.id join stars s on movies.id = s.movie_id WHERE movies.id = ?");
        ps.setInt(1, movieId);
        Movie movie = new Movie();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()){
            check = true;
            movie.setId(rs.getInt("id"));
            movie.setTitle(rs.getString("title"));
            movie.setYear(rs.getInt("year"));
            movie.setRating(rs.getInt("rating"));
            movie.setVotes(rs.getInt("votes"));
            movie.setDirector(rs.getString("name"));
            movie.setAnyNaixament(rs.getString("birth"));

        }
        if (check == true) {
            return movie;
        }
        else return null;
    }
}
