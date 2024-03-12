package org.tp1.ejercicio2;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ConvertidorRemoto extends Remote{

        /**
         * Devuelve importe en U$$ convertido al valor del dólar oficial a la fecha
         * @param importe valor en dolar para convertir a peso.
         * @return valor en peso de importe ingresado
         */
        long pesoDolar(long importe) throws RemoteException;

        /**
         * Devuelve importe en $ convertido al valor de la cotización a la fecha
         * @param importe valor en peso para convertir a dolar.
         * @return valor en dolar de importe ingresado
         */
        long dolarPeso(long importe) throws RemoteException;

}
