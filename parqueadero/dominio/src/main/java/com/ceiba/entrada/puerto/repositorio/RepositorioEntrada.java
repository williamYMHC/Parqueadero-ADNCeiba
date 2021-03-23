
package com.ceiba.entrada.puerto.repositorio;

import com.ceiba.entrada.modelo.entidad.Entrada;

public interface RepositorioEntrada {

    /**
     * Permite crear una entrada
     * @param entrada
     * @return el id generado
     */
    Long crear(Entrada entrada);

    /**
     * Permite validar si existe una entrada dado la placa y el tipo de vehiculo
     * @param placa, tipoVehiculo
     * @return si existe o no
     */
    boolean existe(String placa, Long tipoVehiculo, boolean registraSalida);

    /**
     * Permite validar si existe una entrada dado la placa y el tipo de vehiculo
     * @param id
     * @return si existe o no
     */
    boolean existeSalidaPorId(Long id);

    /**
     * Permite validar si agregando un nuevo vehiculo supera la capacidad maxima o no
     * @param tipoVehiculo
     * @return si supera o no la capacidad
     */
    boolean cumpleCapacidadMaxima(Long tipoVehiculo);



}
