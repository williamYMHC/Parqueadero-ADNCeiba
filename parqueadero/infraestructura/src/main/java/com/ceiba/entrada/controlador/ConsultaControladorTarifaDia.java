package com.ceiba.entrada.controlador;

import com.ceiba.entrada.consulta.ManejadorObtenerTarifaDia;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/entradas/obtener-tarifa-vehiculo")
@Api(tags={"Controlador consulta tarifa dia"})
public class ConsultaControladorTarifaDia {

    private final ManejadorObtenerTarifaDia manejadorObtenerTarifaDia;

    public ConsultaControladorTarifaDia(ManejadorObtenerTarifaDia manejadorObtenerTarifaDia) {
        this.manejadorObtenerTarifaDia = manejadorObtenerTarifaDia;
    }

    @GetMapping
    @ApiOperation("Obtener Tarifa Dia")
    public Float obtenerTarifaDia(@RequestParam String tipoVehiculo) {
        return this.manejadorObtenerTarifaDia.ejecutar(Long.parseLong(tipoVehiculo));
    }

}
