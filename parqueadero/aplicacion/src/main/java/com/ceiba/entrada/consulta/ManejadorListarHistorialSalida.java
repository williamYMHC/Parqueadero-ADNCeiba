package com.ceiba.entrada.consulta;

import com.ceiba.entrada.modelo.dto.DtoHistorialSalida;
import com.ceiba.entrada.puerto.dao.DaoSalida;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarHistorialSalida {

    private final DaoSalida daoSalida;

    public ManejadorListarHistorialSalida(DaoSalida daoSalida){
        this.daoSalida = daoSalida;
    }

    public List<DtoHistorialSalida> ejecutar(){ return this.daoSalida.listarHistorial(); }
}
