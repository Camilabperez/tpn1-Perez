package org.tp1.ejercicio6;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CodigoBarra extends UnicastRemoteObject implements CodigoBarraRemoto {
    private static final String URL = "jdbc:sqlite:productos.db";
    static Logger logger = LogManager.getLogger(CodigoBarra.class);
    CodigoBarra() throws RemoteException { }

    @Override
    public String consultar(int codigo) throws RemoteException {
        String resultadoConsulta = "No se encontró ningún producto";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement("SELECT nombre, precio FROM productos WHERE codigo = ?")) {

            pstmt.setInt(1, codigo);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                resultadoConsulta = "El producto " + nombre + " tiene un precio de " + precio;
            }
        } catch (SQLException e) {
            logger.error("Error al obtener nombre y precio por código", e);
        }

        return resultadoConsulta;
    }

    /**
     * Main y siguientes métodos se utilizan para inicializar la base de datos y
     * preparar algunos datos de ejemplo
     */
     public static void main(String[] args) throws RemoteException {
         CodigoBarra codigoBarra = new CodigoBarra();
         codigoBarra.crearTablaBD();
         codigoBarra.insertarProducto(123456789, "producto1", 10);
         codigoBarra.insertarProducto(234567891, "producto2", 12);
         codigoBarra.insertarProducto(345678912, "producto3", 18);
     }

    public void crearTablaBD(){
        String creacionTablaSQL = "CREATE TABLE IF NOT EXISTS productos ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "codigo INTEGER NOT NULL,"
                + "nombre TEXT NOT NULL,"
                + "precio NUMERIC NOT NULL"
                + ");";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {

            stmt.execute(creacionTablaSQL);
            logger.info("Tabla productos creada exitosamente");
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
    }

    public void insertarProducto(int codigo, String nombre, int precio) {
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO productos (codigo, nombre, precio) VALUES (?, ?, ?)")) {

            pstmt.setInt(1, codigo);
            pstmt.setString(2, nombre);
            pstmt.setInt(3, precio);
            pstmt.executeUpdate();
            logger.info("Usuario insertado correctamente");
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
    }


}
