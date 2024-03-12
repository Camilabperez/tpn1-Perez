package org.tp1.ejercicio5;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginRemoto extends Remote{

        /**
         * Valida usuario y contraseña en la base
         * @param usuario nombre de usuario a validar
         * @param clave contraseña a validar
         * @return true si es valido, false si no lo es.
         */
        boolean validar (String usuario,String clave) throws RemoteException;

}
