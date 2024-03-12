package org.tp1.ejemplo;

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
        HolaMundo objetoRemoto = new HolaMundo();
        try {
            Naming.rebind("//localhost/holaMundo", objetoRemoto);
        } catch (MalformedURLException ex) {
            logger.severe(null + ex.getMessage());
        }

        logger.info("Listo el registro");

    }

}

