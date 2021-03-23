package com.ceiba.entrada.servicio.testdatabuilder;

import com.ceiba.entrada.modelo.entidad.Entrada;

public class EntradaTestDataBuilder {

    private static final Long ID=null;
    private static final Long TIPO_VEHICULO=1L;
    private static final String MARCA_VEHICULO="BMW";
    private static final String MODELO_VEHICULO="123";
    private static final String PLACA_VEHICULO="HDM-924";
    private static final boolean REGISTRA_SALIDA=false;

    private Long id;
    private Long tipoVehiculo;
    private String marcaVehiculo;
    private String modeloVehiculo;
    private String placaVehiculo;
    private boolean registraSalida;

    public EntradaTestDataBuilder(){
        this.id=ID;
        this.tipoVehiculo=TIPO_VEHICULO;
        this.marcaVehiculo=MARCA_VEHICULO;
        this.modeloVehiculo=MODELO_VEHICULO;
        this.placaVehiculo=PLACA_VEHICULO;
        this.registraSalida=REGISTRA_SALIDA;
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

    public Entrada build() {
        return new Entrada(id,tipoVehiculo, marcaVehiculo,modeloVehiculo,placaVehiculo,registraSalida);
    }



}
