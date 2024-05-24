package modelo;

/**
 *
 * @author Ivon
 */
public class Producto {
      
    //Atributos
   private int idProducto;
    private String nombre;
    private int cantidad;
    private double precio;
    private double precioMinorista; // Nuevo atributo
    private double precioMayorista; // Nuevo atributo
    private String descripcion;
    private int descuento;
    private int porcentajeIva;
    private int idCategoria;
    private int estado;
    
    //Constructor Vacio
    public Producto(){
        this.idProducto = 0;
        this.nombre = "";
        this.cantidad = 0;
        this.precio = 0.0;
        this.precioMinorista = 0.0;
        this.precioMayorista = 0.0;
        this.descripcion = "";
        this.descuento = 0;
        this.porcentajeIva = 0;
        this.idCategoria = 0;
        this.estado = 0;
    }
    

    //Constructor Sobrecargado

    public Producto(int idProducto, String nombre, int cantidad, double precio, double precioMinorista, double precioMayorista, String descripcion, int descuento, int porcentajeIva, int idCategoria, int estado) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.precioMinorista = precioMinorista;
        this.precioMayorista = precioMayorista;
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.porcentajeIva = porcentajeIva;
        this.idCategoria = idCategoria;
        this.estado = estado;
    }
    
    
    
    //Set and Get

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecioMinorista() {
        return precioMinorista;
    }

    public void setPrecioMinorista(double precioMinorista) {
        this.precioMinorista = precioMinorista;
    }

    public double getPrecioMayorista() {
        return precioMayorista;
    }

    public void setPrecioMayorista(double precioMayorista) {
        this.precioMayorista = precioMayorista;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(int porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
}
