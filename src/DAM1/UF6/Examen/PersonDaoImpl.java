package DAM1.UF6.Examen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDaoImpl implements PersonDao{
    static Connection con = Connexio.getConnection();
    @Override
    public Person read(int personId) throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM people where id =?");
        ps.setInt(1, personId);
        Person person = new Person();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()){
            check = true;
            person.setIdPerson(rs.getInt("id"));
            person.setNom(rs.getString("name"));
            person.setBirth(rs.getInt("birth"));
        }
        if (check = true){
            return person;
        }
        else return null;
    }
}
