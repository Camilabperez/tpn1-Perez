package org.tp1.ejercicio2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

public class Convertidor extends UnicastRemoteObject implements ConvertidorRemoto {
    static Logger logger = Logger.getLogger(Convertidor.class.getName());
    Convertidor() throws RemoteException { }

    @Override
    public long pesoDolar(long importe)throws RemoteException {
        long cotizacion = getCotizacion();
        if (cotizacion != 0) {
            return importe / cotizacion;
        }else{
            return 0;
        }
    }
    @Override
    public long dolarPeso(long importe) throws RemoteException {
        return importe * getCotizacion();
    }

    /**
     * Devuelve la cotización del dólar desde una API externa.
     * Documentacion: dolarapi.com/docs/
     * @return valor de venta del dólar
     */
    private long getCotizacion() {
        ObjectMapper mapper = new ObjectMapper();
        Dolar cotizacion = null;

        try {
            URL url = new URL("https://dolarapi.com/v1/dolares/oficial");
            String responsetoString = getResponsetoString(url);
            cotizacion = mapper.readValue(responsetoString, Dolar.class);

        } catch (IOException e) {
            logger.info("Error al obtener la cotización: " + e.getMessage());
        }

        return cotizacion != null ? cotizacion.getVenta() : 0;
    }

    private static String getResponsetoString(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        return response.toString();
    }

}
