package com.ceiba.compra.controlador;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.ceiba.ApplicationMock;
import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.servicio.testdatabuilder.ComandoCompraTestDataBuilder;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.scotter.modelo.entidad.Scotter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorCompra.class)
public class ComandoControladorCompraTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crearCompraTest() throws Exception {
        // arrange
        ComandoCompra compra = new ComandoCompraTestDataBuilder().build();
       // act - assert
        mocMvc.perform(post("/compras")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(compra)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));


    }



    @Test
    public void eliminarCompraTest() throws Exception {
        // arrange
        Long id = 2L;
        // act - assert
        mocMvc.perform(delete("/compras/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
