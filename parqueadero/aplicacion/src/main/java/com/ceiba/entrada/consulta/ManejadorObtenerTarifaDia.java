package com.ceiba.entrada.consulta;

import com.ceiba.entrada.servicio.ServicioObtenerTarifaDia;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ManejadorObtenerTarifaDia {

    private final ServicioObtenerTarifaDia servicioObtenerTarifaDia;

    public ManejadorObtenerTarifaDia(ServicioObtenerTarifaDia servicioObtenerTarifaDia){
        this.servicioObtenerTarifaDia = servicioObtenerTarifaDia;
    }

    public Float ejecutar(Long tipoVehiculo){
        return this.servicioObtenerTarifaDia.ejecutar(tipoVehiculo, LocalDateTime.now());
    }
}
