package org.tp1.ejercicio2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cliente {
    static Logger logger = LogManager.getLogger(Cliente.class);

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        ConvertidorRemoto convertidorRemoto =
                (ConvertidorRemoto)Naming.lookup("//localhost/ConvertidorRemoto");

        String ejPesoDolar = "10000 pesos = " + convertidorRemoto.pesoDolar(10000) + " dolares USD";
        String ejDolarPeso = "10 dolares USD = " + convertidorRemoto.dolarPeso(10) + " pesos";

        logger.info(() -> ejPesoDolar);
        logger.info(() -> ejDolarPeso);
    }
}
