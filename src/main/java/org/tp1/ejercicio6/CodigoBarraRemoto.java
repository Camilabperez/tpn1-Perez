package org.tp1.ejercicio6;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CodigoBarraRemoto extends Remote{

        /**
         * Devuelve el nombre y el precio del producto a partir de su código
         * @param codigo codigo del producto a consultar
         * @return String con el nombre y precio del producto
         */
        String consultar (int codigo) throws RemoteException;

}
