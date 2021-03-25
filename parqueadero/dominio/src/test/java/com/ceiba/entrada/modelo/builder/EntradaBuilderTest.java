package com.ceiba.entrada.modelo.builder;


import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.entrada.modelo.dto.DtoEntrada;
import com.ceiba.entrada.modelo.entidad.Entrada;
import com.ceiba.entrada.modelo.enums.TipoDia;
import com.ceiba.utils.MensajesExcepciones;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;


public class EntradaBuilderTest {

    @Test
    public void convertirAEntidadInvalidaTest() {
        // arrange-act-assert
        BasePrueba.assertThrows(() ->
                EntradaBuilder.convertirAEntidad(null),
                ExcepcionSinDatos.class,
                MensajesExcepciones.LA_ENTRADA_NO_EXISTE.getMensaje());
    }

    @Test
    public void convertirAEntidadTest() {
        // arrange
        DtoEntrada dtoEntrada = new DtoEntrada(
                1L,
                1L,
                "BMW",
                "123",
                "PLC-VAL",
                LocalDateTime.now(),
                false,
                (float)1000
        );
        //act
        Entrada entrada = EntradaBuilder.convertirAEntidad(dtoEntrada);

        //assert
        boolean ok = entrada.getPlacaVehiculo().equals(dtoEntrada.getPlacaVehiculo()) &&
                entrada.getModeloVehiculo().equals(dtoEntrada.getModeloVehiculo()) &&
                entrada.getMarcaVehiculo().equals(dtoEntrada.getMarcaVehiculo());
        Assertions.assertEquals(true, ok);

    }

}