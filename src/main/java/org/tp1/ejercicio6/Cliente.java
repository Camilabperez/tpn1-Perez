package org.tp1.ejercicio6;

import javax.swing.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Logger;

public class Cliente {
    private static CodigoBarraRemoto codigoBarraRemoto;
    static Logger logger = Logger.getLogger(Cliente.class.getName());
    private static JTextField inputCodigo;
    private static JButton btnIngresar;
    private static JLabel labelEstado;

    /**
     * Para inicializar la base de datos e insertar algunos elementos por primera vez
     * es necesario compilar main() de CodigoBarra.java
     * Datos ejemplos para ingresar cliente:
     * "123456789"
     * "234567891"
     * "345678912"
     */
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
         codigoBarraRemoto =
                (CodigoBarraRemoto)Naming.lookup("//localhost/CodigoBarraRemoto");
         crearVentana();
    }

    private static void crearVentana() {
        JFrame frame = new JFrame("Lector Codigo de Barra");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        iniciarComponentes(frame);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void iniciarComponentes(JFrame frame) {
        JLabel codeLabel = new JLabel("Codigo:");
        inputCodigo = new JTextField(20);
        btnIngresar = new JButton("Ingresar");
        labelEstado = new JLabel("  ");

        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(codeLabel)
                        .addComponent(inputCodigo))
                .addComponent(btnIngresar, GroupLayout.Alignment.CENTER)
                .addComponent(labelEstado, GroupLayout.Alignment.CENTER));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(codeLabel)
                        .addComponent(inputCodigo))
                .addComponent(btnIngresar)
                .addComponent(labelEstado));

        frame.add(panel);
        setListener();
    }

    private static void setListener() {
        btnIngresar.addActionListener(e -> {
            String codigo = inputCodigo.getText();
            try {
                labelEstado.setText(codigoBarraRemoto.consultar(Integer.parseInt(codigo)));
            } catch (RemoteException ex) {
                logger.severe("Error en la comunicación remota: " + ex.getMessage());
            }
        });
    }
}
