package com.ceiba.entrada.modelo.builder;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.entrada.modelo.dto.DtoEntrada;
import com.ceiba.entrada.modelo.entidad.Entrada;
import com.ceiba.utils.MensajesExcepciones;

public final class EntradaBuilder {

    private EntradaBuilder() {
    }

    public static Entrada convertirAEntidad(DtoEntrada dtoEntrada) {
        if(dtoEntrada==null){
            throw new ExcepcionSinDatos(MensajesExcepciones.LA_ENTRADA_NO_EXISTE.getMensaje());
        }
        Entrada entrada = new Entrada(
                dtoEntrada.getId(),
                dtoEntrada.getTipoVehiculo(),
                dtoEntrada.getMarcaVehiculo(),
                dtoEntrada.getModeloVehiculo(),
                dtoEntrada.getPlacaVehiculo(),
                dtoEntrada.isRegistraSalida()
        );
        entrada.setFecha(dtoEntrada.getFecha());
        return entrada;
    }

}