package vista;


import conexion.Conexion;
import java.awt.Desktop;
import java.awt.Dimension;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Ivono
 */
public class InterDescargarVentas extends javax.swing.JInternalFrame {

    public InterDescargarVentas() {
        initComponents();
        setTitle("Descargar Ventas");
        setSize(new Dimension(428, 447));

        //Insertar imagen en nuestro jLabel
        ImageIcon wallpaper = new ImageIcon("src/img/fondo3.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(428, 447, WIDTH));
        jLabel_wallpaper.setIcon(icono);
        this.repaint();
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
        jDateChooser_fecha_inicio = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser_fecha_fin = new com.toedter.calendar.JDateChooser();
        jButton_descargar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Descargar Ventas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha Inicio:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));
        getContentPane().add(jDateChooser_fecha_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 160, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha Fin:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));
        getContentPane().add(jDateChooser_fecha_fin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 160, -1));

        jButton_descargar.setBackground(new java.awt.Color(51, 102, 255));
        jButton_descargar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_descargar.setText("Descargar");
        jButton_descargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_descargarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_descargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 333, 130, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Seleccione fechas para descargar las ventas:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 420, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_descargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_descargarActionPerformed
        // Obtener las fechas seleccionadas
        java.util.Date fechaInicio = jDateChooser_fecha_inicio.getDate();
        java.util.Date fechaFin = jDateChooser_fecha_fin.getDate();

        // Validar que las fechas no sean nulas
        if (fechaInicio == null || fechaFin == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar ambas fechas.");
            return;
        }

        // Convertir las fechas a formato compatible con SQL (java.sql.Date)
        java.sql.Date fechaInicioSQL = new java.sql.Date(fechaInicio.getTime());
        java.sql.Date fechaFinSQL = new java.sql.Date(fechaFin.getTime());

        // Llamar al método para generar el reporte de ventas
        generarReporteVentasExcel(fechaInicioSQL, fechaFinSQL);
    }//GEN-LAST:event_jButton_descargarActionPerformed

    /* Método para generar el reporte de ventas basado en un rango de fechas */
    public void generarReporteVentasExcel(java.sql.Date fechaInicio, java.sql.Date fechaFin) {
        // Define la ruta completa del archivo con su nombre y extensión
        String rutaCarpeta = System.getProperty("user.home") + "/Escritorio/Excel/";
        File carpetaExcel = new File(rutaCarpeta);
        if (!carpetaExcel.exists()) {
            carpetaExcel.mkdirs();
        }
        String rutaArchivo = rutaCarpeta + "Reporte_Ventas.xlsx";

        // Crear un libro de trabajo Excel y una hoja
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Ventas");

        // Crear la cabecera del reporte
        Row headerRow = sheet.createRow(0);
        String[] columnas = {"Codigo", "Cliente", "Tot. Pagar", "Fecha Venta", "Estado"};
        for (int i = 0; i < columnas.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columnas[i]);
        }

        try {
            // Obtener datos de la base de datos y llenar el reporte
            Connection con = Conexion.conectar();  // Establecer conexión a tu base de datos
            PreparedStatement stmt = con.prepareStatement("SELECT cv.idCabeceraVenta AS id, CONCAT(c.nombre, ' ', c.apellido) AS cliente, cv.valorPagar AS total, cv.fechaVenta AS fecha,"
                    + " cv.estado FROM tb_cabecera_venta AS cv, tb_cliente AS c WHERE cv.idCliente = c.idCliente"
                    + " AND cv.fechaVenta BETWEEN ? AND ?"
                    + "ORDER BY cv.fechaVenta DESC;");
            stmt.setDate(1, fechaInicio);
            stmt.setDate(2, fechaFin);

            ResultSet rs = stmt.executeQuery();

            int rowNum = 1;
            while (rs.next()) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(rs.getString("id"));
                row.createCell(1).setCellValue(rs.getString("cliente"));
                row.createCell(2).setCellValue(rs.getDouble("total"));
                row.createCell(3).setCellValue(rs.getDate("fecha").toString());
                int estado = rs.getInt("estado");
                String estadoTexto = (estado == 1) ? "Activo" : "Inactivo";
                row.createCell(4).setCellValue(estadoTexto);
            }

            // Guardar el libro de trabajo en el archivo especificado
            try (FileOutputStream outputStream = new FileOutputStream(rutaArchivo)) {
                workbook.write(outputStream);
                JOptionPane.showMessageDialog(this, "Reporte de ventas generado con éxito");

                // Abrir el archivo después de guardarlo
                File archivo = new File(rutaArchivo);
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(archivo);
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo abrir el archivo automáticamente.");
                }
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al guardar el archivo.");
            }

            con.close();  // Cerrar la conexión después de utilizarla

        } catch (SQLException e) {
            e.printStackTrace(System.err);
            JOptionPane.showMessageDialog(this, "Error al generar el reporte de ventas.");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_descargar;
    private com.toedter.calendar.JDateChooser jDateChooser_fecha_fin;
    private com.toedter.calendar.JDateChooser jDateChooser_fecha_inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_wallpaper;
    // End of variables declaration//GEN-END:variables
}
