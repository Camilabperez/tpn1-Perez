package org.tp1.ejercicio5;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Logger;

class Servidor {
    static Logger logger = Logger.getLogger(Servidor.class.getName());

    public static void main(String[] args) throws RemoteException
    {
        LocateRegistry.createRegistry(1099);
        Login loginRemoto = new Login();
        try {
            Naming.rebind("//localhost/LoginRemoto", loginRemoto);
        } catch (MalformedURLException ex) {
            logger.severe(null + ex.getMessage());
        }

        logger.info("Listo el registro");

    }

}

