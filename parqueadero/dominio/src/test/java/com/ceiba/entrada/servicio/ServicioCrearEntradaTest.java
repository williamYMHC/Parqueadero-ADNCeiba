package com.ceiba.entrada.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionCapacidadMaxima;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.entrada.modelo.entidad.Entrada;
import com.ceiba.entrada.puerto.repositorio.RepositorioEntrada;
import com.ceiba.entrada.servicio.testdatabuilder.EntradaTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearEntradaTest {

    @Test
    public void validarLongitudPlacaIgual7Test() {
        // arrange
        String mensajeExcepcion = "La placa debe tener una longitud igual a 7";
        EntradaTestDataBuilder entradaTestDataBuilder = new EntradaTestDataBuilder().conPlacaVehiculo("BAS-01");

        // act - assert
        BasePrueba.assertThrows(() -> entradaTestDataBuilder.build(), ExcepcionLongitudValor.class, mensajeExcepcion);
    }

    @Test
    public void validarEntradaExistenciaPreviaTest() {
        // arrange
        String mensajeExcepcion = "Ya existe un vehiculo que registra entrada con la misma placa";
        Entrada entrada = new EntradaTestDataBuilder().build();
        RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
        Mockito.when(repositorioEntrada.existe(Mockito.anyString(),Mockito.anyLong(), Mockito.eq(false) )).thenReturn(true);
        ServicioCrearEntrada servicioCrearEntrada = new ServicioCrearEntrada(repositorioEntrada);

        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearEntrada.ejecutar(entrada), ExcepcionDuplicidad.class,mensajeExcepcion);
    }

    @Test
    public void validarCapacidadMaximaTest() {
        // arrange
        String mensajeExcepcion = "El parqueadero se encuentra lleno en este momento";
        Entrada entrada = new EntradaTestDataBuilder().build();
        RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
        Mockito.when(repositorioEntrada.cumpleCapacidadMaxima(Mockito.anyLong())).thenReturn(false);
        ServicioCrearEntrada servicioCrearEntrada = new ServicioCrearEntrada(repositorioEntrada);

        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearEntrada.ejecutar(entrada), ExcepcionCapacidadMaxima.class,mensajeExcepcion);
    }
}