package com.ceiba.entrada.servicio.testdatabuilder;

import com.ceiba.entrada.modelo.entidad.Entrada;

import java.time.LocalDateTime;

public class EntradaTestDataBuilder {

    private static final Long ID=null;
    private static final Long TIPO_VEHICULO=1L;
    private static final String MARCA_VEHICULO="BMW";
    private static final String MODELO_VEHICULO="123";
    private static final String PLACA_VEHICULO="HDM-924";
    private static final boolean REGISTRA_SALIDA=false;
    private static final Float TARIFA_DIA=(float)1000.0;

    private Long id;
    private Long tipoVehiculo;
    private String marcaVehiculo;
    private String modeloVehiculo;
    private String placaVehiculo;
    private boolean registraSalida;
    private LocalDateTime fecha;
    private Float tarifaDia;

    public EntradaTestDataBuilder(){
        this.id=ID;
        this.tipoVehiculo=TIPO_VEHICULO;
        this.marcaVehiculo=MARCA_VEHICULO;
        this.modeloVehiculo=MODELO_VEHICULO;
        this.placaVehiculo=PLACA_VEHICULO;
        this.registraSalida=REGISTRA_SALIDA;
        this.fecha= LocalDateTime.now();
        this.tarifaDia = TARIFA_DIA;
    }

    public EntradaTestDataBuilder conTipoVehiculo(Long tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        return this;
    }

    public EntradaTestDataBuilder conMarcaVehiculo(String marcaVehiculo) {
        this.marcaVehiculo = marcaVehiculo;
        return this;
    }

    public EntradaTestDataBuilder conModeloVehiculo(String modeloVehiculo) {
        this.modeloVehiculo = modeloVehiculo;
        return this;
    }

    public EntradaTestDataBuilder conPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
        return this;
    }

    public EntradaTestDataBuilder conRegistraSalida(boolean registraSalida) {
        this.registraSalida = registraSalida;
        return this;
    }

    public EntradaTestDataBuilder conFecha(LocalDateTime fecha) {
        this.fecha = fecha;
        return this;
    }

    public EntradaTestDataBuilder conTarifaDia(Float tarifaDia) {
        this.tarifaDia = tarifaDia;
        return this;
    }

    public Entrada build() {
        Entrada entrada = new Entrada(id,tipoVehiculo, marcaVehiculo,modeloVehiculo,placaVehiculo,registraSalida);
        entrada.setFecha(fecha);
        entrada.setTarifaDia(tarifaDia);
        return entrada;
    }



}
