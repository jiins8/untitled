package DAM1.Abacus;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MainDAO
{
    public void menu(){
        System.out.println("Diguis quina opció vols executar:\n"
                + "1) Llista els productes\n"
                + "2) Selecciona un sol producte\n"
                + "3) Introdueix un producte\n"
                + "4) Modifica un producte\n"
                + "5) Elimina un producte\n"
                + "0) Sortir\n"
        );
    }

    public static void main( String args[] ) throws SQLException {
        Connection c = Connexio.getConnection();
        ProductesDao productesDao = new ProductosDaoImplementacio();
        MainDAO mainDAO = new MainDAO();

        mainDAO.menu();
        Scanner sc = new Scanner(System.in);
        int opcio = sc.nextInt(); sc.nextLine();

        while (opcio!=0){
            switch(opcio){
                case 1: {
                    System.out.println(productesDao.getProductos());
                    break;
                }
                case 2:{
                    System.out.println("Introduce id producto quieres ver");
                    int idProducto = sc.nextInt();
                    System.out.println(productesDao.read(idProducto));
                    break;
                }
                case 3:{
                    System.out.println("Introduce el idCategoria\n"+
                            "1. Papeleria\n" +
                            "2. Tecnología\n" +
                            "3. Librería\n" +
                            "4. Deporte\n" +
                            "5. Juguetería");
                    int idCategoria = sc.nextInt();
                    System.out.println("Introduce el nombre");
                    String nombre = sc.next();
                    System.out.println("Introduce el precio");
                    int precio = sc.nextInt();
                    System.out.println("Introduce el stock");
                    int stock = sc.nextInt();
                    System.out.println("Producto creado: " + productesDao.create(new Productos(0, idCategoria, nombre, precio, stock)));
                    break;
                }
                case 4:{
                    System.out.println("Introduce el idProducto que quieres modificar");
                    int idProducto = sc.nextInt();
                    System.out.println("Introduce el nuevo idCategoria");
                    int idCategoria = sc.nextInt();
                    System.out.println("Introdueix el nombre nuevo");
                    String  nommbre = sc.next();
                    System.out.println("Introdueix el precio nuevo");
                    int precio = sc.nextInt();
                    System.out.println("Introduce el nuevo stock");
                    int stock = sc.nextInt();
                    productesDao.update(new Productos(idProducto, idCategoria, nommbre, precio, stock));
                    break;
                }
                case 5:{
                    System.out.println("Introduce id producto que quieres eliminar");
                    int idProducto = sc.nextInt();
                    productesDao.delete(idProducto);
                    break;
                }
                case 0:{
                    break;
                }
                default:{
                    System.out.println("Introdueix un nombre vàlid del 0 al 6");
                    break;
                }
            }

            mainDAO.menu();
            opcio = sc.nextInt();sc.nextLine();
        }
        c.close();
    }
}