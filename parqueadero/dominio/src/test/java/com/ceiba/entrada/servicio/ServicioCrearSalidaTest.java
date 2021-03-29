package com.ceiba.entrada.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.entrada.modelo.entidad.Salida;
import com.ceiba.entrada.puerto.repositorio.RepositorioEntrada;
import com.ceiba.entrada.puerto.repositorio.RepositorioSalida;
import com.ceiba.entrada.servicio.testdatabuilder.SalidaTestDataBuilder;
import com.ceiba.utils.MensajesExcepciones;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class ServicioCrearSalidaTest {

    @Test
    public void validarSalidaTest() {

        // arrange
        SalidaTestDataBuilder salidaTestDataBuilder = new SalidaTestDataBuilder();
        RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
        RepositorioSalida repositorioSalida = Mockito.mock(RepositorioSalida.class);
        Salida salidaTest = salidaTestDataBuilder.build();

        Mockito.when(repositorioEntrada.existeSalidaPorId(Mockito.anyLong())).thenReturn(false);
        Mockito.doNothing().when(repositorioEntrada).registrarSalidaVehiculo(salidaTest.getEntrada());
        Mockito.when(repositorioSalida.crear(salidaTest)).thenReturn(1L);

        ServicioCrearSalida servicioCrearSalida = new ServicioCrearSalida(repositorioEntrada, repositorioSalida);

        // act
        Long result = servicioCrearSalida.ejecutar(salidaTest);
        //assert
        Assertions.assertEquals(java.util.Optional.ofNullable(1L), java.util.Optional.ofNullable(result));

    }

    @Test
    public void validarSalidaInvalidaTest() {

        // arrange
        RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
        Mockito.when(repositorioEntrada.existeSalidaPorId(Mockito.anyLong())).thenReturn(true);
        RepositorioSalida repositorioSalida = Mockito.mock(RepositorioSalida.class);
        ServicioCrearSalida servicioCrearSalida = new ServicioCrearSalida(repositorioEntrada, repositorioSalida);
        Salida salida = new SalidaTestDataBuilder().build();

        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearSalida.ejecutar(salida), ExcepcionDuplicidad.class, MensajesExcepciones.LA_SALIDA_YA_EXISTE_EN_EL_SISTEMA.getMensaje());
    }
}