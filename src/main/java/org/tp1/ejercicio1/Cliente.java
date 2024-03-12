package org.tp1.ejercicio1;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Logger;

public class Cliente {
    static Logger logger = Logger.getLogger(Cliente.class.getName());

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        CalendarioRemoto calendarioRemoto =
                (CalendarioRemoto)Naming.lookup("//localhost/CalendarioRemoto");

        String fechaYHora = calendarioRemoto.consultarFechayHora();

        logger.info(() -> fechaYHora);
    }
}
