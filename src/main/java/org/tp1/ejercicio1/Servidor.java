package org.tp1.ejercicio1;

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
        Calendario calendarioRemoto = new Calendario();
        try {
            Naming.rebind("//localhost/CalendarioRemoto", calendarioRemoto);
        } catch (MalformedURLException ex) {
            logger.severe(null + ex.getMessage());
        }

        logger.info("Listo el registro");

    }

}

