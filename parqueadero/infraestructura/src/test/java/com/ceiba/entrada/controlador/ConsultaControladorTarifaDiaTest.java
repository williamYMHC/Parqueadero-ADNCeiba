package com.ceiba.entrada.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.entrada.modelo.enums.TipoDia;
import com.ceiba.utils.ObtenerTipoDia;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorTarifaDia.class)
public class ConsultaControladorTarifaDiaTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mocMvc;

    @Test
    public void obtenerTarifaDia() throws Exception {
        //arrange
        String tipoDia = ObtenerTipoDia.obtenerTipoDia(LocalDateTime.now());
        if(tipoDia.equals(TipoDia.LUNES_A_VIERNES)){
            //act-assert
            mocMvc.perform(get("/entradas/obtener-tarifa-vehiculo?tipoVehiculo={idTipo}", 1)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().json("1000.0"));
        }else if(tipoDia.equals(TipoDia.SABADOS_DOMINGOS_Y_FESTIVOS)){
            //act-assert
            mocMvc.perform(get("/entradas/obtener-tarifa-vehiculo?tipoVehiculo={idTipo}", 1)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().json("1400.0"));
        }

    }

}