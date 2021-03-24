package com.ceiba.entrada.comando.manejador;

import com.ceiba.entrada.modelo.dto.DtoEntrada;
import com.ceiba.entrada.puerto.dao.DaoEntrada;
import org.springframework.stereotype.Service;

@Service
public class ManejadorObtenerEntrada {

    private final DaoEntrada daoEntrada;

    public ManejadorObtenerEntrada(DaoEntrada daoEntrada) {
        this.daoEntrada = daoEntrada;
    }

    public DtoEntrada ejecutar(Long id) {
        return this.daoEntrada.obtenerEntradaPorId(id).orElse(null);
    }
}

