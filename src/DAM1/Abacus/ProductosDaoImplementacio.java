package DAM1.Abacus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductosDaoImplementacio implements ProductesDao {

    static Connection con = Connexio.getConnection();

    @Override
    public int create(Productos productos) throws SQLException {
        String query = "insert into Productos(id_categoria, nombre, precio, stock) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, productos.getIdCategoria());
        ps.setString(2, productos.getNombre());
        ps.setDouble(3, productos.getPrecio());
        ps.setInt(4, productos.getStock());

        ps.executeUpdate();
        // Obtenim claus autogenerades
        ResultSet rs = ps.getGeneratedKeys();
        rs.next(); // Sabem que només n'hi ha una
        int n = rs.getInt(1);
        return n;
    }

    @Override
    public Productos read(int id)
            throws SQLException {

        String query = "select * from Productos where id= ?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);
        Productos productos = new Productos();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            productos.setIdProducto(rs.getInt("id"));
            productos.setIdCategoria(rs.getInt("id_categoria"));
            productos.setNombre(rs.getString("nombre"));
            productos.setPrecio(rs.getDouble("precio"));
            productos.setStock(rs.getInt("stock"));
        }

        if (check == true) {
            return productos;
        } else
            return null;
    }

    @Override
    public void update(Productos productos) throws SQLException {
        String query = "update Productos set id_categoria = ?, nombre = ?, precio = ?, stock = ? where id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, productos.getIdCategoria());
        ps.setString(2, productos.getNombre());
        ps.setDouble(3, productos.getPrecio());
        ps.setInt(4, productos.getStock());
        ps.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "delete from Productos where id =?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public List<Productos> getProductos() throws SQLException {
        String query = "select * from Productos";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Productos> ls = new ArrayList();

        while (rs.next()) {
            Productos productos = new Productos();
            productos.setIdProducto(rs.getInt("id"));
            productos.setIdCategoria(rs.getInt("id_categoria"));
            productos.setNombre(rs.getString("nombre"));
            productos.setPrecio((rs.getDouble("precio")));
            productos.setStock(rs.getInt("stock"));
            ls.add(productos);
        }
        return ls;
    }

}