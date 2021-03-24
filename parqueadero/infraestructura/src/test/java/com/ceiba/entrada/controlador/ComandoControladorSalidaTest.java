package com.ceiba.entrada.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.entrada.comando.comandos.ComandoEntrada;
import com.ceiba.entrada.servicio.testdatabuilder.ComandoEntradaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@WebMvcTest(ComandoControladorEntrada.class)
public class ComandoControladorSalidaTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mocMvc;

    private ComandoEntrada comandoEntrada;

    @Test
    public void crearSalidaTest() throws Exception{
        // arrange
        comandoEntrada = new ComandoEntradaTestDataBuilder().build();
        mocMvc.perform(post("/entradas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoEntrada)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 1}"));
        comandoEntrada.setId(1L);

        // act - assert
        mocMvc.perform(post("/salidas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoEntrada)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 1}"));
    }

    @Test
    public void crearSalidaInvalidaTest() throws Exception{
        // arrange
        comandoEntrada = new ComandoEntradaTestDataBuilder().conPlacaVehiculo("PLC-VAL").build();
        comandoEntrada.setId(1L);

        // act - assert
        mocMvc.perform(post("/salidas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoEntrada)))
                .andExpect(status().isNotFound());
    }
}