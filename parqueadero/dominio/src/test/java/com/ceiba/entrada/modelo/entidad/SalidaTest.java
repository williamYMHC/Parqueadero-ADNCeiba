package com.ceiba.entrada.modelo.entidad;

import com.ceiba.entrada.servicio.testdatabuilder.EntradaTestDataBuilder;
import com.ceiba.entrada.servicio.testdatabuilder.SalidaTestDataBuilder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;

public class SalidaTest {

    @Test
    public void calcularValorTarifaGratisTest() {
        // arrange
        LocalDateTime fechaEntrada = LocalDateTime.of(2021, 3, 24,16,0);
        LocalDateTime fechasalida = LocalDateTime.of(2021, 3, 24,16,13);

        Salida salida = new SalidaTestDataBuilder()
                .conEntrada(new EntradaTestDataBuilder().conFecha(fechaEntrada).build())
                .conFechaSalida(fechasalida)
                .build();
        //act
        salida.calcularValorTarifa();

        // assert
        Assertions.assertEquals(0, salida.getValorTotal());

    }

    @Test
    public void calcularValorTarifaTest1() {
        // arrange
        LocalDateTime fechaEntrada = LocalDateTime.of(2021, 3, 24,16,0);
        LocalDateTime fechasalida = LocalDateTime.of(2021, 3, 24,16,17);

        Salida salida = new SalidaTestDataBuilder()
                .conEntrada(new EntradaTestDataBuilder().conFecha(fechaEntrada).build())
                .conFechaSalida(fechasalida)
                .build();
        //act
        salida.calcularValorTarifa();

        // assert
        Assertions.assertEquals(2000.0, salida.getValorTotal());

    }



    @Test
    public void calcularValorTarifaTest2() {
        // arrange
        LocalDateTime fechaEntrada = LocalDateTime.of(2021, 3, 24,16,0);
        LocalDateTime fechasalida = LocalDateTime.of(2021, 3, 24,18,0);

        Salida salida = new SalidaTestDataBuilder()
                .conEntrada(new EntradaTestDataBuilder().conFecha(fechaEntrada).build())
                .conFechaSalida(fechasalida)
                .build();
        //act
        salida.calcularValorTarifa();

        // assert
        Assertions.assertEquals(8000.0, salida.getValorTotal());

    }

}