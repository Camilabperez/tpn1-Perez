package org.tp1.ejercicio3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Potencia extends UnicastRemoteObject implements PotenciaRemoto {
    Potencia() throws RemoteException { }

    @Override
    public long square(int n) throws RemoteException {
        return (long) n * n;
    }

    @Override
    public long pow(int n1, int n2) throws RemoteException {
        return (long) Math.pow(n1, n2);
    }

}
