package org.tp1.ejercicio5;

import javax.swing.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cliente {
    private static LoginRemoto loginRemoto;
    static Logger logger = LogManager.getLogger(Cliente.class);
    private static JTextField inputUsuario;
    private static JPasswordField inputClave;
    private static JButton btnIngresar;
    private static JLabel statusLabel;

    /**
     * Para inicializar la base de datos e insertar algunos elementos por primera vez
     * es necesario compilar main() en Login.java
     * Datos ejemplos para ingresar cliente:
     * "usuario1", "contrasena1"
     * "usuario2", "contrasena2"
     * "usuario3", "contrasena3"
     */

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
         loginRemoto =
                (LoginRemoto)Naming.lookup("//localhost/LoginRemoto");
         crearVentana();
    }

    private static void crearVentana() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        iniciarComponentes(frame);
        frame.setSize(250, 180);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void iniciarComponentes(JFrame frame) {
        JLabel usernameLabel = new JLabel("Usuario:");
        JLabel passwordLabel = new JLabel("Clave:");
        inputUsuario = new JTextField(20);
        inputClave = new JPasswordField(20);
        btnIngresar = new JButton("Ingresar");
        statusLabel = new JLabel("  ");

        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(usernameLabel)
                                .addComponent(passwordLabel))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(inputUsuario)
                                .addComponent(inputClave)))
                .addComponent(btnIngresar, GroupLayout.Alignment.CENTER)
                .addComponent(statusLabel, GroupLayout.Alignment.CENTER));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(usernameLabel)
                        .addComponent(inputUsuario))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(passwordLabel)
                        .addComponent(inputClave))
                .addComponent(btnIngresar)
                .addComponent(statusLabel));

        frame.add(panel);
        setListener();
    }

    private static void setListener() {
        btnIngresar.addActionListener(e -> {
            String username = inputUsuario.getText();
            String password = new String(inputClave.getPassword());

            try {
                boolean validado = loginRemoto.validar(username,password);
                if (validado) {
                    statusLabel.setText("Inicio de sesion exitoso");
                } else {
                    statusLabel.setText("Usuario o clave incorrectos");
                }
            } catch (RemoteException ex) {
                logger.error("Error en la comunicación remota: {}", ex.getMessage());
            }
        });
    }
}
