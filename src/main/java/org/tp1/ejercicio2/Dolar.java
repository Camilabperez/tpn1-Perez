package org.tp1.ejercicio2;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Dolar {
    @JsonProperty("moneda")
    String moneda;
    @JsonProperty("casa")
    String casa;
    @JsonProperty("nombre")
    String nombre;
    @JsonProperty("compra")
    long compra;
    @JsonProperty("venta")
    long venta;
    @JsonProperty("fechaActualizacion")
    String fechaActualizacion;
}
