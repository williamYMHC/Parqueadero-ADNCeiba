package com.ceiba.utils;

import com.ceiba.dominio.utils.HolidayUtil;
import com.ceiba.entrada.modelo.enums.TipoDia;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.EnumSet;
import java.util.Set;

public class ObtenerTipoDia {

    ObtenerTipoDia(){

    }

    public static String obtenerTipoDia(LocalDateTime fecha) {
        HolidayUtil holidayUtil = new HolidayUtil(LocalDate.now().getYear());
        Set<DayOfWeek> findeSemana = EnumSet.of( DayOfWeek.SATURDAY , DayOfWeek.SUNDAY );
        if(holidayUtil.isHoliday(fecha.getMonthValue()-1, fecha.getDayOfMonth())){
            return TipoDia.SABADOS_DOMINGOS_Y_FESTIVOS.getNombre();
        }
        if(findeSemana.contains(fecha.getDayOfWeek())) {
            return TipoDia.SABADOS_DOMINGOS_Y_FESTIVOS.getNombre();
        }
        return TipoDia.LUNES_A_VIERNES.getNombre();
    }
}
