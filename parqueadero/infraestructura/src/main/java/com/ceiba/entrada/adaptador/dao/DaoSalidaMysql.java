package com.ceiba.entrada.adaptador.dao;

import com.ceiba.entrada.adaptador.dao.mapeo.MapeoHistorialSalida;
import com.ceiba.entrada.modelo.dto.DtoHistorialSalida;
import com.ceiba.entrada.puerto.dao.DaoSalida;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoSalidaMysql implements DaoSalida {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="salida", value="listarHistorial")
    private static String sqlListar;

    public DaoSalidaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoHistorialSalida> listarHistorial() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoHistorialSalida());
    }

}
