package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.Conexion;
import java.awt.Desktop;
import java.sql.Connection;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivon
 */
public class Reportes {

    /* *******************************************************************
    * Metodo para crear reportes de los clientes registrados en el sistema
    ******************************************************************* */
    public void ReportesClientes() {

        Document documento = new Document();
        try {
            String rutaCarpeta = System.getProperty("user.home") + "/Escritorio/pdf/";
            File carpetaPDF = new File(rutaCarpeta);
            if (!carpetaPDF.exists()) {
                carpetaPDF.mkdirs();
            }
            String ruta = rutaCarpeta + "Reporte_Clientes.pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            Image header = Image.getInstance("src/img/header1.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            //Dar formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \nIvon Ocaño © Innovode\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Clientes \n\n");

            documento.open();
            //Agregamos los datos
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("Codigo");
            tabla.addCell("Nombres");
            tabla.addCell("Dni");
            tabla.addCell("Telefono");
            tabla.addCell("Direccion");

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select idCliente, concat (nombre, ' ', apellido) as nombres, dni, telefono, direccion from tb_cliente");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                    } while (rs.next());
                    documento.add(tabla);
                }
            } catch (SQLException e) {
                System.out.println("Error 4 en:" + e);
            }
            documento.close();

            JOptionPane.showMessageDialog(null, "Reporte creado");
            // Abrir el archivo PDF después de generarlo
            Desktop.getDesktop().open(new File(ruta));

        } catch (DocumentException e) {
            System.out.println("Error 1 en: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2 en: " + ex);
        } catch (IOException ex) {
            System.out.println("Error 3 en: " + ex);
        }
    }

    /* *******************************************************************
    * Metodo para crear reportes de los clientes registrados en el sistema
    ******************************************************************* */
