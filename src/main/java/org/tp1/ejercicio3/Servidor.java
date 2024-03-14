package org.tp1.ejercicio3;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Servidor {
    static Logger logger = LogManager.getLogger(Servidor.class);

    public static void main(String[] args) throws RemoteException
    {
        LocateRegistry.createRegistry(1099);
        Potencia potenciaRemoto = new Potencia();
        try {
            Naming.rebind("//localhost/PotenciasRemoto", potenciaRemoto);
        } catch (MalformedURLException ex) {
            logger.error(ex.getMessage());
        }

        logger.info("Listo el registro");

    }

}

