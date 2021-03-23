package com.ceiba.configuracion;

import com.ceiba.entrada.puerto.repositorio.RepositorioEntrada;
import com.ceiba.entrada.puerto.repositorio.RepositorioSalida;
import com.ceiba.entrada.servicio.ServicioCrearEntrada;
import com.ceiba.entrada.servicio.ServicioCrearSalida;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioSalida {
    @Bean
    public ServicioCrearSalida servicioCrearSalida(RepositorioEntrada repositorioEntrada, RepositorioSalida repositorioSalida) {
        return new ServicioCrearSalida(repositorioEntrada, repositorioSalida);
    }
}
