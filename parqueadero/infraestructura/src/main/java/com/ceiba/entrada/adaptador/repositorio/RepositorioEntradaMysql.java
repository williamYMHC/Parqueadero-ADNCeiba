package com.ceiba.entrada.adaptador.repositorio;

import com.ceiba.entrada.modelo.entidad.Entrada;
import com.ceiba.entrada.puerto.repositorio.RepositorioEntrada;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioEntradaMysql implements RepositorioEntrada {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "entrada", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "entrada", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "entrada", value = "existeSalidaPorId")
    private static String sqlExisteSalidaPorId;

    @SqlStatement(namespace = "entrada", value = "obtenerCapacidadMaxima")
    private static String sqlCapacidadMaxima;

    @SqlStatement(namespace = "entrada", value = "obtenerCantidadVehiculos")
    private static String sqlcantidadActualVehiculos;

    @SqlStatement(namespace = "entrada", value = "registrarSalidaVehiculo")
    private static String sqlRegistrarSalidaVehiculo;

    @SqlStatement(namespace = "entrada", value = "obtenerTarifaDia")
    private static String sqlObtenerTarifaDia;
    public RepositorioEntradaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    private MapSqlParameterSource instanciarparamSourceWithTipoVehiculo(Long tipoVehiculo){
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("tipoVehiculo", tipoVehiculo);
        return paramSource;
    }
    @Override
    public Long crear(Entrada entrada) {
        return this.customNamedParameterJdbcTemplate.crear(entrada, sqlCrear);
    }

    @Override
    public boolean existe(String placaVehiculo, Long tipoVehiculo, boolean registraSalida) {
        MapSqlParameterSource paramSource =instanciarparamSourceWithTipoVehiculo(tipoVehiculo);
        paramSource.addValue("placaVehiculo", placaVehiculo);
        paramSource.addValue("registraSalida", registraSalida);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public boolean existeSalidaPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteSalidaPorId,paramSource, Boolean.class);
    }

    @Override
    public boolean cumpleCapacidadMaxima(Long tipoVehiculo) {
        MapSqlParameterSource paramSource =instanciarparamSourceWithTipoVehiculo(tipoVehiculo);
        Integer capacidadMaxima = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlCapacidadMaxima,paramSource, Integer.class);
        Integer cantidadActual = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlcantidadActualVehiculos,paramSource, Integer.class);
        return (cantidadActual+1)<=capacidadMaxima;
    }

    @Override
    public void registrarSalidaVehiculo(Entrada entrada) {
        this.customNamedParameterJdbcTemplate.actualizar(sqlRegistrarSalidaVehiculo, entrada.getId());
    }

    @Override
    public Float obtenerTarifaDia(String nombreTipoDia, Long tipoVehiculo) {
        MapSqlParameterSource paramSource =instanciarparamSourceWithTipoVehiculo(tipoVehiculo);
        paramSource.addValue("nombreTipoDia", nombreTipoDia);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerTarifaDia,paramSource, Float.class);
    }

}
