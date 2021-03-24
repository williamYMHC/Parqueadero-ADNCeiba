package com.ceiba.entrada.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.entrada.modelo.entidad.Salida;
import com.ceiba.entrada.puerto.repositorio.RepositorioEntrada;
import com.ceiba.entrada.puerto.repositorio.RepositorioSalida;
import com.ceiba.entrada.servicio.testdatabuilder.SalidaTestDataBuilder;
import com.ceiba.utils.MensajesExcepciones;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearSalidaTest {

    @Test
    public void validarSalidaPreviaTest() {

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