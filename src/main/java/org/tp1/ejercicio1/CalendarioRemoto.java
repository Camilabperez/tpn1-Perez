package org.tp1.ejercicio1;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalendarioRemoto extends Remote{
        /**
         * Devuelve fecha y hora actual
         * @return String con fecha y hora actual
         */
        String consultarFechayHora() throws RemoteException;

}
