package com.ceiba.entrada.puerto.dao;

import com.ceiba.entrada.modelo.dto.DtoEntrada;

import java.util.List;
import java.util.Optional;

public interface DaoEntrada {

    /**
     * Permite listar entradas
     * @return las entradas
     */
    List<DtoEntrada> listar();

    Optional<DtoEntrada> obtenerEntradaPorId(Long id);


}
