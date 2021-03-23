package com.ceiba.entrada.servicio.testdatabuilder;

import com.ceiba.entrada.comando.comandos.ComandoEntrada;
import com.ceiba.usuario.comando.ComandoUsuario;

import java.time.LocalDateTime;

public class ComandoEntradaTestDataBuilder {

    private Long id;
    private Long tipoVehiculo;
    private String marcaVehiculo;
    private String modeloVehiculo;
    private String placaVehiculo;
    private LocalDateTime fecha;
    private boolean registraSalida;

    public ComandoEntradaTestDataBuilder() {
        tipoVehiculo = 1L;
        marcaVehiculo= "BMW";
        modeloVehiculo= "123";
        placaVehiculo= "JII-111";
        fecha = LocalDateTime.now();

    }

    public ComandoEntradaTestDataBuilder conTipoVehiculo(Long tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        return this;
    }

    public ComandoEntradaTestDataBuilder conMarcaVehiculo(String marcaVehiculo) {
        this.marcaVehiculo = marcaVehiculo;
        return this;
    }

    public ComandoEntradaTestDataBuilder conModeloVehiculo(String modeloVehiculo) {
        this.modeloVehiculo = modeloVehiculo;
        return this;
    }

    public ComandoEntradaTestDataBuilder conPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
        return this;
    }

    public ComandoEntradaTestDataBuilder conRegistraSalida(boolean registraSalida) {
        this.registraSalida = registraSalida;
        return this;
    }

    public ComandoEntrada build() {
        return new ComandoEntrada(id,tipoVehiculo, marcaVehiculo,modeloVehiculo, placaVehiculo, fecha, registraSalida);
    }
}
