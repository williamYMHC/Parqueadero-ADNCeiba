package com.ceiba.entrada.modelo.enums;

import lombok.Getter;

@Getter
public enum TipoDia {

    LUNES_A_VIERNES("LUNESAVIERNES"),
    SABADOS_DOMINGOS_Y_FESTIVOS("SABADOSDOMINGOSYFESTIVOS");

    private String nombre;

    TipoDia(String nombre) {
        this.nombre = nombre;
    }
}
