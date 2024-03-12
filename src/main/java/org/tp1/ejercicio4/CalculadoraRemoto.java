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
        long sumar(long a, long b) throws RemoteException;

        /**
         * Calcula la resta de dos numeros
         * @param a numero ingresado
         * @param b numero ingresado
         * @return resultado de la resta de a y b
         */
        long restar(long a, long b) throws RemoteException;

        /**
         * Calcula la multiplicacion de dos numeros
         * @param a numero ingresado
         * @param b numero ingresado
         * @return resultado de la multiplicacion de a y b
         */
        long multiplicar (long a, long b) throws RemoteException;

        /**
         * Calcula la division de dos numeros
         * @param a numero ingresado
         * @param b numero ingresado
         * @return resultado de la division de a y b
         */
        long dividir (long a, long b) throws RemoteException;


}
