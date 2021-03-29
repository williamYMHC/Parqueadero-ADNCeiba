package com.ceiba.infraestructura.jdbc;

import com.ceiba.infraestructura.excepcion.ExcepcionTecnica;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomNamedParameterJdbcTemplate {

	private static final String ERROR_OBTENIENDO_EL_NOMBRE_Y_VALOR_DE_OBJETO = "Error obteniendo el nombre y valor de objeto";
	private static List<String> clases;
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public CustomNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		construirListaDeClasesEntidades();
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	private void construirListaDeClasesEntidades(){
		clases = new ArrayList<>();
		clases.add("com.ceiba.entrada.modelo.entidad.Entrada");
	}

	public Long crear(Object object,String sql) {
		MapSqlParameterSource paramSource = crearParametros(object);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.namedParameterJdbcTemplate.update(sql, paramSource,keyHolder,new String[] { "id" });
		return keyHolder.getKey().longValue();
	}
	
	public void actualizar(Object object,String sql) {
		MapSqlParameterSource paramSource = crearParametros(object);
		this.namedParameterJdbcTemplate.update(sql, paramSource);
	}

	public void actualizar(String sql, Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);
		this.namedParameterJdbcTemplate.update(sql, paramSource);
	}

	private MapSqlParameterSource crearParametros(Object object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		Field[] fields = object.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			try {
				Field field = fields[i];


				if (!Modifier.isStatic(field.getModifiers()) && !Modifier.isFinal(field.getModifiers())) {
					field.setAccessible(true);

					if(esUnaEntidad(field.getType().getName())){
						Object obj = field.get(object);
						paramSource.addValue("id"+field.getType().getSimpleName(), obj.toString());
					}else{
						paramSource.addValue(field.getName(), field.get(object));
					}

					field.setAccessible(false);
				}
			} catch (Exception e) {
				throw new ExcepcionTecnica(ERROR_OBTENIENDO_EL_NOMBRE_Y_VALOR_DE_OBJETO, e);
			}
		}
		return paramSource;
	}

	private boolean esUnaEntidad(String nombre){
		for (String clase: clases) {
			if(clase.equals(nombre)) return true;
		}
		return false;
	}
	
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return this.namedParameterJdbcTemplate;
	}
}
