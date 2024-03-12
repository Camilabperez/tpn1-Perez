package org.tp1.ejemplo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HolaMundo extends UnicastRemoteObject implements HolaMundoRemoto {

    HolaMundo () throws RemoteException { }
    @Override
    public String saludar(String nombre) throws RemoteException {
        return "hola --> " + nombre;
    }
}

