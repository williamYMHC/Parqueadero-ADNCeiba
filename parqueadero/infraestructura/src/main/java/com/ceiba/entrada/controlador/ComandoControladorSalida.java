package com.ceiba.entrada.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.entrada.comando.comandos.ComandoEntrada;
import com.ceiba.entrada.comando.manejador.ManejadorCrearSalida;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/salidas")
@Api(tags = { "Controlador comando entrada"})
public class ComandoControladorSalida {

    private final ManejadorCrearSalida manejadorCrearSalida;

    @Autowired
    public ComandoControladorSalida(ManejadorCrearSalida manejadorCrearSalida) {
        this.manejadorCrearSalida = manejadorCrearSalida;
    }

    @PostMapping()
    @ApiOperation("Crear Salida de Vehiculo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoEntrada comandoEntrada) {
        return manejadorCrearSalida.ejecutar(comandoEntrada);
    }

}
