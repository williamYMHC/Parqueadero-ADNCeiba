package com.ceiba.entrada.modelo.entidad;

import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class Salida {

    private Long id;
    private Long idEntrada;
    private LocalDateTime fechaSalida;
    private float valorTotal;

    public Salida(Long id, Long idEntrada, LocalDateTime fechaEntrada) {
        //validarObligatorio(tipoVehiculo, SE_DEBE_INGRESAR_EL_TIPO_DE_VEHICULO);
        this.id=id;
        this.idEntrada=idEntrada;
        this.fechaSalida = LocalDateTime.now();

    }
}
