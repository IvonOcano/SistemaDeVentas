package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ivono
 */
public class ConexionSQLite {
     public static Connection conectar() {
        try {
            Connection cn = DriverManager.getConnection("jdbc:sqlite:Users\\Ivono\\OneDrive\\Escritorio\\SistemadeVentas2\\SistemaDeVentas\\DatosMysqlSistVentas");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en la conexión SQLite: " + e.getMessage());
            return null;
        }
    }
}
