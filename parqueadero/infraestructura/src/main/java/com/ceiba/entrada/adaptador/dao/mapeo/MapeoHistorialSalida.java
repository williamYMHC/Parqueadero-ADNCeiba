package com.ceiba.entrada.adaptador.dao.mapeo;

import com.ceiba.entrada.modelo.dto.DtoEntrada;
import com.ceiba.entrada.modelo.dto.DtoHistorialSalida;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoHistorialSalida implements RowMapper<DtoHistorialSalida>, MapperResult {

    @Override
    public DtoHistorialSalida mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long tipoVehiculo = resultSet.getLong("id_tipo_vehiculo");
        String marcaVehiculo = resultSet.getString("marca_vehiculo");
        String modeloVehiculo = resultSet.getString("modelo_vehiculo");
        String placaVehiculo = resultSet.getString("placa_vehiculo");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha");
        boolean registraSalida = resultSet.getBoolean("registra_salida");
        Float tarifaDia = resultSet.getFloat("tarifa_dia");
        Float valorTarifa = resultSet.getFloat("valor_tarifa");
        LocalDateTime fechaSalida = extraerLocalDateTime(resultSet, "fecha_salida");

        return new DtoHistorialSalida(id, tipoVehiculo, marcaVehiculo, modeloVehiculo, placaVehiculo, fecha, registraSalida, tarifaDia, fechaSalida, valorTarifa);
    }

}
