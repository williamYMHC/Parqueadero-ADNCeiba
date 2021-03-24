package com.ceiba.entrada.servicio;

import com.ceiba.dominio.excepcion.ExcepcionCapacidadMaxima;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.entrada.modelo.entidad.Entrada;
import com.ceiba.entrada.puerto.repositorio.RepositorioEntrada;
import com.ceiba.utils.MensajesExcepciones;

public class ServicioCrearEntrada {

    private final RepositorioEntrada repositorioEntrada;
    private final ServicioObtenerTarifaDia servicioObtenerTarifaDia;

    public ServicioCrearEntrada(RepositorioEntrada repositorioEntrada, ServicioObtenerTarifaDia servicioObtenerTarifaDia) {
        this.repositorioEntrada = repositorioEntrada;
        this.servicioObtenerTarifaDia = servicioObtenerTarifaDia;
    }

    public Long ejecutar(Entrada entrada) {
        validarEntradaPrevia(entrada);
        validarCapacidadMaxima(entrada);

        entrada.setTarifaDia(servicioObtenerTarifaDia.ejecutar(entrada));
        return this.repositorioEntrada.crear(entrada);
    }

    private void validarEntradaPrevia(Entrada entrada) {
        boolean existe = this.repositorioEntrada.existe(entrada.getPlacaVehiculo(), entrada.getTipoVehiculo(), false);
        if(existe) {
            throw new ExcepcionDuplicidad(MensajesExcepciones.YA_EXISTE_UN_VEHICULO_QUE_REGISTRA_ENTRADA.getMensaje());
        }
    }

    private void validarCapacidadMaxima(Entrada entrada) {
        boolean cumpleCapacidadMaxima = this.repositorioEntrada.cumpleCapacidadMaxima(entrada.getTipoVehiculo());
        if(!cumpleCapacidadMaxima) {
            throw new ExcepcionCapacidadMaxima(MensajesExcepciones.EL_PARQUEADERO_SE_ENCUENTRA_LLENO.getMensaje());
        }
    }
}
