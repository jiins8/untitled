package DAM1.UF6.Examen;

import java.sql.SQLException;

public interface PersonDao {
    public Person read (int personId) throws SQLException;

}
