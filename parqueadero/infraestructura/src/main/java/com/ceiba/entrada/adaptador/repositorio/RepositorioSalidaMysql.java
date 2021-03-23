package com.ceiba.entrada.adaptador.repositorio;

import com.ceiba.entrada.modelo.entidad.Salida;
import com.ceiba.entrada.puerto.repositorio.RepositorioSalida;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioSalidaMysql implements RepositorioSalida {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="salida", value="crear")
    private static String sqlCrear;

    public RepositorioSalidaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Salida salida) {
        return this.customNamedParameterJdbcTemplate.crear(salida, sqlCrear);
    }
}
