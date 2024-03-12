package org.tp1.ejercicio4;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Calculadora extends UnicastRemoteObject implements CalculadoraRemoto {
    Calculadora() throws RemoteException { }

    @Override
    public long sumar(long a, long b) throws RemoteException{
        return a + b;
    }

    @Override
    public long restar(long a, long b) throws RemoteException{
        return a - b;
    }

    @Override
    public long multiplicar (long a, long b) throws RemoteException{
        return a * b;
    }

    @Override
    public long dividir (long a, long b) throws RemoteException{
        return a / b;
    }

}
