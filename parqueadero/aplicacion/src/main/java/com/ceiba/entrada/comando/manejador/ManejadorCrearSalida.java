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
    private final ManejadorObtenerEntrada manejadorObtenerEntrada;

    public ManejadorCrearSalida(FabricaSalida fabricaSalida, ServicioCrearSalida servicioCrearSalida, ManejadorObtenerEntrada manejadorObtenerEntrada) {
        this.fabricaSalida = fabricaSalida;
        this.servicioCrearSalida = servicioCrearSalida;
        this.manejadorObtenerEntrada = manejadorObtenerEntrada;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoEntrada comandoEntrada) {
        Salida salida = this.fabricaSalida.crear(comandoEntrada, manejadorObtenerEntrada);
        return new ComandoRespuesta<>(this.servicioCrearSalida.ejecutar(salida));
    }
}
