package com.ceiba.entrada.servicio;

import com.ceiba.dominio.excepcion.ExcepcionCapacidadMaxima;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.entrada.modelo.entidad.Entrada;
import com.ceiba.entrada.puerto.repositorio.RepositorioEntrada;

public class ServicioCrearEntrada {

    private static final String LA_ENTRADA_YA_EXISTE_EN_EL_SISTEMA = "Ya existe un vehiculo que registra entrada con la misma placa";
    private static final String LA_ENTRADA_SUPERA_LA_CAPACIDAD = "El parqueadero se encuentra lleno en este momento";

    private final RepositorioEntrada repositorioEntrada;

    public ServicioCrearEntrada(RepositorioEntrada repositorioEntrada) {
        this.repositorioEntrada = repositorioEntrada;
    }

    public Long ejecutar(Entrada entrada) {
        validarEntradaPrevia(entrada);
        validarCapacidadMaxima(entrada);
        return this.repositorioEntrada.crear(entrada);
    }

    private void validarEntradaPrevia(Entrada entrada) {
        boolean existe = this.repositorioEntrada.existe(entrada.getPlacaVehiculo(), entrada.getTipoVehiculo(), false);
        if(existe) {
            throw new ExcepcionDuplicidad(LA_ENTRADA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarCapacidadMaxima(Entrada entrada) {
        boolean cumpleCapacidadMaxima = this.repositorioEntrada.cumpleCapacidadMaxima(entrada.getTipoVehiculo());
        if(!cumpleCapacidadMaxima) {
            throw new ExcepcionCapacidadMaxima(LA_ENTRADA_SUPERA_LA_CAPACIDAD);
        }
    }
}
