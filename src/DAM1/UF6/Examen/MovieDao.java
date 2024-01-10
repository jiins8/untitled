package DAM1.UF6.Examen;

import java.sql.SQLException;

public interface MovieDao {
    public Movie read (int movieId) throws SQLException;
}
