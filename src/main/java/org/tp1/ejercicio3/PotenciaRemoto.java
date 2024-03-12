package org.tp1.ejercicio3;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PotenciaRemoto extends Remote{

        /**
         * Calcula el cuadrado de un numero
         * @param n numero entero
         * @return resultado del cuadrado del numero ingresado
         */
        long square(int n) throws RemoteException;

        /**
         * Calcula de la potencia de un numero
         * @param n1 numero entero
         * @param n2 numero entero
         * @return resultado de la potencia de n1 a la n2
         */
        long pow(int n1, int n2) throws RemoteException;

}
