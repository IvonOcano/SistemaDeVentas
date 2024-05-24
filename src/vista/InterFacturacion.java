package vista;

import java.sql.PreparedStatement;
import conexion.Conexion;
import controlador.Ctrl_RegistrarVenta;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.CabeceraVenta;
import modelo.DetalleVenta;

public class InterFacturacion extends javax.swing.JInternalFrame {

    //Modelo de los datos
    private DefaultTableModel modeloDatosProductos;
    //lista para el detalle de venta de los productos
    ArrayList<DetalleVenta> listaProductos = new ArrayList<>();
    private DetalleVenta producto;

    private int idCliente = 0;//id del cliente seleccionado

    private int idProducto = 0;
    private String nombre = "";
    private int cantidadProductoBBDD = 0;
    private double precioUnitario = 0.0;
    private double iva = 0;
    private int porcentajeIva = 0;
    private int porcentajeDescuento = 0;

    private int cantidad = 0; //Cantidad de productos a comprar
    private double subtotal = 0.0; //Cantidad por precio
    private String tipoPrecio = "";
    private double descuento = 0.0;
    private double totalPagar = 0.0;

    //Variables para cálculos globales
    private double subtotalGeneral = 0.0;
    private double descuentoGeneral = 0.0;
    private double ivaGeneral = 0.0;
    private double totalPagarGeneral = 0.0;
    //Fin de Variables de cálculos globales

    private int auxIdDetalle = 1; //Id del detalle de venta 

