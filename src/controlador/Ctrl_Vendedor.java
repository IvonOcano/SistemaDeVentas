package controlador;

import conexion.Conexion; // Importa la clase de conexión
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Vendedor; 

/**
 *
 * @author Ivono
 */
public class Ctrl_Vendedor {
    public boolean guardar(Vendedor objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("INSERT INTO tb_vendedor(nombre, apellido, correoElectronico, estado) VALUES (?, ?, ?, ?)");
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setString(3, objeto.getCorreoElectronico());
            consulta.setInt(4, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar vendedor: " + e);
        }
        return respuesta;
    }
    
    
    public boolean existeVendedor(String correoElectronico) {
        boolean respuesta = false;
        String sql = "SELECT correoElectronico FROM tb_vendedor WHERE correoElectronico = '" + correoElectronico + "';";
        try {
            Connection cn = Conexion.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al consultar vendedor: " + e);
        }
        return respuesta;
    }
    
    
    
   public boolean actualizar(Vendedor objeto, int idVendedor) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("UPDATE tb_vendedor SET nombre = ?, apellido = ?, correoElectronico = ?, estado = ? WHERE idVendedor = ?");
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setString(3, objeto.getCorreoElectronico());
            consulta.setInt(4, objeto.getEstado());
            consulta.setInt(5, idVendedor);

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar vendedor: " + e);
        }
        return respuesta;
    }
   
   public boolean eliminar(int idVendedor) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("DELETE FROM tb_vendedor WHERE idVendedor = ?");
            consulta.setInt(1, idVendedor);

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar vendedor: " + e);
        }
        return respuesta;
    }
}

