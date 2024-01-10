package DAM1.UF6.P3.EmployeeDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class MainEmployeeDAO {
    public void menu() {
        System.out.println("Diguis quina opció vols executar:\n"
                + "1) Llista els employees\n"
                + "2) Selecciona un employee\n"
                + "3) Introdueix un employee\n"
                + "4) Modifica un employee\n"
                + "5) Elimina un employee\n"
                + "0) Sortir\n"
        );
    }

    public static void main(String[] args) throws SQLException {
        Connection c = Connexio.getConnection();
        MainEmployeeDAO mainEmployeeDAO = new MainEmployeeDAO();
        EmployeeDao employeeDao = new EmployeeDaoImplementacio();
        mainEmployeeDAO.menu();
        Scanner sc = new Scanner(System.in);
        int opcio = sc.nextInt();
        sc.nextLine();

        while (opcio != 0) {
            switch (opcio) {
                case 1: {
                    System.out.println(employeeDao.getEmployee());
                    break;
                }
                case 2:{
                    System.out.println("Introdueix quin employee vols veure");
                    int idEmployee = sc.nextInt();
                    sc.nextLine();
                    System.out.println(employeeDao.read(idEmployee));
                    break;
                }
                case 3:{
                    System.out.println("Introdueix el cognom");
                    String lastName = sc.next();
                    System.out.println("Introdueix el nom");
                    String fistName = sc.next();
                    System.out.println("Introdueix el titol");
                    String title = sc.next();
                    System.out.println("Introdueix reportsTo");
                    int reportsTo = sc.nextInt();
                    System.out.println("Introdueix la data de naixement (YYYY-MM-DD)");
                    LocalDate birthDate = LocalDate.parse(sc.next());
                    System.out.println("Introdueix la data de reclutament (YYYY-MM-DD)");
                    LocalDate hireDate = LocalDate.parse(sc.next());
                    System.out.println("Introdueix l'adreça");
                    String address = sc.next();
                    System.out.println("Introdueix la ciutat");
                    String city = sc.next();
                    System.out.println("Introdueix l'estat");
                    String state = sc.next();
                    System.out.println("Introdueix el pais");
                    String country = sc.next();
                    System.out.println("Introdueix el codi postal");
                    String postalCode = sc.next();
                    System.out.println("Introdueix el telefon");
                    String phone = sc.next();
                    System.out.println("Introdueix el fax");
                    String fax = sc.next();
                    System.out.println("Introdueix l'email");
                    String email = sc.next();
                    System.out.println("Creat employee: " + employeeDao.create(new Employee(0, lastName, fistName, title, reportsTo, birthDate, hireDate, address, city, state, country, postalCode, phone, fax, email)));
                    break;
                }
                case 4:{
                    System.out.println("Introdueix quin employee vols modificar");
                    int idEmployee = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introdueix el cognom");
                    String lastName = sc.next();
                    System.out.println("Introdueix el nom");
                    String fistName = sc.next();
                    System.out.println("Introdueix el titol");
                    String title = sc.next();
                    System.out.println("Introdueix reportsTo");
                    int reportsTo = sc.nextInt();
                    System.out.println("Introdueix la data de naixement (YYYY-MM-DD)");
                    LocalDate birthDate = LocalDate.parse(sc.next());
                    System.out.println("Introdueix la data de reclutament (YYYY-MM-DD)");
                    LocalDate hireDate = LocalDate.parse(sc.next());
                    System.out.println("Introdueix l'adreça");
                    String address = sc.next();
                    System.out.println("Introdueix la ciutat");
                    String city = sc.next();
                    System.out.println("Introdueix l'estat");
                    String state = sc.next();
                    System.out.println("Introdueix el pais");
                    String country = sc.next();
                    System.out.println("Introdueix el codi postal");
                    String postalCode = sc.next();
                    System.out.println("Introdueix el telefon");
                    String phone = sc.next();
                    System.out.println("Introdueix el fax");
                    String fax = sc.next();
                    System.out.println("Introdueix l'email");
                    String email = sc.next();
                    employeeDao.update(new Employee(idEmployee, lastName, fistName, title, reportsTo, birthDate, hireDate, address, city, state, country, postalCode, phone, fax, email));
                    break;
                }
                case 5:{
                    System.out.println("Introdueix quin employee vols eliminar");
                    int idEmployee = sc.nextInt();
                    employeeDao.delete(idEmployee);
                    break;
                }
                case 0:{

                }
                default:{
                    System.out.println("Introdueix un nombre valid del 0 al 5");
                    break;
                }
            }
            mainEmployeeDAO.menu();
            opcio = sc.nextInt();
            sc.nextLine();
        }
        c.close();
    }
}
