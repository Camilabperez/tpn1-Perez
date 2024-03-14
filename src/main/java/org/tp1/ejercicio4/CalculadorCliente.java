package org.tp1.ejercicio4;

import javax.swing.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CalculadorCliente {
    static Logger logger = LogManager.getLogger(CalculadorCliente.class);
    private static CalculadoraRemoto calculadoraRemoto;
    private static JTextField inputA;
    private static JTextField inputB;
    private static ButtonGroup btnOperadores;
    private static JLabel labelResultado;

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
         calculadoraRemoto =
                (CalculadoraRemoto)Naming.lookup("//localhost/CalculadoraRemoto");
         crearVentana();
    }

    private static void crearVentana() {
        JFrame frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        iniciarComponentes(frame);
        frame.setSize(250, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void iniciarComponentes(JFrame frame) {
        JLabel labelA = new JLabel("Numero A:");
        JLabel labelB = new JLabel("Numero B:");
        labelResultado = new JLabel("  ", SwingConstants.LEFT);
        inputA = new JTextField();
        inputB = new JTextField();
        JButton btnCalcular = new JButton("Calcular");

        Box boxOperadores = Box.createHorizontalBox();
        btnOperadores = new ButtonGroup();
        for (String operador : new String[]{"+", "-", "*", "/"}) {
            JToggleButton btnOperador = new JToggleButton(operador);
            btnOperador.setActionCommand(operador);
            boxOperadores.add(btnOperador);
            btnOperadores.add(btnOperador);
        }

        btnCalcular.addActionListener(e -> calcularResultado());

        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(labelA)
                .addComponent(inputA)
                .addComponent(labelB)
                .addComponent(inputB)
                .addComponent(boxOperadores)
                .addComponent(btnCalcular)
                .addComponent(labelResultado));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(labelA)
                .addComponent(inputA)
                .addComponent(labelB)
                .addComponent(inputB)
                .addComponent(boxOperadores)
                .addComponent(btnCalcular)
                .addComponent(labelResultado));

        frame.add(panel);
    }

    private static void calcularResultado() {
        try {
            String num1 = inputA.getText();
            String num2 = inputB.getText();

            if (num1.isEmpty() || num2.isEmpty()) {
                labelResultado.setText("Ingrese ambos valores");
                return;
            }

            double op1 = Double.parseDouble(num1);
            double op2 = Double.parseDouble(num2);

            String oper = btnOperadores.getSelection().getActionCommand();

            double resultado;
            switch (oper) {
                case "+" -> resultado = calculadoraRemoto.sumar(op1, op2);
                case "-" -> resultado = calculadoraRemoto.restar(op1, op2);
                case "*" -> resultado = calculadoraRemoto.multiplicar(op1, op2);
                case "/" -> {
                    if (op2 != 0) {
                        resultado = calculadoraRemoto.dividir(op1, op2);
                    } else {
                        labelResultado.setText("No es posible dividir por cero");
                        return;
                    }
                }
                default -> {
                    labelResultado.setText("Operador no valido");
                    return;
                }
            }

            labelResultado.setText("Resultado: " + resultado);
        } catch (NumberFormatException ex) {
            labelResultado.setText("Los valores deben ser numeros");
        } catch (RemoteException | RuntimeException ex) {
            logger.error("Error al realizar la operacion: {}", ex.getMessage());
            labelResultado.setText("Error al realizar la operacion");
        }
    }
}
