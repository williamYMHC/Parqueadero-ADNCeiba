package com.ceiba.entrada.puerto.dao;

import com.ceiba.entrada.modelo.dto.DtoHistorialSalida;

import java.util.List;

public interface DaoSalida {

    /**
     * Permite listar entradas
     * @return las entradas
     */
    List<DtoHistorialSalida> listarHistorial();

}
