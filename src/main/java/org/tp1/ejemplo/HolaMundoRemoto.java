package org.tp1.ejemplo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HolaMundoRemoto extends Remote {
    String saludar(String nombre) throws RemoteException;

}
