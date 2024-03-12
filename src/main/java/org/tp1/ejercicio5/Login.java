package org.tp1.ejercicio5;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.logging.Logger;

public class Login extends UnicastRemoteObject implements LoginRemoto {
    private static final String URL = "jdbc:sqlite:login.db";
    static Logger logger = Logger.getLogger(Login.class.getName());
    Login() throws RemoteException { }

    @Override
    public boolean validar (String usuario, String clave) throws RemoteException{
        boolean validado = false;
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM usuarios WHERE nombre = ? AND contrasena = ?")) {
            pstmt.setString(1, usuario);
            pstmt.setString(2, clave);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                validado = true;
            }
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
        return validado;
    }

    /**
     * Main y siguientes métodos se utilizan para inicializar la base de datos y
     * preparar algunos datos de ejemplo
     */
     public static void main(String[] args) throws RemoteException {
     Login login = new Login();
     login.crearTablaBD();
     login.insertarUsuario("usuario1", "contrasena1");
     login.insertarUsuario("usuario2", "contrasena2");
     login.insertarUsuario("usuario3", "contrasena3");
     }

    public void crearTablaBD(){
        String creacionTablaSQL = "CREATE TABLE IF NOT EXISTS usuarios ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nombre TEXT NOT NULL,"
                + "contrasena TEXT NOT NULL"
                + ");";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {

            stmt.execute(creacionTablaSQL);
            logger.info("Tabla usuarios creada exitosamente");
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
    }

    public void insertarUsuario(String nombre, String contrasena) {
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO usuarios (nombre, contrasena) VALUES (?, ?)")) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, contrasena);
            pstmt.executeUpdate();
            logger.info("Usuario insertado correctamente");
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
    }
}
