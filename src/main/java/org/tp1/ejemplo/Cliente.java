package org.tp1.ejemplo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cliente {
    static final Logger logger = LogManager.getLogger(Cliente.class);

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        HolaMundoRemoto nombre =
                (HolaMundoRemoto) Naming.lookup("rmi://localhost/holaMundo");

        String saludo = "hola!! " + nombre.saludar("bele");

        logger.info(() -> saludo);
    }
}
