package com.ceiba.scotter.controlador;

import com.ceiba.scotter.consulta.*;
import com.ceiba.scotter.modelo.dto.DtoScotter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scotters")
@Api(tags = {"Controlador consulta scotter"})
public class ConsultaControladorScotter {

    private final ManejadorBuscarIdScotter manejadorBuscarIdScotter;
    private final ManejadorListarScotter manejadorListarScotter;
    private final ManejadorBuscarCiudadScotter manejadorBuscarCiudadScotter;
    private final ManejadorBuscarPrecioScotter manejadorBuscarPrecioScotter;
    private final ManejadorBuscarIdVendedor manejadorBuscarIdVendedor;

    public ConsultaControladorScotter(ManejadorBuscarIdScotter manejadorBuscarIdScotter,
                                      ManejadorListarScotter manejadorListarScotter,
                                      ManejadorBuscarCiudadScotter manejadorBuscarCiudadScotter,
                                      ManejadorBuscarPrecioScotter manejadorBuscarPrecioScotter,
                                      ManejadorBuscarIdVendedor manejadorBuscarIdVendedor) {
        this.manejadorBuscarIdScotter = manejadorBuscarIdScotter;
        this.manejadorListarScotter = manejadorListarScotter;
        this.manejadorBuscarCiudadScotter = manejadorBuscarCiudadScotter;
        this.manejadorBuscarPrecioScotter = manejadorBuscarPrecioScotter;
        this.manejadorBuscarIdVendedor = manejadorBuscarIdVendedor;
    }

    @GetMapping
    @ApiOperation("Listar scotters")
    public List<DtoScotter> listar() {
        return this.manejadorListarScotter.ejecutar();
    }

    @GetMapping("/id/{id}")
    @ApiOperation("Listar scotters por id")
    public DtoScotter listar(@PathVariable Long id) {
        return this.manejadorBuscarIdScotter.ejecutar(id);
    }

    @GetMapping("/ciudad/{ciudad}")
    @ApiOperation("Listar scotters por ciudad")
    public List<DtoScotter> listar(@PathVariable String ciudad) {
        return this.manejadorBuscarCiudadScotter.ejecutar(ciudad);
    }

    @GetMapping("/precio/{precio}")
    @ApiOperation("Listar scotters por precio")
    public List<DtoScotter> listar(@PathVariable double precio) {
        return this.manejadorBuscarPrecioScotter.ejecutar(precio);
    }

    @GetMapping("/vendedor/{vendedor}")
    @ApiOperation("Listar scotters por Id Vendedor")
    public List<DtoScotter> listarScotter(@PathVariable Long vendedor) {

        return this.manejadorBuscarIdVendedor.ejecutar(vendedor);
    }

}

