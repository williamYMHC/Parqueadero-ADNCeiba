package com.ceiba.entrada.adaptador.dao;

import com.ceiba.entrada.modelo.dto.DtoEntrada;
import com.ceiba.entrada.puerto.dao.DaoEntrada;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DaoEntradaMysql implements DaoEntrada {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="entrada", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="entrada", value="obtenerEntradaPorId")
    private static String sqlObtenerEntradaPorId;

    public DaoEntradaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoEntrada> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoEntrada());
    }

    @Override
    public Optional<DtoEntrada> obtenerEntradaPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        List<DtoEntrada> list=this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerEntradaPorId, paramSource, new MapeoEntrada());
        if(list.size()==1){
            return Optional.of(list.get(0));
        }
        return Optional.empty();
    }
}
