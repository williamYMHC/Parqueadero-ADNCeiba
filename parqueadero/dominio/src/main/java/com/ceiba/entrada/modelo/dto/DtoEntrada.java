package com.ceiba.entrada.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoEntrada {

    private Long id;
    private Long tipoVehiculo;
    private String marcaVehiculo;
    private String modeloVehiculo;
    private String placaVehiculo;
    private LocalDateTime fecha;
    private boolean registraSalida;
}


