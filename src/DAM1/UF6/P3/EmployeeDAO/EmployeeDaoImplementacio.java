package DAM1.UF6.P3.EmployeeDAO;

import DAM1.UF6.P3.AlbumDAO.Connexio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImplementacio implements EmployeeDao {
    static Connection con = Connexio.getConnection();

    @Override
    public int create(Employee employee) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO Employee(LastName, FirstName, Title, ReportsTo, BirthDate, HireDate," +
                " Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, employee.getLastName());
        ps.setString(2, employee.getFirstName());
        ps.setString(3, employee.getTitle());
        ps.setInt(4, employee.getReportsTo());
        ps.setDate(5, java.sql.Date.valueOf(employee.getBirthdate().atStartOfDay().toLocalDate()));
        ps.setDate(6, java.sql.Date.valueOf(employee.getHireDate().atStartOfDay().toLocalDate()));
        ps.setString(7, employee.getAddress());
        ps.setString(8, employee.getCity());
        ps.setString(9, employee.getState());
        ps.setString(10, employee.getCountry());
        ps.setString(11, employee.getPostalCode());
        ps.setString(12, employee.getPhone());
        ps.setString(13, employee.getFax());
        ps.setString(14, employee.getEmail());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        int n = rs.getInt(1);
        return n;
    }

    @Override
    public Employee read(int idEmployee) throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM Employee WHERE  EmployeeId = ?");
        ps.setInt(1, idEmployee);

        Employee employee = new Employee();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            employee.setEmployeeId(rs.getInt("EmployeeId"));
            employee.setLastName(rs.getString("LastName"));
            employee.setFirstName(rs.getString("FirstName"));
            employee.setTitle(rs.getString("Title"));
            employee.setBirthdate(rs.getDate("BirthDate").toLocalDate());
            employee.setHireDate(rs.getDate("HireDate").toLocalDate());
            employee.setAddress(rs.getString("Address"));
            employee.setCity(rs.getString("City"));
            employee.setState(rs.getString("State"));
            employee.setCountry(rs.getString("Country"));
            employee.setPostalCode(rs.getString("PostalCode"));
            employee.setPhone(rs.getString("Phone"));
            employee.setFax(rs.getString("Fax"));
            employee.setEmail(rs.getString("Email"));

        }
        if (check == true) {
            return employee;
        } else return null;
    }

    @Override
    public void update(Employee employee) throws SQLException {
        PreparedStatement ps = con.prepareStatement("UPDATE Employee SET LastName =?, FirstName=?, Title=?, ReportsTo=?, BirthDate=?, HireDate=?, Address=?, City =?, State=?, Country=?, PostalCode=?, Phone=?, Fax=?, Email=? WHERE EmployeeId =?");
        ps.setString(1, employee.getLastName());
        ps.setString(2, employee.getFirstName());
        ps.setString(3, employee.getTitle());
        ps.setInt(4, employee.getReportsTo());
        ps.setDate(5, java.sql.Date.valueOf(employee.getBirthdate().atStartOfDay().toLocalDate()));
        ps.setDate(6, java.sql.Date.valueOf(employee.getHireDate().atStartOfDay().toLocalDate()));
        ps.setString(7, employee.getAddress());
        ps.setString(8, employee.getCity());
        ps.setString(9, employee.getState());
        ps.setString(10, employee.getCountry());
        ps.setString(11, employee.getPostalCode());
        ps.setString(12, employee.getPhone());
        ps.setString(13, employee.getFax());
        ps.setString(14, employee.getEmail());
        ps.setInt(15, employee.getEmployeeId());
        ps.executeUpdate();
    }

    @Override
    public void delete(int idEmployee) throws SQLException {
        PreparedStatement ps = con.prepareStatement("DELETE FROM Employee WHERE EmployeeId =?");
        ps.setInt(1, idEmployee);
        ps.executeUpdate();

    }

    @Override
    public List<Employee> getEmployee() throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM Employee");
        ResultSet rs = ps.executeQuery();
        List<Employee> ls = new ArrayList<>();

        while (rs.next()) {
            Employee employee = new Employee();
            employee.setEmployeeId(rs.getInt("EmployeeId"));
            employee.setLastName(rs.getString("LastName"));
            employee.setFirstName(rs.getString("FirstName"));
            employee.setTitle(rs.getString("Title"));
            employee.setBirthdate(rs.getDate("BirthDate").toLocalDate());
            employee.setHireDate(rs.getDate("HireDate").toLocalDate());
            employee.setAddress(rs.getString("Address"));
            employee.setCity(rs.getString("City"));
            employee.setState(rs.getString("State"));
            employee.setCountry(rs.getString("Country"));
            employee.setPostalCode(rs.getString("PostalCode"));
            employee.setPhone(rs.getString("Phone"));
            employee.setFax(rs.getString("Fax"));
            employee.setEmail(rs.getString("Email"));
            ls.add(employee);
        }
        return ls;
    }
}
