package com.ceiba.entrada.servicio;

import com.ceiba.dominio.utils.HolidayUtil;
import com.ceiba.entrada.modelo.enums.TipoDia;
import com.ceiba.entrada.puerto.repositorio.RepositorioEntrada;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.EnumSet;
import java.util.Set;

public class ServicioObtenerTarifaDia {

    private final RepositorioEntrada repositorioEntrada;

    public ServicioObtenerTarifaDia(RepositorioEntrada repositorioEntrada) {
        this.repositorioEntrada = repositorioEntrada;
    }

    public Float ejecutar(Long idTipoVehiculo, LocalDateTime fecha) {
        String nombreTipoDia = obtenerTipoDia(fecha);
        Float tarifa = this.repositorioEntrada.obtenerTarifaDia(TipoDia.LUNES_A_VIERNES.getNombre(), idTipoVehiculo);
        if(nombreTipoDia.equals(TipoDia.SABADOS_DOMINGOS_Y_FESTIVOS.getNombre())){
            return (float)(tarifa+(tarifa*0.40));
        }
        return tarifa;
    }

    public String obtenerTipoDia(LocalDateTime fecha) {
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
