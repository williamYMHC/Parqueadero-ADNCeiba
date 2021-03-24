package com.ceiba.utils;

import lombok.Getter;

@Getter
public enum MensajesExcepciones {

    LA_SALIDA_YA_EXISTE_EN_EL_SISTEMA("El vehiculo ya registra salida"),
    LA_ENTRADA_NO_EXISTE("No existe la entrada especificada"),
    SE_DEBE_INGRESAR_EL_TIPO_DE_VEHICULO ("Debe diligenciar el tipo del vehiculo"),
    SE_DEBE_INGRESAR_LA_MARCA_DEL_VEHICULO ("Debe diligenciar la marca del vehiculo"),
    SE_DEBE_INGRESAR_EL_MODELO_DEL_VEHICULO ("Debe diligenciar el modelo del vehiculo"),
    SE_DEBE_INGRESAR_LA_PLACA_DEL_VEHICULO ("Debe diligenciar la placa del vehiculo"),
    LA_PLACA_DEBE_TENER_UNA_LONGITUD_IGUAL_A ( "La placa debe tener una longitud igual a %s"),
    TARIFA_DEL_DIA_NULA ("No existe tarifa para este dia"),
    YA_EXISTE_UN_VEHICULO_QUE_REGISTRA_ENTRADA ("Ya existe un vehiculo que registra entrada con la misma placa"),
    EL_PARQUEADERO_SE_ENCUENTRA_LLENO ("El parqueadero se encuentra lleno en este momento");

    private  String mensaje;

    MensajesExcepciones(String mensaje){
        this.mensaje=mensaje;
    }
}
