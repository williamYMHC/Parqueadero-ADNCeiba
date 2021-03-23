package com.ceiba.entrada.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.entrada.comando.comandos.ComandoEntrada;
import com.ceiba.entrada.comando.fabrica.FabricaEntrada;
import com.ceiba.entrada.modelo.entidad.Entrada;
import com.ceiba.entrada.servicio.ServicioCrearEntrada;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearEntrada implements ManejadorComandoRespuesta<ComandoEntrada, ComandoRespuesta<Long>> {
    private final FabricaEntrada fabricaEntrada;
    private final ServicioCrearEntrada servicioCrearEntrada;

    public ManejadorCrearEntrada(FabricaEntrada fabricaEntrada, ServicioCrearEntrada servicioCrearEntrada) {
        this.fabricaEntrada = fabricaEntrada;
        this.servicioCrearEntrada = servicioCrearEntrada;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoEntrada fabricaEntrada) {
        Entrada entrada = this.fabricaEntrada.crear(fabricaEntrada);
        return new ComandoRespuesta<>(this.servicioCrearEntrada.ejecutar(entrada));
    }
}
