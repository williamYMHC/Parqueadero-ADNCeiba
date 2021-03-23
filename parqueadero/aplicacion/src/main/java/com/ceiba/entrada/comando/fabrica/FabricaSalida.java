package com.ceiba.entrada.comando.fabrica;

import com.ceiba.entrada.comando.comandos.ComandoEntrada;
import com.ceiba.entrada.modelo.entidad.Salida;
import org.springframework.stereotype.Component;

@Component
public class FabricaSalida {

    public Salida crear(ComandoEntrada comandoEntrada) {
        return new Salida(
                null,
                comandoEntrada.getId(),
                comandoEntrada.getFecha()
                );
    }

}
