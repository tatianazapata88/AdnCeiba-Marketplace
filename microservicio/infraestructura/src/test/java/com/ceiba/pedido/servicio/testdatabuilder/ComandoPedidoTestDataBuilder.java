package com.ceiba.pedido.servicio.testdatabuilder;

import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;

import java.time.LocalDate;

public class ComandoPedidoTestDataBuilder {
    private Long id;
    private LocalDate fecha;
    private Long bici;
    private Long comprador;
    private String ciudad;
    private String destino;
    private double precio;




    public ComandoPedidoTestDataBuilder(){
        fecha = LocalDate.of(2021,8,2);
        bici = 2L;
        comprador = 2L;
        ciudad = "medellin";
        destino = "bogota";
        precio = 4000000.0;

       // total= 4030000;

    }
    public ComandoPedidoTestDataBuilder(LocalDate fecha, Long bici, Long comprador, String ciudad,
                                 String destino, double precio) {
        this.fecha = fecha;
        this.bici = bici;
        this.comprador = comprador;
        this.ciudad = ciudad;
        this.destino = destino;
        this.precio = precio;

    }

    public ComandoPedidoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoPedidoTestDataBuilder conBici(Long bici) {
        this.bici = bici;
        return this;
    }

    public ComandoPedidoTestDataBuilder conFecha(LocalDate fecha){
        this.fecha= fecha;
        return this;
    }

    public ComandoPedidoTestDataBuilder conCiudadYDestino(String ciudad, String destino) {
        this.ciudad = ciudad;
        this.destino =destino;

        return this;
    }


    public ComandoPedido build() {

        return new ComandoPedido(id,fecha,bici,comprador,ciudad,destino,precio);
    }
}
