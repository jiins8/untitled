package DAM1.UF6.Examen;

import java.sql.SQLException;

public interface RatingDao {
    public Rating read (Movie movie) throws SQLException;
}
