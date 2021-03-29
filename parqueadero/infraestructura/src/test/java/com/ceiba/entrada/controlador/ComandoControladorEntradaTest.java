package com.ceiba.entrada.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.entrada.comando.comandos.ComandoEntrada;
import com.ceiba.entrada.servicio.testdatabuilder.ComandoEntradaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = Replace.ANY)
@WebMvcTest(ComandoControladorEntrada.class)
public class ComandoControladorEntradaTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mocMvc;

    private ComandoEntrada entrada;

    @Test
    public void crearEntrada() throws Exception{
        // arrange
        entrada = new ComandoEntradaTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/entradas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(entrada)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    public void crearEntradaExistenciaInvalida() throws Exception{
        // arrange
        entrada = new ComandoEntradaTestDataBuilder().conPlacaVehiculo("PLC-VAL").build();
        mocMvc.perform(post("/entradas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(entrada)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));

        // act - assert
        mocMvc.perform(post("/entradas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(entrada)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void crearEntradaCapacidadInvalida() throws Exception{
        // arrange
        entrada = new ComandoEntradaTestDataBuilder().conPlacaVehiculo("OTR-PL0").build();
        mocMvc.perform(post("/entradas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(entrada)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));

        entrada = new ComandoEntradaTestDataBuilder().conPlacaVehiculo("OTR-PL1").build();
        mocMvc.perform(post("/entradas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(entrada)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));

        entrada = new ComandoEntradaTestDataBuilder().conPlacaVehiculo("OTR-PL2").build();
        // act - assert
        mocMvc.perform(post("/entradas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(entrada)))
                .andExpect(status().isBadRequest());
    }

}
