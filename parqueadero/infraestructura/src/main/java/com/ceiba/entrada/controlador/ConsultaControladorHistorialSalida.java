package com.ceiba.entrada.controlador;

import com.ceiba.entrada.consulta.ManejadorListarEntradas;
import com.ceiba.entrada.consulta.ManejadorListarHistorialSalida;
import com.ceiba.entrada.modelo.dto.DtoEntrada;
import com.ceiba.entrada.modelo.dto.DtoHistorialSalida;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/salidas/consultar-historial")
@Api(tags={"Controlador consulta historial"})
public class ConsultaControladorHistorialSalida {

    private final ManejadorListarHistorialSalida manejadorListarHistorialSalida;

    public ConsultaControladorHistorialSalida(ManejadorListarHistorialSalida manejadorListarHistorialSalida) {
        this.manejadorListarHistorialSalida = manejadorListarHistorialSalida;
    }

    @GetMapping
    @ApiOperation("Listar historial de salida")
    public List<DtoHistorialSalida> listar() {
        return this.manejadorListarHistorialSalida.ejecutar();
    }

}
