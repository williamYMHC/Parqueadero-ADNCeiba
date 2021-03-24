package com.ceiba.entrada.servicio.testdatabuilder;

import com.ceiba.entrada.modelo.entidad.Entrada;
import com.ceiba.entrada.modelo.entidad.Salida;

import java.time.LocalDateTime;

public class SalidaTestDataBuilder {

    private static final Long ID=null;

    private Long id;
    private Entrada entrada;
    private LocalDateTime fechaSalida;

    public SalidaTestDataBuilder(){
        this.id=ID;
        this.entrada=new EntradaTestDataBuilder().build();
        this.fechaSalida=LocalDateTime.now();

    }

    public SalidaTestDataBuilder conEntrada(Entrada entrada) {
        this.entrada = entrada;
        return this;
    }

    public SalidaTestDataBuilder conFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
        return this;
    }

    public Salida build() {
        Salida salida = new Salida(id, entrada);
        salida.setFechaSalida(fechaSalida);
        return salida;
    }



}
