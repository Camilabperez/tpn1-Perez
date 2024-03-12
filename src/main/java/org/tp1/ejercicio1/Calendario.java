package org.tp1.ejercicio1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calendario extends UnicastRemoteObject implements CalendarioRemoto {

    Calendario () throws RemoteException { }

    @Override
    public String consultarFechayHora() throws RemoteException {
        Date fechaActual = new Date();

        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = formatoFecha.format(fechaActual);

        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        String horaFormateada = formatoHora.format(fechaActual);

        return "Hoy es " + fechaFormateada + " y la hora es " + horaFormateada;
    }
}
