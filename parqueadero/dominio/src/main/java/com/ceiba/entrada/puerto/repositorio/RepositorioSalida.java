package com.ceiba.entrada.puerto.repositorio;

import com.ceiba.entrada.modelo.entidad.Salida;

public interface RepositorioSalida {

    /**
     * Permite crear una entrada
     * @param salida
     * @return el id generado
     */
    Long crear(Salida salida);
}
