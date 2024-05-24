package vista;

import java.sql.PreparedStatement;
import java.sql.Connection;
import conexion.Conexion;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivon
 */
public class InterGestionarVendedores extends javax.swing.JInternalFrame {

    private int idVendedor;

    public InterGestionarVendedores() {
        initComponents();
        this.setSize(new Dimension(900, 500));
        this.setTitle("Gestionar Vendedores");
        
         //Insertar imagen en nuestro jLabel
        ImageIcon wallpaper = new ImageIcon("src/img/fondo3.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(900, 500, WIDTH));
        jLabel_wallpaper.setIcon(icono);
        this.repaint();


        this.CargarTablaVendedores();

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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_vendedores = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_actualizar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_apellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Administrar Vendedores");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_vendedores.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable_vendedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "idVendedor", "Nombre", "Apellido", "Correo Electronico"
            }
        ));
        jScrollPane1.setViewportView(jTable_vendedores);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 730, 270));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_actualizar.setBackground(new java.awt.Color(51, 204, 0));
        jButton_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButton_eliminar.setBackground(new java.awt.Color(255, 51, 51));
        jButton_eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 90, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 130, 270));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, -1));

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 170, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Apellido:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 50, 100, -1));

        txt_apellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_apellidoActionPerformed(evt);
            }
        });
        jPanel3.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 170, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Correo Electronico:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 150, -1));

        txt_correo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 170, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 870, 100));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed

        if (!txt_nombre.getText().isEmpty() && !txt_apellido.getText().isEmpty()) {
            try {
                Connection con = Conexion.conectar();
                String sql = "UPDATE tb_vendedor SET nombre = ?, apellido = ?, correoElectronico = ? WHERE idVendedor = ?";
                PreparedStatement pst = con.prepareStatement(sql);

                pst.setString(1, txt_nombre.getText().trim());
                pst.setString(2, txt_apellido.getText().trim());
                pst.setString(3, txt_correo.getText().trim());
                pst.setInt(4, idVendedor); // idVendedor se obtiene al seleccionar un vendedor en la tabla

                int resultado = pst.executeUpdate();
                if (resultado > 0) {
                    JOptionPane.showMessageDialog(null, "Vendedor actualizado correctamente");
                    Limpiar(); // Limpia los campos después de actualizar
                    CargarTablaVendedores(); // Vuelve a cargar la tabla de vendedores con los datos actualizados
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar vendedor");
                }
                con.close();

            } catch (SQLException e) {
                System.out.println("Error al actualizar vendedor: " + e);
                JOptionPane.showMessageDialog(null, "Error al actualizar vendedor");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        }
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed

        if (idVendedor != 0) {
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este vendedor?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                try {
                    Connection con = Conexion.conectar();
                    String sql = "DELETE FROM tb_vendedor WHERE idVendedor = ?";
                    PreparedStatement pst = con.prepareStatement(sql);

                    pst.setInt(1, idVendedor); // idVenta se obtiene al seleccionar un vendedor en la tabla

                    int resultado = pst.executeUpdate();
                    if (resultado > 0) {
                        JOptionPane.showMessageDialog(null, "Vendedor eliminado correctamente");
                        Limpiar(); // Limpia los campos después de eliminar
                        CargarTablaVendedores(); // Vuelve a cargar la tabla de vendedores sin el vendedor eliminado
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al eliminar vendedor");
                    }
                    con.close();

                } catch (SQLException e) {
                    System.out.println("Error al eliminar vendedor: " + e);
                    JOptionPane.showMessageDialog(null, "Error al eliminar vendedor");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un vendedor para eliminar");
        }

    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void txt_apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_apellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_apellidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_vendedores;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables

    /*
    * Método para limpiar
    *
     */
    private void Limpiar() {
        txt_nombre.setText("");
        txt_apellido.setText("");
        txt_correo.setText("");
    }

    private void CargarTablaVendedores() {
        Connection con = Conexion.conectar();

        DefaultTableModel model = (DefaultTableModel) jTable_vendedores.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos

        String sql = "SELECT idVendedor, nombre, apellido, correoElectronico FROM tb_vendedor";
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Object fila[] = {rs.getInt("idVendedor"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("correoElectronico")}; // Agrega apellido y correo a la fila
                model.addRow(fila);
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla de vendedores: " + e);
        }

        jTable_vendedores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_vendedores.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idVendedor = (int) model.getValueAt(fila_point, columna_point);
                    // Aquí puedes agregar lógica adicional al hacer clic en un vendedor
                    // Por ejemplo, puedes cargar los datos del vendedor en los campos de texto
                    txt_nombre.setText(model.getValueAt(fila_point, 1).toString()); // 1 es la columna del nombre del vendedor
                    txt_apellido.setText(model.getValueAt(fila_point, 2).toString()); // 2 es la columna del apellido del vendedor
                    txt_correo.setText(model.getValueAt(fila_point, 3).toString()); // 3 es la columna del correo electrónico del vendedor
                }
            }
        });
    }
}