//    public void ReportesProductos() {
//
//        Document documento = new Document();
//        try {
//            String rutaCarpeta = System.getProperty("user.home") + "/Escritorio/pdf/";
//            File carpetaPDF = new File(rutaCarpeta);
//            if (!carpetaPDF.exists()) {
//                carpetaPDF.mkdirs();
//            }
//            String ruta = rutaCarpeta + "Reporte_Productos.pdf";
//            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
//            Image header = Image.getInstance("src/img/header1.jpg");
//            header.scaleToFit(650, 1000);
//            header.setAlignment(Chunk.ALIGN_CENTER);
//
//            //Dar formato al texto
//            Paragraph parrafo = new Paragraph();
//            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
//            parrafo.add("Reporte creado por \nIvon Ocaño © Innovode\n\n");
//            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
//            parrafo.add("Reporte de Productos \n\n");
//
//            documento.open();
//            //Agregamos los datos
//            documento.add(header);
//            documento.add(parrafo);
//            
//            float[] columnsWidths = {3, 5, 4, 5, 7, 5, 6};
//
//            PdfPTable tabla = new PdfPTable(columnsWidths);
//            tabla.addCell("Codigo");
//            tabla.addCell("Nombre");
//            tabla.addCell("Cant.");
//            tabla.addCell("Precio");
//            tabla.addCell("Descripcion");
//            tabla.addCell("P.");
//            tabla.addCell("Direccion");
//
//            try {
//                Connection cn = Conexion.conectar();
//                PreparedStatement pst = cn.prepareStatement(
//                        "select idCliente, concat (nombre, ' ', apellido) as nombres, dni, telefono, direccion from tb_cliente");
//                ResultSet rs = pst.executeQuery();
//
//                if (rs.next()) {
//                    do {
//                        tabla.addCell(rs.getString(1));
//                        tabla.addCell(rs.getString(2));
//                        tabla.addCell(rs.getString(3));
//                        tabla.addCell(rs.getString(4));
//                        tabla.addCell(rs.getString(5));
//                    } while (rs.next());
//                    documento.add(tabla);
//                }
//            } catch (SQLException e) {
//                System.out.println("Error 4 en:" + e);
//            }
//            documento.close();
//
//            JOptionPane.showMessageDialog(null, "Reporte creado");
//            // Abrir el archivo PDF después de generarlo
//            Desktop.getDesktop().open(new File(ruta));
//
//        } catch (DocumentException e) {
//            System.out.println("Error 1 en: " + e);
//        } catch (FileNotFoundException ex) {
//            System.out.println("Error 2 en: " + ex);
//        } catch (IOException ex) {
//            System.out.println("Error 3 en: " + ex);
//        }
//    }

    /* *******************************************************************
    * Metodo para crear reportes de las ventas registradas en el sistema
    ******************************************************************* */
    public void ReportesVentas() {

        Document documento = new Document();
        try {
            String rutaCarpeta = System.getProperty("user.home") + "/Escritorio/pdf/";
            File carpetaPDF = new File(rutaCarpeta);
            if (!carpetaPDF.exists()) {
                carpetaPDF.mkdirs();
            }
            String ruta = rutaCarpeta + "Reporte_Ventas.pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            Image header = Image.getInstance("src/img/header1.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            //Dar formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \nIvon Ocaño © Innovode\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Ventas \n\n");

            documento.open();
            //Agregamos los datos
            documento.add(header);
            documento.add(parrafo);

            float[] columnsWidths = {3, 9, 4, 5, 3};

            PdfPTable tabla = new PdfPTable(columnsWidths);
            tabla.addCell("Codigo");
            tabla.addCell("Cliente");
            tabla.addCell("Tot. Pagar");
            tabla.addCell("Fecha Venta");
            tabla.addCell("Estado");

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select cv.idCabeceraVenta as id, concat(c.nombre, ' ', c.apellido) as cliente, cv.valorPagar as total, cv.fechaVenta as fecha,"
                        + " cv.estado from tb_cabecera_venta as cv, tb_cliente as c where cv.idCliente = c.idCliente;");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                    } while (rs.next());
                    documento.add(tabla);
                }
            } catch (SQLException e) {
                System.out.println("Error 4 en:" + e);
            }
            documento.close();

            JOptionPane.showMessageDialog(null, "Reporte creado");
            // Abrir el archivo PDF después de generarlo
            Desktop.getDesktop().open(new File(ruta));
        } catch (DocumentException e) {
            System.out.println("Error 1 en: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2 en: " + ex);
        } catch (IOException ex) {
            System.out.println("Error 3 en: " + ex);
        }
    }

    public void ReportesProductos() {
        Document documento = new Document();
        try {
            String rutaCarpeta = System.getProperty("user.home") + "/Escritorio/pdf/";
            File carpetaPDF = new File(rutaCarpeta);
            if (!carpetaPDF.exists()) {
                carpetaPDF.mkdirs();
            }
            String ruta = rutaCarpeta + "Reporte_Productos.pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            Image header = Image.getInstance("src/img/header1.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            // Dar formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \nIvon Ocaño © Innovode\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte Productos \n\n");

            documento.open();
            //Agregamos los datos
            documento.add(header);
            documento.add(parrafo);

            // Crear la tabla y definir las columnas
            float[] columnsWidths = {8f, 13f, 12f, 12f, 12f};
            PdfPTable tabla = new PdfPTable(columnsWidths);
            tabla.addCell("ID Venta");
            tabla.addCell("Fecha de Venta");
            tabla.addCell("Producto");
            tabla.addCell("Cantidad");
            tabla.addCell("Monto");

            // Obtener los datos de ventas y agregarlos a la tabla
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "SELECT v.idVenta, v.fechaVenta, p.nombre AS producto, dv.cantidad, dv.totalPagar, v.monto "
                        + "FROM tb_ventas v "
                        + "JOIN tb_detalle_venta dv ON v.idVenta = dv.idCabeceraVenta "
                        + "JOIN tb_producto p ON dv.idProducto = p.idProducto");
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    tabla.addCell(rs.getString("idVenta"));
                    tabla.addCell(rs.getString("fechaVenta"));
                    tabla.addCell(rs.getString("producto"));
                    tabla.addCell(rs.getString("cantidad"));
                    tabla.addCell(rs.getString("monto"));
                }

                // Agregar la tabla al documento
                documento.add(tabla);
                documento.close();

                JOptionPane.showMessageDialog(null, "Reporte de Productos creado correctamente");
                // Abrir el archivo PDF después de generarlo
                Desktop.getDesktop().open(new File(ruta));

            } catch (SQLException e) {
                System.out.println("Error al obtener datos de ventas: " + e);
            }

        } catch (DocumentException e) {
            System.out.println("Error al generar el reporte: " + e);
        } catch (FileNotFoundException e) {
            System.out.println("Error al encontrar el archivo: " + e);
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e);
        }
    }

}
