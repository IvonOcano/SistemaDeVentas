package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ivon
 */
public class Conexion {

    //conexion local 
    public static Connection conectar() {

        try {

            Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bd_sistema_ventas?user=root&password=152336628");
            return cn;

        } catch (SQLException e) {
            System.out.println("Error en la conexion local " + e);
        }
        return null;

    }
}