    public InterFacturacion() {
        initComponents();
        this.setSize(new Dimension(800, 600));
        this.setTitle("Facturacion");

        //Cargar los clientes en la vista 
        this.CargarComboClientes();
        this.CargarComboTipoVenta();
        //Cargar los productos en la vista
        this.CargarComboProductos();

        //Cargar los productos en la tabla
        this.inicializarTablaProducto();

        txt_efectivo.setEnabled(false);
        jButton_calcular_cambio.setEnabled(false);

        txt_subtotal.setText("0.0");
        txt_descuento.setText("0.0");
        txt_total_pagar.setText("0.0");

        jComboBox_descuento.removeAllItems();
        jComboBox_descuento.addItem("Seleccione descuento:");
        jComboBox_descuento.addItem("Sin descuento");
        jComboBox_descuento.addItem("5%");
        jComboBox_descuento.addItem("10%");
        jComboBox_descuento.addItem("15%");
        jComboBox_descuento.addItem("20%");
        jComboBox_descuento.addItem("50%");

        //Insertar imagen en nuestro jLabel
        ImageIcon wallpaper = new ImageIcon("src/img/fondo3.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(800, 600, WIDTH));
        jLabel_wallpaper.setIcon(icono);
        this.repaint();
    }

    //Método para inicializar la tabla de los productos
    private void inicializarTablaProducto() {
        modeloDatosProductos = new DefaultTableModel();
        //añadir columnas
        modeloDatosProductos.addColumn("N");
        modeloDatosProductos.addColumn("Nombre");
        modeloDatosProductos.addColumn("Cantidad");
        modeloDatosProductos.addColumn("P. Unitario");
        modeloDatosProductos.addColumn("Subtotal");
        modeloDatosProductos.addColumn("Descuento");
        modeloDatosProductos.addColumn("Iva");
        modeloDatosProductos.addColumn("Total a pagar");
        modeloDatosProductos.addColumn("Accion");
        //Agregar los datos del modelo a la tabla
        this.jTable_productos.setModel(modeloDatosProductos);
    }

    //Método para presentar la información de la tabla DetalleVenta
    private void listaTablaProductos() {
        this.modeloDatosProductos.setRowCount(listaProductos.size());
        for (int i = 0; i < listaProductos.size(); i++) {
            this.modeloDatosProductos.setValueAt(i + 1, i, 0);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getNombre(), i, 1);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getCantidad(), i, 2);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getPrecioUnitario(), i, 3);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getSubtotal(), i, 4);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getDescuento(), i, 5);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getIva(), i, 6);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getTotalPagar(), i, 7);
            this.modeloDatosProductos.setValueAt("Eliminar", i, 8); //Aquí luego poner un boton de eliminar
        }
        //Añadir al JTable
        jTable_productos.setModel(modeloDatosProductos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox_cliente = new javax.swing.JComboBox<>();
        jComboBox_producto = new javax.swing.JComboBox<>();
        txt_cliente_buscar = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        jButton_buscar_cliente = new javax.swing.JButton();
        jButton_añadir_producto = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_subtotal = new javax.swing.JTextField();
        txt_descuento = new javax.swing.JTextField();
        txt_iva = new javax.swing.JTextField();
        txt_total_pagar = new javax.swing.JTextField();
        txt_efectivo = new javax.swing.JTextField();
        txt_cambio = new javax.swing.JTextField();
        jButton_calcular_cambio = new javax.swing.JButton();
        jButton_RegistrarVenta = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jComboBox_tipo_venta = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jComboBox_descuento = new javax.swing.JComboBox<>();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Facturación");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 80, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Producto:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 80, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cantidad:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 80, -1));

        jComboBox_cliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione cliente:", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 170, -1));

        jComboBox_producto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione producto:", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 170, -1));

        txt_cliente_buscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_cliente_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 150, -1));

        txt_cantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 60, -1));

        jButton_buscar_cliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_buscar_cliente.setText("Buscar");
        jButton_buscar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscar_clienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_buscar_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 80, -1));

        jButton_añadir_producto.setBackground(new java.awt.Color(153, 255, 153));
        jButton_añadir_producto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_añadir_producto.setText("Añadir productos");
        jButton_añadir_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_añadir_productoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_añadir_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 140, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 740, 190));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 760, 210));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Subtotal:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Descuento:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Iva:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Total a pagar:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Efectivo:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Cambio:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txt_subtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_subtotal.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_subtotal.setEnabled(false);
        jPanel2.add(txt_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 120, -1));

        txt_descuento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_descuento.setEnabled(false);
        jPanel2.add(txt_descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 120, -1));

        txt_iva.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_iva.setEnabled(false);
        jPanel2.add(txt_iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 120, -1));

        txt_total_pagar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_total_pagar.setEnabled(false);
        jPanel2.add(txt_total_pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 120, -1));

        txt_efectivo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(txt_efectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 145, 120, -1));

        txt_cambio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_cambio.setEnabled(false);
        jPanel2.add(txt_cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 175, 120, -1));

        jButton_calcular_cambio.setBackground(new java.awt.Color(51, 255, 255));
        jButton_calcular_cambio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_calcular_cambio.setText("Calcular Cambio");
        jButton_calcular_cambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_calcular_cambioActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_calcular_cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 130, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 380, 210));

        jButton_RegistrarVenta.setBackground(new java.awt.Color(51, 255, 255));
        jButton_RegistrarVenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_RegistrarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/impresora.png"))); // NOI18N
        jButton_RegistrarVenta.setText("Registrar Venta");
        jButton_RegistrarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_RegistrarVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_RegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarVentaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_RegistrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 170, 100));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Tipo de Venta:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 110, -1));

        jComboBox_tipo_venta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_tipo_venta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione tipo de venta:", "Item 2", "Item 3", "Item 4" }));
        jComboBox_tipo_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_tipo_ventaActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_tipo_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 170, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Descuento:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 90, 20));

        jComboBox_descuento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_descuento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione descuento:", "Item 2", "Item 3", "Item 4" }));
        jComboBox_descuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_descuentoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 170, -1));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_añadir_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_añadir_productoActionPerformed

        String combo = this.jComboBox_producto.getSelectedItem().toString();
        //Validar que seleccione un producto
        if (combo.equalsIgnoreCase("Seleccione producto:")) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
        } else {
            // Validar que seleccione un tipo de venta
            String tipoVenta = this.jComboBox_tipo_venta.getSelectedItem().toString();
            if (tipoVenta.equalsIgnoreCase("Seleccione tipo de venta:")) {
                JOptionPane.showMessageDialog(null, "Seleccione un tipo de venta");
            } else {
                // Validar que seleccione un descuento
                String descuentoSeleccionado = this.jComboBox_descuento.getSelectedItem().toString();
                if (descuentoSeleccionado.equalsIgnoreCase("Seleccione descuento:")) {
                    JOptionPane.showMessageDialog(null, "Seleccione un descuento");
                } else {
                    //Validar que ingrese una cantidad
                    if (!txt_cantidad.getText().isEmpty()) {
                        //Validar que el usuario no ingrese caracteres no numéricos
                        boolean validacion = validar(txt_cantidad.getText());
                        if (validacion) {
                            //Validar que la cantidad sea mayor a 0(cero)
                            int cantidad = Integer.parseInt(txt_cantidad.getText());
                            if (cantidad > 0) {
                                //Ejecutar método para obtener datos del producto
                                this.DatosDelProducto(tipoVenta); // Paso el tipo de venta
                                //Validar que la cantidad de productos seleccionados no sea mayor al stock de la base de datos
                                if (cantidad <= cantidadProductoBBDD) {
                                    // El precio es igual al precio unitario
                                    double precio = precioUnitario;
                                    // Calcular el subtotal sin descuento
                                    double subtotal = precio * cantidad;
                                    // Calcular el descuento según la opción seleccionada
                                    double descuentoAplicado = CalcularDescuento(precio, porcentajeDescuento, cantidad);
                                    // Aplicar el descuento al subtotal
                                    double subtotalConDescuento = subtotal - descuentoAplicado;
                                    double totalPagar = subtotalConDescuento + iva;

                                    //Redondear decimales
                                    subtotal = Math.round(subtotal * 100.0) / 100.0;
                                    iva = Math.round(iva * 100.0) / 100.0;
                                    descuentoAplicado = Math.round(descuentoAplicado * 100.0) / 100.0;
                                    totalPagar = Math.round(totalPagar * 100.0) / 100.0;

                                    //Se crea un nuevo producto
                                    DetalleVenta producto = new DetalleVenta(auxIdDetalle, //IdDetalleVenta
                                            1, //idCabecera
                                            idProducto,
                                            nombre,
                                            cantidad,
                                            precioUnitario,
                                            tipoPrecio,
                                            subtotal,
                                            descuentoAplicado, // Usar el descuento calculado
                                            iva,
                                            totalPagar,
                                            1 //Estado
                                    );
                                    //Añadir a la lista
                                    listaProductos.add(producto);
                                    JOptionPane.showMessageDialog(null, "Producto Agregado");
                                    auxIdDetalle++;
                                    txt_cantidad.setText(""); //Limpiar el campo
                                    //Volver a cargar combo productos
                                    this.CargarComboProductos();
                                    this.CalcularTotalPagar();
                                    txt_efectivo.setEnabled(true);
                                    jButton_calcular_cambio.setEnabled(true);
                                } else {
                                    JOptionPane.showMessageDialog(null, "La cantidad supera el Stock");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Ingrese una cantidad mayor a cero");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Ingrese solo caracteres numéricos");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingrese la cantidad de productos");
                    }
                }
            }
        }
        //Llamar al método
        this.listaTablaProductos();
    }//GEN-LAST:event_jButton_añadir_productoActionPerformed

    private void jButton_calcular_cambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_calcular_cambioActionPerformed
        if (!txt_efectivo.getText().isEmpty()) {
            //Validamos que el usuario no ingrese otros caracteres no numericos
            boolean validacion = validarDouble(txt_efectivo.getText());
            if (validacion == true) {
                // Validar que el efectivo sea mayor a 0(cero)
                double efc = Double.parseDouble(txt_efectivo.getText().trim());
                double top = Double.parseDouble(txt_total_pagar.getText().trim());

                if (efc < top) {
                    JOptionPane.showMessageDialog(null, "El dinero en efectivo no es suficiente");
                } else {
                    double cambio = (efc - top);
                    double cambi = (double) Math.round(cambio * 100d) / 100;
                    String camb = String.valueOf(cambi);
                    txt_cambio.setText(camb);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se admiten caracteres no numericos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese dinero en efectivo para calcular cambio");
        }
    }//GEN-LAST:event_jButton_calcular_cambioActionPerformed

    private void jButton_buscar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscar_clienteActionPerformed

        String clienteBuscar = txt_cliente_buscar.getText().trim();
        Connection cn = Conexion.conectar();
        String sql = "select nombre, apellido from tb_cliente where dni = '" + clienteBuscar + "'";
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                jComboBox_cliente.setSelectedItem(rs.getString("nombre") + " " + rs.getString("apellido"));
            } else {
                jComboBox_cliente.setSelectedItem("Seleccione cliente:");
                JOptionPane.showMessageDialog(null, "¡Dni de cliente no encontrado o inválido!");
            }
            txt_cliente_buscar.setText("");
            cn.close();
        } catch (SQLException e) {
            System.out.println("¡Error al buscar cliente!, " + e);
        }
    }//GEN-LAST:event_jButton_buscar_clienteActionPerformed

    int idArrayList = 0;
    private void jTable_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_productosMouseClicked

        int fila_point = jTable_productos.rowAtPoint(evt.getPoint());
        int columna_point = 0;

        if (fila_point > -1) {
            idArrayList = (int) modeloDatosProductos.getValueAt(fila_point, columna_point);
        }

        int opcion = JOptionPane.showConfirmDialog(null, "¿Eliminar Producto?");
        //Opciones de confirm dialog - (si = 0; no = 1; cancel = 2; close = -1)
        switch (opcion) {
            case 0: //Presioné Si
                listaProductos.remove(idArrayList - 1);
                this.CalcularTotalPagar();
                this.listaTablaProductos();
                break;
            case 1: //Presioné No
                break;
            default: //Presione cancel (2) o close (-1)
                break;
        }

    }//GEN-LAST:event_jTable_productosMouseClicked

    private void jButton_RegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarVentaActionPerformed

        CabeceraVenta cabeceraVenta = new CabeceraVenta();
        DetalleVenta detalleVenta = new DetalleVenta();
        Ctrl_RegistrarVenta controlVenta = new Ctrl_RegistrarVenta();

        String fechaActual = "";
        Date date = new Date();
        fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);

        if (!jComboBox_cliente.getSelectedItem().equals("Seleccione cliente:")) {
            if (listaProductos.size() > 0) {
                // Método para obtener el id del cliente
                this.obtenerIdCliente();
                // Calcular el total a pagar
                double totalPagar = Double.parseDouble(txt_total_pagar.getText());
                // Obtener el monto en efectivo ingresado por el vendedor
                String montoEfectivoStr = txt_efectivo.getText().trim(); // Eliminar espacios en blanco al principio y al final
                if (!montoEfectivoStr.isEmpty()) { // Verificar si el campo no está vacío
                    double montoEfectivo = Double.parseDouble(montoEfectivoStr);

                    if (montoEfectivo > 0) {
                        if (montoEfectivo >= totalPagar) {
                            //Registrar cabecera
                            cabeceraVenta.setIdCabeceraVenta(0);
                            cabeceraVenta.setIdCliente(idCliente);
                            cabeceraVenta.setValorPagar(totalPagar);
                            cabeceraVenta.setFechaVenta(fechaActual);
                            cabeceraVenta.setEstado(1);

                            if (controlVenta.guardar(cabeceraVenta)) {
                                JOptionPane.showMessageDialog(null, "¡Venta registrada!");

                                //Guardar detalle
                                for (DetalleVenta elemento : listaProductos) {
                                    detalleVenta.setIdDetalleVenta(0);
                                    detalleVenta.setIdCabeceraVenta(0);
                                    detalleVenta.setIdProducto(elemento.getIdProducto());
                                    detalleVenta.setCantidad(elemento.getCantidad());
                                    detalleVenta.setPrecioUnitario(elemento.getPrecioUnitario());
                                    detalleVenta.setSubtotal(elemento.getSubtotal());
                                    detalleVenta.setDescuento(elemento.getDescuento());
                                    detalleVenta.setIva(elemento.getIva());
                                    detalleVenta.setTotalPagar(elemento.getTotalPagar());
                                    detalleVenta.setEstado(1);

                                    if (controlVenta.guardarDetalle(detalleVenta)) {
                                        //System.out.println("Detalle de Venta Registrado");

                                        // Restablecer los valores de descuento y tipo de venta a cero
                                        jComboBox_descuento.setSelectedIndex(0); // Seleccione descuento: índice 0
                                        jComboBox_tipo_venta.setSelectedIndex(0); // Seleccione tipo de venta: índice 0

                                        txt_subtotal.setText("0.0");
                                        txt_iva.setText("0.0");
                                        txt_descuento.setText("0.0");
                                        txt_total_pagar.setText("0.0");
                                        txt_efectivo.setText("0.0");
                                        txt_cambio.setText("0.0");
                                        auxIdDetalle = 1;

                                        this.CargarComboClientes();
                                        this.RestarStockProductos(elemento.getIdProducto(), elemento.getCantidad());
                                    } else {
                                        JOptionPane.showMessageDialog(null, "¡Error al guardar detalle de venta!");
                                    }
                                }
                                //Vaciamos la lista
                                listaProductos.clear();
                                listaTablaProductos();
                            } else {
                                JOptionPane.showMessageDialog(null, "¡Error al guardar cabecera de venta!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Ingrese un monto igual o mayor al total a pagar.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El monto en efectivo debe ser mayor que cero.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese el monto en efectivo.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "¡Seleccione un Producto!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "¡Seleccione un Cliente!");
        }
    }//GEN-LAST:event_jButton_RegistrarVentaActionPerformed

    private void jComboBox_tipo_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_tipo_ventaActionPerformed

        jComboBox_tipo_venta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected item from the combo box
                String selectedTipoVenta = (String) jComboBox_tipo_venta.getSelectedItem();

                // Get the selected row from the table
                int selectedRow = jTable_productos.getSelectedRow();

                // Check if a row is selected and the selectedTipoVenta is not null
                if (selectedRow != -1 && selectedTipoVenta != null) {
                    // Get the precioMinorista and precioMayorista from the selected row in your table model
                    Object precioMinoristaObj = jTable_productos.getValueAt(selectedRow, jTable_productos.getColumnModel().getColumnIndex("precioMinorista"));
                    Object precioMayoristaObj = jTable_productos.getValueAt(selectedRow, jTable_productos.getColumnModel().getColumnIndex("precioMayorista"));

                    // Check if the price objects are not null and are instances of Double
                    if (precioMinoristaObj != null && precioMayoristaObj != null
                            && precioMinoristaObj instanceof Double && precioMayoristaObj instanceof Double) {
                        double precioMinorista = (double) precioMinoristaObj;
                        double precioMayorista = (double) precioMayoristaObj;

                        // Update the precioUnitario column based on the selectedTipoVenta
                        double precioUnitario = selectedTipoVenta.equals("Minorista") ? precioMinorista : precioMayorista;

                        // Update the precioUnitario value in the jTable_productos table model
                        jTable_productos.setValueAt(precioUnitario, selectedRow, jTable_productos.getColumnModel().getColumnIndex("precioUnitario"));
                    }
                }
            }
        });
    }//GEN-LAST:event_jComboBox_tipo_ventaActionPerformed

    private void CargarComboTipoVenta() {
        jComboBox_tipo_venta.removeAllItems();
        jComboBox_tipo_venta.addItem("Seleccione tipo de venta:");
        jComboBox_tipo_venta.addItem("Mayorista");
        jComboBox_tipo_venta.addItem("Minorista");
    }

    private void jComboBox_descuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_descuentoActionPerformed


    }//GEN-LAST:event_jComboBox_descuentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_RegistrarVenta;
    private javax.swing.JButton jButton_añadir_producto;
    private javax.swing.JButton jButton_buscar_cliente;
    private javax.swing.JButton jButton_calcular_cambio;
    private javax.swing.JComboBox<String> jComboBox_cliente;
    private javax.swing.JComboBox<String> jComboBox_descuento;
    private javax.swing.JComboBox<String> jComboBox_producto;
    private javax.swing.JComboBox<String> jComboBox_tipo_venta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
    private javax.swing.JTextField txt_cambio;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_cliente_buscar;
    private javax.swing.JTextField txt_descuento;
    private javax.swing.JTextField txt_efectivo;
    private javax.swing.JTextField txt_iva;
    private javax.swing.JTextField txt_subtotal;
    public static javax.swing.JTextField txt_total_pagar;
    // End of variables declaration//GEN-END:variables


    /*
    * Método para cargar los clientes en el jComboBox
     */
    private void CargarComboClientes() {
        Connection cn = Conexion.conectar();
        String sql = "select * from tb_cliente";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_cliente.removeAllItems();
            jComboBox_cliente.addItem("Seleccione cliente:");
            while (rs.next()) {
                jComboBox_cliente.addItem(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("¡Error al cargar clientes, !" + e);
        }
    }

    /*
    * Método para cargar los productos en el jComboBox
     */
    private void CargarComboProductos() {

        Connection cn = Conexion.conectar();
        String sql = "select * from tb_producto";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_producto.removeAllItems();
            jComboBox_producto.addItem("Seleccione producto:");
            while (rs.next()) {
                jComboBox_producto.addItem(rs.getString("nombre"));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("¡Error al cargar productos, !" + e);
        }
    }

    /*
    * Método para validar que el usuario no ingrese caracteres no numericos
     */
    private boolean validar(String valor) {
        try {
            int num = Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /*
    * Método para validar que el usuario no ingrese caracteres no numericos
     */
    private boolean validarDouble(String valor) {
        try {
            double num = Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /*
 * Método para mostrar los datos del producto seleccionado
     */
    private void DatosDelProducto(String tipoVenta) {
        try {
            String nombreProducto = this.jComboBox_producto.getSelectedItem().toString();

            // Construir la consulta SQL según el tipo de venta seleccionado
            String sql;
            if (tipoVenta.equalsIgnoreCase("Mayorista")) {
                sql = "SELECT * FROM tb_producto WHERE nombre = ? AND precioMayorista > 0";
            } else {
                sql = "SELECT * FROM tb_producto WHERE nombre = ? AND precioMinorista > 0";
            }

            Connection cn = Conexion.conectar();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, nombreProducto);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                idProducto = rs.getInt("idProducto");
                nombre = rs.getString("nombre");
                cantidadProductoBBDD = rs.getInt("cantidad");

                // Obtener el precio según el tipo de venta
                if (tipoVenta.equalsIgnoreCase("Mayorista")) {
                    precioUnitario = rs.getDouble("precioMayorista");
                } else {
                    precioUnitario = rs.getDouble("precioMinorista");
                }

                porcentajeDescuento = rs.getInt("descuento");
                

                // Calcular el descuento aplicado al precio unitario
                double descuentoAplicado = CalcularDescuento(precioUnitario, porcentajeDescuento, cantidad);
                precioUnitario -= descuentoAplicado; // Aplicar el descuento al precio unitario

//               
            }

            rs.close();
            ps.close();
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener datos del producto, " + e);
        }
    }

    /*
        * Método para calcular descuento
     */
    private double CalcularDescuento(double precio, int porcentajeDescuento, int cantidad) {
        int p_descuento = porcentajeDescuento;

        String descuentoSeleccionado = jComboBox_descuento.getSelectedItem().toString();
        if (!descuentoSeleccionado.equalsIgnoreCase("Sin descuento")) {
            // Extraer el porcentaje del descuento seleccionado
            p_descuento = Integer.parseInt(descuentoSeleccionado.replace("%", ""));
        }

        switch (p_descuento) {
            case 0:
                descuento = 0.0; // Sin descuento
                break;
            case 5:
                // Calcular el descuento del 5%
                descuento = precio * cantidad * 0.05;
                break;
            case 10:
                // Calcular el descuento del 5%
                descuento = precio * cantidad * 0.10;
                break;
            case 15:
                // Calcular el descuento del 5%
                descuento = precio * cantidad * 0.15;
                break;
            case 20:
                // Calcular el descuento del 5%
                descuento = precio * cantidad * 0.20;
                break;
            case 50:
                // Calcular el descuento del 5%
                descuento = precio * cantidad * 0.50;
                break;
            default:
                break;
        }
        return descuento;
    }

   

    /*
    Método para calcular el total a pagar de todos los productos agregados
     */
    private void CalcularTotalPagar() {
        subtotalGeneral = 0;
        descuentoGeneral = 0;
        ivaGeneral = 0;
        totalPagarGeneral = 0;

        for (DetalleVenta elemento : listaProductos) {
            double precio = elemento.getPrecioUnitario();
            int cantidad = elemento.getCantidad();

            // Calcular el subtotal sin aplicar el descuento
            double subtotalSinDescuento = precio * cantidad;

            // Obtener el descuento aplicado al producto
            double descuento = elemento.getDescuento();

            // Calcular el subtotal restando el descuento
            double subtotalConDescuento = subtotalSinDescuento - descuento;

            // Calcular el IVA y sumarlo al total a pagar
            double iva = elemento.getIva();
            double totalPagar = subtotalConDescuento + iva;

            // Sumar al total general
            subtotalGeneral += subtotalSinDescuento;  // Utilizar subtotalSinDescuento para el subtotal general
            descuentoGeneral += descuento;
            ivaGeneral += iva;
            totalPagarGeneral += totalPagar;
        }

        // Redondear decimales
        subtotalGeneral = (double) Math.round(subtotalGeneral * 100) / 100;
        descuentoGeneral = (double) Math.round(descuentoGeneral * 100) / 100;
        ivaGeneral = (double) Math.round(ivaGeneral * 100) / 100;
        totalPagarGeneral = (double) Math.round(totalPagarGeneral * 100) / 100;

        // Mostrar datos en la vista
        txt_subtotal.setText(String.valueOf(subtotalGeneral));
        txt_descuento.setText(String.valueOf(descuentoGeneral));
        txt_iva.setText(String.valueOf(ivaGeneral));
        txt_total_pagar.setText(String.valueOf(totalPagarGeneral));

    }

    /*
    Método para obtener id del cliente
     */
    private void obtenerIdCliente() {
        try {
            String sql = "select * from tb_cliente where concat(nombre,' ',apellido) = '" + this.jComboBox_cliente.getSelectedItem() + "'";
            Connection cn = Conexion.conectar();
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idCliente = rs.getInt("idCliente");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener id del cliente, " + e);
        }
    }

    //Método para restar la cantidad (stock) de los productos
    private void RestarStockProductos(int idProducto, int cantidad) {
        int cantidadProductosBaseDeDatos = 0;
        try {
            Connection cn = Conexion.conectar();
            String sql = "select idProducto, cantidad from tb_producto where idProducto = '" + idProducto + "'";
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cantidadProductosBaseDeDatos = rs.getInt("cantidad");
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al restar cantidad 1, " + e);
        }
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement consulta = cn.prepareStatement("update tb_producto set cantidad=? where idProducto = '" + idProducto + "'");
            int cantidadNueva = cantidadProductosBaseDeDatos - cantidad;
            consulta.setInt(1, cantidadNueva);
            if (consulta.executeUpdate() > 0) {
                System.out.println("Todo bien");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al restar cantidad 2, " + e);
        }
    }
}
