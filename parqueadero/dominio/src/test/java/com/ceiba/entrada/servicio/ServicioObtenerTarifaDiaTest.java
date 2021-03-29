package com.ceiba.entrada.servicio;

import com.ceiba.entrada.modelo.entidad.Entrada;
import com.ceiba.entrada.modelo.enums.TipoDia;
import com.ceiba.entrada.puerto.repositorio.RepositorioEntrada;
import com.ceiba.entrada.servicio.testdatabuilder.EntradaTestDataBuilder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.time.LocalDateTime;


public class ServicioObtenerTarifaDiaTest {

    private Entrada entrada;

    @Test
    public void obtenerTipoDiaFestivoTest() {
        // arrange
        entrada = new EntradaTestDataBuilder().conFecha(LocalDateTime.of(2021, 3, 22,5, 0)).build();
        RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
        ServicioObtenerTarifaDia servicioObtenerTarifaDia = new ServicioObtenerTarifaDia(repositorioEntrada);

        Mockito.when(repositorioEntrada.obtenerTarifaDia(TipoDia.LUNES_A_VIERNES.getNombre(), 1L)).thenReturn(1000.0F);

        //act
        Float tarifa = servicioObtenerTarifaDia.ejecutar(1L, entrada.getFecha());

        // assert
        Assertions.assertEquals(java.util.Optional.ofNullable(1400F), java.util.Optional.ofNullable(tarifa));
    }

    @Test
    public void obtenerTipoDiaSabadoTest() {
        // arrange
        entrada = new EntradaTestDataBuilder().conFecha(LocalDateTime.of(2021, 3, 20,13, 0)).build();
        RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
        ServicioObtenerTarifaDia servicioObtenerTarifaDia = new ServicioObtenerTarifaDia(repositorioEntrada);
        Mockito.when(repositorioEntrada.obtenerTarifaDia(TipoDia.LUNES_A_VIERNES.getNombre(), 1L)).thenReturn(1000.0F);

        //act
        Float tarifa = servicioObtenerTarifaDia.ejecutar(1L, entrada.getFecha());

        // assert
        Assertions.assertEquals(java.util.Optional.ofNullable(1400F), java.util.Optional.ofNullable(tarifa));
    }

    @Test
    public void obtenerTipoDiaEntreSemanaTest() {
        // arrange
        entrada = new EntradaTestDataBuilder().conFecha(LocalDateTime.of(2021, 3, 24,18, 0)).build();
        RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
        ServicioObtenerTarifaDia servicioObtenerTarifaDia = new ServicioObtenerTarifaDia(repositorioEntrada);
        Mockito.when(repositorioEntrada.obtenerTarifaDia(TipoDia.LUNES_A_VIERNES.getNombre(), 1L)).thenReturn(1000.0F);

        //act
        Float tarifa = servicioObtenerTarifaDia.ejecutar(1L, entrada.getFecha());

        // assert
        Assertions.assertEquals(java.util.Optional.ofNullable(1000F), java.util.Optional.ofNullable(tarifa));
    }
}