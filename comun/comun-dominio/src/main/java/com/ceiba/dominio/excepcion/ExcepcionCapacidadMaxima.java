package com.ceiba.dominio.excepcion;

public class ExcepcionCapacidadMaxima extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionCapacidadMaxima(String mensaje) {
        super(mensaje);
    }
}
