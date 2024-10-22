package vista;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.Dimension;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import modelo.Venta;
import java.sql.ResultSet;
import java.util.Properties;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Ivon
 */
public class InterVenta extends javax.swing.JInternalFrame {

    // Declaración de las variables para los porcentajes seleccionados
    private String porcentajeSeleccionadoMinorista = "";
    private String porcentajeSeleccionadoMayorista = "";

    private String porcentajeSeleccionado;

    // Add file path for the properties file
    private static final String CONFIG_FILE = "config.properties";

    /**
     * Creates new form InterVenta
     */
    public InterVenta() {
        initComponents();

        this.setSize(new Dimension(411, 534));
        this.setTitle("Ventas Vendedores");

        //Insertar imagen en nuestro jLabel
        ImageIcon wallpaper = new ImageIcon("src/img/fondo3.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(411, 534, WIDTH));
        jLabel_wallpaper.setIcon(icono);
        this.repaint();

        // Cargar los productos existentes al iniciar la ventana
        cargarProductos();
        // Cargar los usuarios al iniciar la ventana
        cargarVendedores();

        jComboBox_cantidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"})); // Puedes ajustar la lista según tus necesidades
        cargarTiposVentas();
        jComboBox_tipo_ventas.addActionListener((evt) -> {
            actualizarMonto();
        });
        // Llenar los JComboBox de porcentajes de ganancia
        llenarComboBoxPorcentajes();

        loadProfitPercentageValues();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser_fechaVenta = new com.toedter.calendar.JDateChooser();
        jComboBox_producto = new javax.swing.JComboBox<>();
        jComboBox_vendedor = new javax.swing.JComboBox<>();
        jTextField_monto = new javax.swing.JTextField();
        jButton_guardarVenta = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jComboBox_tipo_ventas = new javax.swing.JComboBox<>();
        jComboBox_cantidad = new javax.swing.JComboBox<>();
        jComboBox_porcentajeGananciaMinorista = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox_porcentajeGananciaMayorista = new javax.swing.JComboBox<>();
        jButton_actualizar = new javax.swing.JButton();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ventas vendedores");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha Venta:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Vendedor:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Producto:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 130, 70, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cantidad:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Monto:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));
        getContentPane().add(jDateChooser_fechaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 170, -1));

        jComboBox_producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione producto:", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 170, -1));

        jComboBox_vendedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione vendedor:", "Item 2", "Item 3", "Item 4" }));
        jComboBox_vendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_vendedorActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_vendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 170, -1));

        jTextField_monto.setEnabled(false);
        jTextField_monto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_montoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 170, -1));

        jButton_guardarVenta.setBackground(new java.awt.Color(153, 255, 255));
        jButton_guardarVenta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_guardarVenta.setText("Guardar");
        jButton_guardarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardarVentaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_guardarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 120, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tipo de Venta:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jComboBox_tipo_ventas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione tipo de venta:", "Item 2", "Item 3", "Item 4" }));
        jComboBox_tipo_ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_tipo_ventasActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_tipo_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 170, -1));

        jComboBox_cantidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, -1, 20));

        jComboBox_porcentajeGananciaMinorista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_porcentajeGananciaMinorista, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 160, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Porcentaje Minorista:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Porcentaje Mayorista:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        jComboBox_porcentajeGananciaMayorista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_porcentajeGananciaMayorista, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 160, -1));

        jButton_actualizar.setBackground(new java.awt.Color(51, 255, 0));
        jButton_actualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 130, 30));

        jLabel_wallpaper.setToolTipText("");
        jLabel_wallpaper.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_guardarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardarVentaActionPerformed
        // Verificar si todos los campos están completos
        if (validarCampos()) {
            // Obtener datos de los campos de la interfaz gráfica
            Date fechaVenta = jDateChooser_fechaVenta.getDate();
            String vendedor = jComboBox_vendedor.getSelectedItem().toString();
            String producto = jComboBox_producto.getSelectedItem().toString();
            int cantidad = Integer.parseInt(jComboBox_cantidad.getSelectedItem().toString());
            String tipoVenta = jComboBox_tipo_ventas.getSelectedItem().toString();
            double monto = Double.parseDouble(jTextField_monto.getText());

            int idVendedor = obtenerIdVendedor(vendedor);

            // Obtener el porcentaje de ganancia según el tipo de venta seleccionado
            String porcentajeSeleccionado = "";
            if (tipoVenta.equals("Precio Minorista")) {
                porcentajeSeleccionado = jComboBox_porcentajeGananciaMinorista.getSelectedItem().toString();
            } else if (tipoVenta.equals("Precio Mayorista")) {
                porcentajeSeleccionado = jComboBox_porcentajeGananciaMayorista.getSelectedItem().toString();
            }

            double porcentajeGanancia = calcularPorcentajeGanancia(tipoVenta, porcentajeSeleccionado);

            // Crear un objeto Venta con los datos obtenidos
            Venta venta = new Venta(0, fechaVenta, vendedor, producto, cantidad, monto, tipoVenta, porcentajeGanancia, idVendedor);

            // Guardar la venta en la base de datos
            if (guardarVenta(venta, tipoVenta)) {

                JOptionPane.showMessageDialog(null, "Venta registrada correctamente.");
                // Aquí puedes añadir lógica adicional después de guardar la venta
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar la venta.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos antes de guardar la venta.");
        }
    }//GEN-LAST:event_jButton_guardarVentaActionPerformed

    // Método para validar que todos los campos estén completos
    private boolean validarCampos() {
        return jDateChooser_fechaVenta.getDate() != null
                && jComboBox_vendedor.getSelectedIndex() > 0
                && jComboBox_producto.getSelectedIndex() > 0
                && jComboBox_cantidad.getSelectedIndex() > 0
                && jComboBox_tipo_ventas.getSelectedIndex() > 0
                && !jTextField_monto.getText().isEmpty();
    }

    // Método para limpiar los campos y volver a su estado inicial
    private void limpiarCampos() {
        jDateChooser_fechaVenta.setDate(null);
        jComboBox_vendedor.setSelectedIndex(0);
        jComboBox_producto.setSelectedIndex(0);
        jComboBox_cantidad.setSelectedIndex(0);
        jComboBox_tipo_ventas.setSelectedIndex(0);
        jTextField_monto.setText("");
    }

    // Modificar el método cargarUsuarios en la clase InterVenta
    private void cargarVendedores() {
        Connection cn = Conexion.conectar();
        String sql = "SELECT nombre, apellido FROM tb_vendedor WHERE estado = 1";
        PreparedStatement ps;

        try {
            ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            jComboBox_vendedor.removeAllItems();
            jComboBox_vendedor.addItem("Seleccione vendedor:");
            while (rs.next()) {
                String nombreCompleto = rs.getString("nombre") + " " + rs.getString("apellido");
                jComboBox_vendedor.addItem(nombreCompleto);
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al cargar vendedores: " + e.getMessage());
        }
    }

    // Método para cargar los tipos de ventas en el combo box jComboBox_tipo_ventas
    private void cargarTiposVentas() {
        jComboBox_tipo_ventas.removeAllItems();
        jComboBox_tipo_ventas.addItem("Seleccione tipo de venta:");
        jComboBox_tipo_ventas.addItem("Precio Minorista");
        jComboBox_tipo_ventas.addItem("Precio Mayorista");
    }

    // Método para actualizar el monto en función del tipo de venta seleccionado y la cantidad ingresada
    private void actualizarMonto() {
        String tipoVenta = jComboBox_tipo_ventas.getSelectedItem().toString();
        int cantidad = Integer.parseInt(jComboBox_cantidad.getSelectedItem().toString());
        double precioBase = obtenerPrecioProducto(tipoVenta); // Obtiene el precio base según el tipo de venta

        // Calcula el monto sumando la cantidad al precio base
        double monto = cantidad * precioBase;

        jTextField_monto.setText(String.valueOf(monto));
    }

    // Método para obtener el precio del producto según el tipo de venta seleccionado
    private double obtenerPrecioProducto(String tipoVenta) {
        // Inicializar el precio en 0.0 por defecto
        double precio = 0.0;

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement ps;
            ResultSet rs;

            // Consulta SQL para obtener el precio según el tipo de venta
            String sql;
            switch (tipoVenta) {
                case "Precio Minorista":
                    sql = "SELECT precioMinorista FROM tb_producto WHERE nombre = ?";
                    break;
                case "Precio Mayorista":
                    sql = "SELECT precioMayorista FROM tb_producto WHERE nombre = ?";
                    break;
                default:
                    sql = ""; // Consulta vacía para un tipo de venta no válido
                    break;
            }

            if (!sql.isEmpty()) { // Verificar que la consulta no esté vacía
                String nombreProducto = jComboBox_producto.getSelectedItem().toString();
                ps = cn.prepareStatement(sql);
                ps.setString(1, nombreProducto);
                rs = ps.executeQuery();

                if (rs.next()) {
                    precio = rs.getDouble(1); // Obtener el precio desde la primera columna del resultado
                }

                rs.close();
                ps.close();
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener precio del producto: " + e);
        }

        return precio;
    }

    // Método para obtener el idVendedor correspondiente al nombre del vendedor seleccionado
    private int obtenerIdVendedor(String nombreVendedor) {
        int idVendedor = 0; // Valor por defecto si no se encuentra el id

        try {
            Connection cn = Conexion.conectar();
            String sql = "SELECT idVendedor FROM tb_vendedor WHERE CONCAT(nombre, ' ', apellido) = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, nombreVendedor);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                idVendedor = rs.getInt("idVendedor");
            }

            rs.close();
            ps.close();
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el idVendedor: " + e.getMessage());
        }
        return idVendedor;
    }

    private void jComboBox_vendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_vendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_vendedorActionPerformed

    private void jComboBox_tipo_ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_tipo_ventasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_tipo_ventasActionPerformed

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
        // Display a confirmation dialog
        int option = JOptionPane.showConfirmDialog(this, "¿Está seguro de querer actualizar los porcentajes de ventas?", "Confirmación", JOptionPane.YES_NO_OPTION);

        // Check the user's choice
        if (option == JOptionPane.YES_OPTION) {
            // User confirmed, proceed with updating percentages
            porcentajeSeleccionadoMinorista = jComboBox_porcentajeGananciaMinorista.getSelectedItem().toString();
            porcentajeSeleccionadoMayorista = jComboBox_porcentajeGananciaMayorista.getSelectedItem().toString();
            String tipoVenta = jComboBox_tipo_ventas.getSelectedItem().toString(); // Obtener el tipo de venta seleccionado

            if (!porcentajeSeleccionadoMinorista.equals("Seleccione porcentaje") || !porcentajeSeleccionadoMayorista.equals("Seleccione porcentaje")) {
                // Actualizar el porcentaje de ganancia en la base de datos
                actualizarPorcentajeGanancia(porcentajeSeleccionadoMinorista, porcentajeSeleccionadoMayorista, tipoVenta);

                // Actualizar el porcentaje de ganancia en la interfaz
                jComboBox_porcentajeGananciaMinorista.setSelectedItem(porcentajeSeleccionadoMinorista);
                jComboBox_porcentajeGananciaMayorista.setSelectedItem(porcentajeSeleccionadoMayorista);

                // Guardar los valores seleccionados de porcentaje de ganancia
                saveProfitPercentageValues();
            }
        }
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jTextField_montoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_montoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_montoActionPerformed

    private void actualizarPorcentajeGanancia(String porcentajeSeleccionadoMinorista, String porcentajeSeleccionadoMayorista, String tipoVenta) {
        try {
            Connection cn = Conexion.conectar();
            String sql;
            double porcentajeGanancia;

            if (tipoVenta.equals("Precio Minorista")) {
                porcentajeGanancia = parsePorcentaje(porcentajeSeleccionadoMinorista);
            } else if (tipoVenta.equals("Precio Mayorista")) {
                porcentajeGanancia = parsePorcentaje(porcentajeSeleccionadoMayorista);
            } else {
                // Tipo de venta no válido, asignar un valor por defecto o manejar el error según tu lógica
                porcentajeGanancia = 0.0;
            }

            sql = "UPDATE tb_ventas SET porcentajeGanancia = ? WHERE idVenta = 1"; // Actualizar porcentaje de ganancia
            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setDouble(1, porcentajeGanancia);
            statement.executeUpdate();

            cn.close();
            JOptionPane.showMessageDialog(null, "Porcentaje de ganancia actualizado correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el porcentaje de ganancia: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al actualizar el porcentaje de ganancia.");
        }
    }

    private void llenarComboBoxPorcentajes() {
        // Llenar el JComboBox de porcentaje de ganancia para minorista
        DefaultComboBoxModel<String> modeloPorcentajeMinorista = new DefaultComboBoxModel<>();
        for (int i = 0; i <= 30; i++) {
            modeloPorcentajeMinorista.addElement(i + "%");
        }
        jComboBox_porcentajeGananciaMinorista.setModel(modeloPorcentajeMinorista);
        jComboBox_porcentajeGananciaMinorista.setSelectedItem(porcentajeSeleccionadoMinorista); // Set selected item

        // Llenar el JComboBox de porcentaje de ganancia para mayorista
        DefaultComboBoxModel<String> modeloPorcentajeMayorista = new DefaultComboBoxModel<>();
        for (int i = 0; i <= 30; i++) {
            modeloPorcentajeMayorista.addElement(i + "%");
        }
        jComboBox_porcentajeGananciaMayorista.setModel(modeloPorcentajeMayorista);
        jComboBox_porcentajeGananciaMayorista.setSelectedItem(porcentajeSeleccionadoMayorista); // Set selected item
    }

    private void loadProfitPercentageValues() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            properties.load(fis);
            porcentajeSeleccionadoMinorista = properties.getProperty("porcentajeSeleccionadoMinorista", "");
            porcentajeSeleccionadoMayorista = properties.getProperty("porcentajeSeleccionadoMayorista", "");

            // Set the selected items in JComboBoxes
            jComboBox_porcentajeGananciaMinorista.setSelectedItem(porcentajeSeleccionadoMinorista);
            jComboBox_porcentajeGananciaMayorista.setSelectedItem(porcentajeSeleccionadoMayorista);
        } catch (IOException e) {
            // Handle file loading error
            e.printStackTrace();
        }
    }

    private void saveProfitPercentageValues() {
        Properties properties = new Properties();
        properties.setProperty("porcentajeSeleccionadoMinorista", porcentajeSeleccionadoMinorista);
        properties.setProperty("porcentajeSeleccionadoMayorista", porcentajeSeleccionadoMayorista);

        try (FileOutputStream fos = new FileOutputStream(CONFIG_FILE)) {
            properties.store(fos, "Saved profit percentage values");
        } catch (IOException e) {
            // Handle file saving error
            e.printStackTrace();
        }
    }

    //ESTE ES EL METODO QUE DEBO REVISAR PARA VER EL ERROR EN EL MONTO DE VENTA AL DESCARGAR EL PDF
    // Método para guardar una venta en la base de datos
    private boolean guardarVenta(Venta venta, String tipoVenta) {
        // Obtener el precio del producto según el tipo de venta seleccionado
        double precioProducto = obtenerPrecioProducto(tipoVenta);

        // Calcular el monto basado en la cantidad y el precio del producto
        double monto = venta.getCantidad() * precioProducto;

        // Obtener el porcentaje de ganancia seleccionado desde el JComboBox según el tipo de venta
        String porcentajeSeleccionado = obtenerPorcentajeSeleccionado(tipoVenta);

        // Calcular el porcentaje de ganancia
        double porcentajeGanancia = calcularPorcentajeGanancia(tipoVenta, porcentajeSeleccionado);

        // Calcular la ganancia
        double ganancia = monto * porcentajeGanancia;

        // Crear la consulta SQL para insertar la venta en la base de datos
        String sql = "INSERT INTO tb_ventas (fechaVenta, vendedor, producto, cantidad, monto, tipoVenta, porcentajeGanancia, idVendedor) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setDate(1, new java.sql.Date(venta.getFechaVenta().getTime()));
            statement.setString(2, venta.getVendedor());
            statement.setString(3, venta.getProducto());
            statement.setInt(4, venta.getCantidad());
            statement.setDouble(5, monto); // Utilizar el monto calculado
            statement.setString(6, tipoVenta);
            statement.setDouble(7, porcentajeGanancia); // Agregar el porcentaje de ganancia calculado
            statement.setInt(8, venta.getIdVendedor()); // Asignar el ID del vendedor

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                cn.close(); // Cerrar la conexión aquí después de realizar todas las operaciones necesarias
                return true;
            } else {
                cn.close(); // En caso de error, cerrar la conexión antes de retornar false
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al guardar la venta: " + ex.getMessage());
            return false;
        }
    }

    private String obtenerPorcentajeSeleccionado(String tipoVenta) {
        String porcentajeSeleccionado = ""; // Valor por defecto o inicializar con el valor correcto según tu lógica

        if (tipoVenta.equals("Precio Minorista")) {
            porcentajeSeleccionado = jComboBox_porcentajeGananciaMinorista.getSelectedItem().toString();
        } else if (tipoVenta.equals("Precio Mayorista")) {
            porcentajeSeleccionado = jComboBox_porcentajeGananciaMayorista.getSelectedItem().toString();
        }

        return porcentajeSeleccionado;
    }

    // Método para calcular el porcentaje de ganancia según el tipo de venta
    private double calcularPorcentajeGanancia(String tipoVenta, String porcentajeSeleccionado) {
        double porcentajeGanancia = 0.0;

        // Obtener el porcentaje de ganancia desde el JComboBox según el tipo de venta
        switch (tipoVenta) {
            case "Precio Minorista":
                porcentajeGanancia = parsePorcentaje(porcentajeSeleccionado);
                break;
            case "Precio Mayorista":
                porcentajeGanancia = parsePorcentaje(porcentajeSeleccionado);
                break;
            default:
                porcentajeGanancia = 0.0; // Valor por defecto si el tipo de venta no es válido
                break;
        }
        return porcentajeGanancia;
    }

    // Método auxiliar para parsear el porcentaje seleccionado en el JComboBox
    private double parsePorcentaje(String porcentajeSeleccionado) {
        if (porcentajeSeleccionado != null) {
            // Eliminar el símbolo de porcentaje (%) y convertir a double
            return Double.parseDouble(porcentajeSeleccionado.replace("%", "")) / 100.0;
        } else {
            // Manejar el caso en el que porcentajeSeleccionado sea nulo
            System.out.println("Error: porcentajeSeleccionado es nulo.");
            return 0.0; // O cualquier otro valor predeterminado que desees
        }
    }

    /*
* Método para cargar los productos existentes en el combo box jComboBox_producto
     */
    private void cargarProductos() {
        Connection cn = Conexion.conectar();
        String sql = "SELECT nombre FROM tb_producto";
        PreparedStatement ps;

        try {
            ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            jComboBox_producto.removeAllItems();
            jComboBox_producto.addItem("Seleccione producto:");
            while (rs.next()) {
                jComboBox_producto.addItem(rs.getString("nombre"));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al cargar productos existentes: " + e.getMessage());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_guardarVenta;
    private javax.swing.JComboBox<String> jComboBox_cantidad;
    private javax.swing.JComboBox<String> jComboBox_porcentajeGananciaMayorista;
    private javax.swing.JComboBox<String> jComboBox_porcentajeGananciaMinorista;
    private javax.swing.JComboBox<String> jComboBox_producto;
    private javax.swing.JComboBox<String> jComboBox_tipo_ventas;
    private javax.swing.JComboBox<String> jComboBox_vendedor;
    private com.toedter.calendar.JDateChooser jDateChooser_fechaVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JTextField jTextField_monto;
    // End of variables declaration//GEN-END:variables

}
