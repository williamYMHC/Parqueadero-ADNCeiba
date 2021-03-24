package com.ceiba.entrada.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.entrada.modelo.entidad.Salida;
import com.ceiba.entrada.puerto.repositorio.RepositorioEntrada;
import com.ceiba.entrada.puerto.repositorio.RepositorioSalida;
import com.ceiba.utils.MensajesExcepciones;

public class ServicioCrearSalida {


    private final RepositorioEntrada repositorioEntrada;
    private final RepositorioSalida repositorioSalida;

    public ServicioCrearSalida(RepositorioEntrada repositorioEntrada, RepositorioSalida repositorioSalida) {
        this.repositorioEntrada = repositorioEntrada;
        this.repositorioSalida = repositorioSalida;
    }

    public Long ejecutar(Salida salida) {
        validarSalidaPrevia(salida);
        this.repositorioEntrada.registrarSalidaVehiculo(salida.getEntrada());
        return this.repositorioSalida.crear(salida);
    }

    private void validarSalidaPrevia(Salida salida) {
        boolean existe = this.repositorioEntrada.existeSalidaPorId(salida.getEntrada().getId());
        if(existe) {
            throw new ExcepcionDuplicidad(MensajesExcepciones.LA_SALIDA_YA_EXISTE_EN_EL_SISTEMA.getMensaje());
        }
    }
}
