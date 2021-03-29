package com.ceiba.entrada.servicio;

import com.ceiba.entrada.modelo.enums.TipoDia;
import com.ceiba.entrada.puerto.repositorio.RepositorioEntrada;
import com.ceiba.utils.ObtenerTipoDia;

import java.time.LocalDateTime;

public class ServicioObtenerTarifaDia {

    private final RepositorioEntrada repositorioEntrada;

    public ServicioObtenerTarifaDia(RepositorioEntrada repositorioEntrada) {
        this.repositorioEntrada = repositorioEntrada;
    }

    public Float ejecutar(Long idTipoVehiculo, LocalDateTime fecha) {
        String nombreTipoDia = ObtenerTipoDia.obtenerTipoDia(fecha);
        Float tarifa = this.repositorioEntrada.obtenerTarifaDia(TipoDia.LUNES_A_VIERNES.getNombre(), idTipoVehiculo);
        if(nombreTipoDia.equals(TipoDia.SABADOS_DOMINGOS_Y_FESTIVOS.getNombre())){
            return (float)(tarifa+(tarifa*0.40));
        }
        return tarifa;
    }




}
