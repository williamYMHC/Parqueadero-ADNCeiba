package com.ceiba.entrada.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.entrada.comando.comandos.ComandoEntrada;
import com.ceiba.entrada.comando.manejador.ManejadorCrearEntrada;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entradas")
@Api(tags = { "Controlador comando entrada"})
public class ComandoControladorEntrada {

    private final ManejadorCrearEntrada manejadorCrearEntrada;

    @Autowired
    public ComandoControladorEntrada(ManejadorCrearEntrada manejadorCrearEntrada) {
        this.manejadorCrearEntrada = manejadorCrearEntrada;
    }

    @PostMapping
    @ApiOperation("Crear Entrada de Vehiculo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoEntrada comandoEntrada) {
        return manejadorCrearEntrada.ejecutar(comandoEntrada);
    }

    @PostMapping("/salida")
    @ApiOperation("Crear Salida de Vehiculo")
    public ComandoRespuesta<Long> crearSalida(@RequestBody ComandoEntrada comandoEntrada) {
        return manejadorCrearEntrada.ejecutar(comandoEntrada);
    }

}
