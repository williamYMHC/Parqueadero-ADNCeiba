package com.ceiba.entrada.comando.fabrica;

import com.ceiba.entrada.comando.comandos.ComandoEntrada;
import com.ceiba.entrada.comando.manejador.ManejadorObtenerEntrada;
import com.ceiba.entrada.modelo.builder.EntradaBuilder;
import com.ceiba.entrada.modelo.dto.DtoEntrada;
import com.ceiba.entrada.modelo.entidad.Entrada;
import com.ceiba.entrada.modelo.entidad.Salida;
import org.springframework.stereotype.Component;

@Component
public class FabricaSalida {

    public Salida crear(ComandoEntrada comandoEntrada, ManejadorObtenerEntrada manejadorObtenerEntrada) {
        DtoEntrada dtoEntrada = manejadorObtenerEntrada.ejecutar(comandoEntrada.getId());
        Entrada entrada = EntradaBuilder.convertirAEntidad(dtoEntrada);
        entrada.setTarifaDia(dtoEntrada.getTarifaDia());
        return new Salida(
                null,
                entrada
                );
    }

}
