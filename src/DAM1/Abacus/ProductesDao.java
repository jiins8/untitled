package DAM1.Abacus;

import java.sql.SQLException;
import java.util.List;

public interface ProductesDao {

    public int create(Productos productos) throws SQLException;
    public Productos read(int idAlbum) throws SQLException;
    public void update(Productos productos) throws SQLException;
    public void delete(int idAlbum) throws SQLException;
    public List<Productos> getProductos() throws SQLException;
}
