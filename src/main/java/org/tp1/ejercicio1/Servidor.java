package org.tp1.ejercicio1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

class Servidor {
    static final Logger logger = LogManager.getLogger(Servidor.class);

    public static void main(String[] args) throws RemoteException
    {
        LocateRegistry.createRegistry(1099);
        Calendario calendarioRemoto = new Calendario();
        try {
            Naming.rebind("//localhost/CalendarioRemoto", calendarioRemoto);
        } catch (MalformedURLException ex) {
            logger.error(ex.getMessage());
        }

        logger.info("Listo el registro");

    }

}

