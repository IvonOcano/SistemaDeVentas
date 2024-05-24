package modelo;

import java.util.Date;

/**
 *
 * @author Ivon
 */
//Este archivo se agrega para el registro de Ventas diarias
public class Venta {

    private int idVenta;
    private Date fechaVenta;
    private String vendedor;
    private String producto;
    private int cantidad;
    private double monto;
    private String tipoVenta;
    private double porcentajeGanancia;
    private int idVendedor;

    public Venta(int idVenta, Date fechaVenta, String vendedor, String producto, int cantidad, double monto, String tipoVenta, double porcentajeGanancia, int idVendedor) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.vendedor = vendedor;
        this.producto = producto;
        this.cantidad = cantidad;
        this.monto = monto;
        this.tipoVenta = tipoVenta;
        this.porcentajeGanancia = porcentajeGanancia;
        this.idVendedor = idVendedor;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public double getPorcentajeGanancia() {
        return porcentajeGanancia;
    }

    public void setPorcentajeGanancia(double porcentajeGanancia) {
        this.porcentajeGanancia = porcentajeGanancia;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    

    // Método para calcular el total de la venta
    public double getTotalVenta() {
        return cantidad * monto;
    }
}
