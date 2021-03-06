package com.ceiba.scotter.controlador;

import com.ceiba.ApplicationMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorScotter.class)
public class ConsultaControladorScotterTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void listarTest() throws Exception {
        // arrange
        // act - assert
        mocMvc.perform(get("/scotters")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].marca", is("enduro")));
    }

    @Test
    public void buscarIdTest() throws Exception {
        // arrange
        Long id = 1L;
        // act - assert
        mocMvc.perform(get("/scotters/id/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("marca", is("enduro")));
    }

    @Test
    public void buscarCiudadTest() throws Exception {
        // arrange
        String ciudad = "Santa Marta";
        // act - assert
        mocMvc.perform(get("/scotters/ciudad/{ciudad}", ciudad)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void buscarPrecioTest() throws Exception {
        // arrange
        double precio = 3500000.0;
        // act - assert
        mocMvc.perform(get("/scotters/precio/{precio}", precio)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

}
