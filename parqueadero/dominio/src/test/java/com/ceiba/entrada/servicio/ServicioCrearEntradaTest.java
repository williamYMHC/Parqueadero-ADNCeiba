package com.ceiba.entrada.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionCapacidadMaxima;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.entrada.modelo.entidad.Entrada;
import com.ceiba.entrada.puerto.repositorio.RepositorioEntrada;
import com.ceiba.entrada.servicio.testdatabuilder.EntradaTestDataBuilder;
import com.ceiba.utils.MensajesExcepciones;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearEntradaTest {

    private static final int LONGITUD_PLACA=7;
    @Test
    public void validarLongitudPlacaIgual7Test() {
        // arrange
        String mensajeExcepcion = "La placa debe tener una longitud igual a 7";
        EntradaTestDataBuilder entradaTestDataBuilder = new EntradaTestDataBuilder().conPlacaVehiculo("BAS-01");

        // act - assert
        BasePrueba.assertThrows(() ->
                        entradaTestDataBuilder.build(),
                        ExcepcionLongitudValor.class,
                        String.format(MensajesExcepciones.LA_PLACA_DEBE_TENER_UNA_LONGITUD_IGUAL_A.getMensaje(),LONGITUD_PLACA));
    }

    @Test
    public void validarEntradaExistenciaPreviaTest() {
        // arrange
        Entrada entrada = new EntradaTestDataBuilder().build();
        RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
        Mockito.when(repositorioEntrada.existe(Mockito.anyString(),Mockito.anyLong(), Mockito.eq(false) )).thenReturn(true);

        ServicioObtenerTarifaDia servicioObtenerTarifaDia = new ServicioObtenerTarifaDia(repositorioEntrada);
        ServicioCrearEntrada servicioCrearEntrada = new ServicioCrearEntrada(repositorioEntrada, servicioObtenerTarifaDia);

        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearEntrada.ejecutar(entrada), ExcepcionDuplicidad.class,MensajesExcepciones.YA_EXISTE_UN_VEHICULO_QUE_REGISTRA_ENTRADA.getMensaje());
    }

    @Test
    public void validarCapacidadMaximaTest() {
        // arrange
        Entrada entrada = new EntradaTestDataBuilder().build();
        RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
        Mockito.when(repositorioEntrada.cumpleCapacidadMaxima(Mockito.anyLong())).thenReturn(false);
        ServicioObtenerTarifaDia servicioObtenerTarifaDia = new ServicioObtenerTarifaDia(repositorioEntrada);
        ServicioCrearEntrada servicioCrearEntrada = new ServicioCrearEntrada(repositorioEntrada, servicioObtenerTarifaDia);

        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearEntrada.ejecutar(entrada), ExcepcionCapacidadMaxima.class,MensajesExcepciones.EL_PARQUEADERO_SE_ENCUENTRA_LLENO.getMensaje());
    }
}