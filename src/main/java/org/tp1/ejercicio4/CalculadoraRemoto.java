package org.tp1.ejercicio4;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculadoraRemoto extends Remote{

        /**
         * Calcula la suma de dos numeros
         * @param a numero ingresado
         * @param b numero ingresdo
         * @return resultado de la suma de a y b
         */
        double sumar(double a, double b) throws RemoteException;

        /**
         * Calcula la resta de dos numeros
         * @param a numero ingresado
         * @param b numero ingresado
         * @return resultado de la resta de a y b
         */
        double restar(double a, double b) throws RemoteException;

        /**
         * Calcula la multiplicacion de dos numeros
         * @param a numero ingresado
         * @param b numero ingresado
         * @return resultado de la multiplicacion de a y b
         */
        double multiplicar (double a, double b) throws RemoteException;

        /**
         * Calcula la division de dos numeros
         * @param a numero ingresado
         * @param b numero ingresado
         * @return resultado de la division de a y b
         */
        double dividir (double a, double b) throws RemoteException;


}
