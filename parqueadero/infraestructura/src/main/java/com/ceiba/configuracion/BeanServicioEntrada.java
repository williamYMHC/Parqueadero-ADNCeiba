package com.ceiba.configuracion;

import com.ceiba.entrada.puerto.repositorio.RepositorioEntrada;
import com.ceiba.entrada.servicio.ServicioCrearEntrada;
import com.ceiba.entrada.servicio.ServicioObtenerTarifaDia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioEntrada {

    @Bean
    public ServicioObtenerTarifaDia servicioObtenerTarifaDia(RepositorioEntrada repositorioEntrada) {
        return new ServicioObtenerTarifaDia(repositorioEntrada);
    }

    @Bean
    public ServicioCrearEntrada servicioCrearEntrada(RepositorioEntrada repositorioEntrada,ServicioObtenerTarifaDia servicioObtenerTarifaDia ) {
        return new ServicioCrearEntrada(repositorioEntrada, servicioObtenerTarifaDia);
    }

}
