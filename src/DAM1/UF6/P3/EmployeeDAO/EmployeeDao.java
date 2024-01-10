package DAM1.UF6.P3.EmployeeDAO;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    public int create(Employee employee) throws SQLException;
    public Employee read(int idEmployee) throws SQLException;
    public void update(Employee employee) throws SQLException;
    public void delete(int idEmployee) throws SQLException;
    public List<Employee> getEmployee() throws SQLException;
}
