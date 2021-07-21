package com.ceiba.pedido.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPedido {
    private Long id;
    private LocalDateTime fecha;
    private Long bici;
    private Long comprador;
    private String ciudad;
    private String destino;
    private Integer flete;
}