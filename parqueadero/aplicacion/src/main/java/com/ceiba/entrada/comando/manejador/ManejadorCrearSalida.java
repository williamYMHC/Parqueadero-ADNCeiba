package com.ceiba.entrada.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.entrada.comando.comandos.ComandoEntrada;
import com.ceiba.entrada.comando.fabrica.FabricaSalida;
import com.ceiba.entrada.modelo.entidad.Salida;
import com.ceiba.entrada.servicio.ServicioCrearSalida;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearSalida implements ManejadorComandoRespuesta<ComandoEntrada, ComandoRespuesta<Long>>{

    private final FabricaSalida fabricaSalida;
    private final ServicioCrearSalida servicioCrearSalida;

    public ManejadorCrearSalida(FabricaSalida fabricaSalida, ServicioCrearSalida servicioCrearSalida) {
        this.fabricaSalida = fabricaSalida;
        this.servicioCrearSalida = servicioCrearSalida;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoEntrada fabricaEntrada) {
        Salida salida = this.fabricaSalida.crear(fabricaEntrada);
        return new ComandoRespuesta<>(this.servicioCrearSalida.ejecutar(salida));
    }
}
