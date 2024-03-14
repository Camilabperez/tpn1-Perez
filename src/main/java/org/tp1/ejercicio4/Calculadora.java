package org.tp1.ejercicio4;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Calculadora extends UnicastRemoteObject implements CalculadoraRemoto {
    Calculadora() throws RemoteException { }

    @Override
    public double sumar(double a, double b) throws RemoteException{
        return a + b;
    }

    @Override
    public double restar(double a, double b) throws RemoteException{
        return a - b;
    }

    @Override
    public double multiplicar (double a, double b) throws RemoteException{
        return a * b;
    }

    @Override
    public double dividir (double a, double b) throws RemoteException{
        return a / b;
    }

}
