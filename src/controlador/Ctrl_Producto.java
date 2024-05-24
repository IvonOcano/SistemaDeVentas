package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Producto;

/**
 *
 * @author Ivon
 */
public class Ctrl_Producto {

    //Método para guardar un nuevo producto
    public boolean guardar(Producto objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("INSERT INTO tb_producto (nombre, cantidad, precio, precioMinorista, precioMayorista, descripcion, descuento, porcentajeIva, idCategoria, estado) VALUES (?,?,?,?,?,?,?,?,?,?)");
            consulta.setString(1, objeto.getNombre());
            consulta.setInt(2, objeto.getCantidad());
            consulta.setDouble(3, objeto.getPrecio());
            consulta.setDouble(4, objeto.getPrecioMinorista());
            consulta.setDouble(5, objeto.getPrecioMayorista());
            consulta.setString(6, objeto.getDescripcion());
            consulta.setInt(7, objeto.getDescuento());
            consulta.setInt(8, objeto.getPorcentajeIva());
            consulta.setInt(9, objeto.getIdCategoria());
            consulta.setInt(10, objeto.getEstado());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar producto:" + e);
        }
        return respuesta;
    }

    //Método para consultar si el producto ya esta registrado en la BBDD
    public boolean existeProducto(String producto) {
        boolean respuesta = false;
        String sql = "select nombre from tb_producto where nombre = '" + producto + "';";
        Statement st;

        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar producto:" + e);
        }
        return respuesta;
    }

    //Método para actualizar un producto
    public boolean actualizar(Producto objeto, int idProducto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("update tb_producto set nombre = ?, cantidad = ?, precio = ?, precioMinorista = ?, precioMayorista = ?, descripcion = ?, descuento = ?, porcentajeIva = ?, idCategoria = ?, estado = ? where idProducto ='" + idProducto + "'");
            consulta.setString(1, objeto.getNombre());
            consulta.setInt(2, objeto.getCantidad());
            consulta.setDouble(3, objeto.getPrecio());
            consulta.setDouble(4, objeto.getPrecioMinorista());
            consulta.setDouble(5, objeto.getPrecioMayorista());
            consulta.setString(6, objeto.getDescripcion());
            consulta.setInt(7, objeto.getDescuento());
            consulta.setInt(8, objeto.getPorcentajeIva());
            consulta.setInt(9, objeto.getIdCategoria());
            consulta.setInt(10, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto:" + e);
        }
        return respuesta;
    }

    //Método para eliminar un producto
    public boolean eliminar(int idProducto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "delete from tb_producto where idProducto ='" + idProducto + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto:" + e);
        }
        return respuesta;
    }

    //Método para actualizar el stock de un producto
    public boolean actualizarStock(Producto object, int idProducto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("update tb_producto set cantidad=? where idProducto ='" + idProducto + "'");
            consulta.setInt(1, object.getCantidad());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar stock del producto:" + e);
        }
        return respuesta;
    }
    
     // Método para obtener todos los productos
    public ArrayList<Producto> obtenerProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        Connection cn = Conexion.conectar();
        try {
            Statement consulta = cn.createStatement();
            ResultSet rs = consulta.executeQuery("SELECT * FROM tb_producto");
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setPrecioMinorista(rs.getDouble("precioMinorista"));
                producto.setPrecioMayorista(rs.getDouble("precioMayorista"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setDescuento(rs.getInt("descuento"));
                producto.setPorcentajeIva(rs.getInt("porcentajeIva"));
                producto.setIdCategoria(rs.getInt("idCategoria"));
                producto.setEstado(rs.getInt("estado"));

                productos.add(producto);
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener productos:" + e);
        }
        return productos;
    }
}
