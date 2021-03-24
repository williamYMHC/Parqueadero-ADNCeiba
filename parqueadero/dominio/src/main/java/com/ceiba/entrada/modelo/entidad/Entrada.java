package com.ceiba.entrada.modelo.entidad;

import com.ceiba.utils.MensajesExcepciones;
import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitudIgual;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Entrada {

    int LONGITUD_PLACA = 7;

    private Long id;
    private Long tipoVehiculo;
    private String marcaVehiculo;
    private String modeloVehiculo;
    private String placaVehiculo;
    private LocalDateTime fecha;
    private boolean registraSalida;
    private Float tarifaDia;

    public Entrada(Long id,Long tipoVehiculo, String marcaVehiculo,String modeloVehiculo, String placaVehiculo, boolean registraSalida) {
        validarObligatorio(tipoVehiculo, MensajesExcepciones.SE_DEBE_INGRESAR_EL_TIPO_DE_VEHICULO.getMensaje());
        validarObligatorio(marcaVehiculo, MensajesExcepciones.SE_DEBE_INGRESAR_LA_MARCA_DEL_VEHICULO.getMensaje());
        validarObligatorio(modeloVehiculo, MensajesExcepciones.SE_DEBE_INGRESAR_EL_MODELO_DEL_VEHICULO.getMensaje());
        validarObligatorio(placaVehiculo, MensajesExcepciones.SE_DEBE_INGRESAR_LA_PLACA_DEL_VEHICULO.getMensaje());
        validarLongitudIgual(placaVehiculo, LONGITUD_PLACA, String.format(MensajesExcepciones.LA_PLACA_DEBE_TENER_UNA_LONGITUD_IGUAL_A.getMensaje(),LONGITUD_PLACA));

        this.id = id;
        this.tipoVehiculo = tipoVehiculo;
        this.marcaVehiculo = marcaVehiculo;
        this.modeloVehiculo = modeloVehiculo;
        this.placaVehiculo = placaVehiculo;
        this.fecha = LocalDateTime.now();
        this.registraSalida = registraSalida;
    }

    public void setTarifaDia(Float tarifaDia) {
        this.tarifaDia = tarifaDia;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
