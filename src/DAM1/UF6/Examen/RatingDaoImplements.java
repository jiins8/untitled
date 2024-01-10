package DAM1.UF6.Examen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RatingDaoImplements implements RatingDao{
    static Connection con = Connexio.getConnection();

    @Override
    public Rating read(Movie movie) throws SQLException {
        Scanner sc = new Scanner(System.in);
        PreparedStatement ps = con.prepareStatement("SELECT * FROM ratings where movie_id =?");
        ps.setInt(1, movie.setId(sc.nextInt()));
        Rating rating = new Rating();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()){
            check = true;
            rating.setMovieId(rs.getInt("movie_id"));
            rating.setRating(rs.getInt("rating"));
            rating.setVotes(rs.getInt("votes"));
        }
        if (check == true){
            return rating;
        }
        else return null;
    }


}
