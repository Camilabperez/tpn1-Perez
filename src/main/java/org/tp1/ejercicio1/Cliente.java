package org.tp1.ejercicio1;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cliente {
    static final Logger logger = LogManager.getLogger(Cliente.class);

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        CalendarioRemoto calendarioRemoto =
                (CalendarioRemoto)Naming.lookup("//localhost/CalendarioRemoto");

        String fechaYHora = calendarioRemoto.consultarFechayHora();

        logger.info(() -> fechaYHora);
    }
}
