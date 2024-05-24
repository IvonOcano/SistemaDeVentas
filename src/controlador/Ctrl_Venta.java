package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import modelo.Venta;

/**
 *
 * @author Ivon
 */
public class Ctrl_Venta {

    private Connection conexion;

    public Ctrl_Venta(Connection conexion) {
        this.conexion = conexion;
    }
    
    //Esta tabla se utiliza para registrar las ventas que hacen los vendedores

    public boolean guardarVenta(Venta venta) {
        boolean exito = false;
        String query = "INSERT INTO tb_ventas (fechaVenta, vendedor, producto, cantidad, monto) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setDate(1, new java.sql.Date(venta.getFechaVenta().getTime()));
            stmt.setString(2, venta.getVendedor());
            stmt.setString(3, venta.getProducto());
            stmt.setInt(4, venta.getCantidad());
            stmt.setDouble(5, venta.getMonto());

            int filasAfectadas = stmt.executeUpdate();
            exito = (filasAfectadas > 0);
        } catch (SQLException e) {
            System.out.println("Error al guardar la venta: " + e.getMessage());
        }

        return exito;
    }

    public boolean actualizarVenta(Venta venta, int idVenta) {
        boolean exito = false;
        String query = "UPDATE tb_ventas SET fechaVenta = ?, vendedor = ?, producto = ?, cantidad = ?, monto = ? WHERE idVenta = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setDate(1, new java.sql.Date(venta.getFechaVenta().getTime()));
            stmt.setString(2, venta.getVendedor());
            stmt.setString(3, venta.getProducto());
            stmt.setInt(4, venta.getCantidad());
            stmt.setDouble(5, venta.getMonto());
            stmt.setInt(6, idVenta);

            int filasAfectadas = stmt.executeUpdate();
            exito = (filasAfectadas > 0);
        } catch (SQLException e) {
            System.out.println("Error al actualizar la venta: " + e.getMessage());
        }

        return exito;
    }

    public boolean eliminarVenta(int idVenta) {
        boolean exito = false;
        String query = "DELETE FROM tb_ventas WHERE idVenta = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, idVenta);

            int filasAfectadas = stmt.executeUpdate();
            exito = (filasAfectadas > 0);
        } catch (SQLException e) {
            System.out.println("Error al eliminar la venta: " + e.getMessage());
        }

        return exito;
    }
}
