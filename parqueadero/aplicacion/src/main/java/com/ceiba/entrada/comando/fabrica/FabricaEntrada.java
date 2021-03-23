package com.ceiba.entrada.comando.fabrica;

import com.ceiba.entrada.comando.comandos.ComandoEntrada;
import com.ceiba.entrada.modelo.entidad.Entrada;
import org.springframework.stereotype.Component;

@Component
public class FabricaEntrada {

    public Entrada crear(ComandoEntrada comandoEntrada) {
        return new Entrada(
                comandoEntrada.getId(),
                comandoEntrada.getTipoVehiculo(),
                comandoEntrada.getMarcaVehiculo(),
                comandoEntrada.getModeloVehiculo(),
                comandoEntrada.getPlacaVehiculo(),
                comandoEntrada.isRegistraSalida()
                );
    }

}
