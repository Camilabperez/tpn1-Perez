package org.tp1.ejercicio3;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Logger;

public class Cliente {
    static Logger logger = Logger.getLogger(Cliente.class.getName());

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        PotenciaRemoto potenciaRemoto =
                (PotenciaRemoto)Naming.lookup("//localhost/PotenciasRemoto");

        String ej1 = "2^2 = " + potenciaRemoto.square(2);
        String ej2 = "3^2 = " + potenciaRemoto.square(3);
        String ej3 = "2^3 = " + potenciaRemoto.pow(2, 3);
        String ej4 = "2^4 = " + potenciaRemoto.pow(2, 4);
        String ej5 = "2^5 = " + potenciaRemoto.pow(2, 5);

        logger.info(() -> ej1);
        logger.info(() -> ej2);
        logger.info(() -> ej3);
        logger.info(() -> ej4);
        logger.info(() -> ej5);

    }
}
