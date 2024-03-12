package org.tp1.ejemplo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Logger;

public class Cliente {
    static Logger logger = Logger.getLogger(Cliente.class.getName());

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        HolaMundoRemoto nombre =
                (HolaMundoRemoto) Naming.lookup("rmi://localhost/holaMundo");

        String saludo = "hola!! " + nombre.saludar("bele");

        logger.info(() -> saludo);
    }
}
