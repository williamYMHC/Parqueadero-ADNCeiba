package com.ceiba.configuracion;

import com.ceiba.entrada.puerto.repositorio.RepositorioEntrada;
import com.ceiba.entrada.servicio.ServicioCrearEntrada;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioEntrada {
    @Bean
    public ServicioCrearEntrada servicioCrearEntrada(RepositorioEntrada repositorioEntrada) {
        return new ServicioCrearEntrada(repositorioEntrada);
    }
}
