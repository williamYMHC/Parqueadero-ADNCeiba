package com.ceiba.entrada.modelo.entidad;

import lombok.Getter;
import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitudIgual;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Entrada {
    private static final String prefijo="Debe ingresar ";
    private static final String sufijo = " vehiculo";
    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_VEHICULO =prefijo+"el tipo de"+sufijo;
    private static final String SE_DEBE_INGRESAR_LA_MARCA_DEL_VEHICULO =prefijo+"la marca del"+sufijo;
    private static final String SE_DEBE_INGRESAR_EL_MODELO_DEL_VEHICULO =prefijo+"el modelo del"+sufijo;
    private static final String SE_DEBE_INGRESAR_LA_PLACA_DEL_VEHICULO =prefijo+"la placa del"+sufijo;
    private static final String LA_PLACA_DEBE_TENER_UNA_LONGITUD_IGUAL_A = "La placa debe tener una longitud igual a %s";
    private static final int LONGITUD_PLACA = 7;

    private Long id;
    private Long tipoVehiculo;
    private String marcaVehiculo;
    private String modeloVehiculo;
    private String placaVehiculo;
    private LocalDateTime fecha;
    private boolean registraSalida;

    public Entrada(Long id,Long tipoVehiculo, String marcaVehiculo,String modeloVehiculo, String placaVehiculo, boolean registraSalida) {
        validarObligatorio(tipoVehiculo, SE_DEBE_INGRESAR_EL_TIPO_DE_VEHICULO);
        validarObligatorio(marcaVehiculo, SE_DEBE_INGRESAR_LA_MARCA_DEL_VEHICULO);
        validarObligatorio(modeloVehiculo, SE_DEBE_INGRESAR_EL_MODELO_DEL_VEHICULO);
        validarObligatorio(placaVehiculo, SE_DEBE_INGRESAR_LA_PLACA_DEL_VEHICULO);
        validarLongitudIgual(placaVehiculo, LONGITUD_PLACA, String.format(LA_PLACA_DEBE_TENER_UNA_LONGITUD_IGUAL_A,LONGITUD_PLACA));
        this.id = id;
        this.tipoVehiculo = tipoVehiculo;
        this.marcaVehiculo = marcaVehiculo;
        this.modeloVehiculo = modeloVehiculo;
        this.placaVehiculo = placaVehiculo;
        this.fecha = LocalDateTime.now();
        this.registraSalida = registraSalida;
    }
}
