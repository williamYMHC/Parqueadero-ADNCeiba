package com.ceiba.entrada.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.entrada.modelo.entidad.Salida;
import com.ceiba.entrada.puerto.repositorio.RepositorioEntrada;
import com.ceiba.entrada.puerto.repositorio.RepositorioSalida;

public class ServicioCrearSalida {

    private static final String LA_SALIDA_YA_EXISTE_EN_EL_SISTEMA = "El vehiculo ya registra salida";

    private final RepositorioEntrada repositorioEntrada;
    private final RepositorioSalida repositorioSalida;

    public ServicioCrearSalida(RepositorioEntrada repositorioEntrada, RepositorioSalida repositorioSalida) {
        this.repositorioEntrada = repositorioEntrada;
        this.repositorioSalida = repositorioSalida;
    }

    public Long ejecutar(Salida salida) {
        validarSalidaPrevia(salida);
        return this.repositorioSalida.crear(salida);
    }

    private void validarSalidaPrevia(Salida salida) {
        boolean existe = this.repositorioEntrada.existeSalidaPorId(salida.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_SALIDA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
