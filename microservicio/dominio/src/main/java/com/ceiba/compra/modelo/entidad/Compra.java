package com.ceiba.compra.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;

import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.scotter.modelo.entidad.Scotter;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Compra {

    private static final double VALOR_DE_DESCUENTO = 0.05;
    private static final double SIN_DESCUENTO = 0.0;
    private static final double VALOR_FLETE_MISMA_CIUDAD = 0.0;
    private static final double VALOR_FLETE_DIFERENTE_CIUDAD = 30000.0;

    private static final String CAMPO_FECHA_ES_OBLIGATORIO = "El campo fecha obligatorio no puede ir vacio";
    private static final String CAMPO_SCOTTER_ES_OBLIGATORIO = "El campo scotter obligatorio no puede ir vacio";
    private static final String CAMPO_COMPRADOR_ES_OBLIGATORIO = "El campo Comprador es obligatorio no puede ir vacio";
    private static final String CAMPO_CIUDAD_DESTINO_SCOTTER_ES_OBLIGATORIO = "El campo ciudad destino  es obligatorio no puede ir vacio";
    private static final String CAMPO_FECHA_NO_PUEDE_SER_MENOR_A_LA_FECHA_ACTUAL = "La fecha no puede ser inferior a la fecha actual";
    private static final String CAMPO_FECHA_NO_PUEDE_SER_MAYOR_A_5_DIAS_DE_LA_FECHA_ACTUAL = "La fecha no puede ser mayor a 5 dias despues a la fecha actual";


    private Long id;
    private LocalDate fecha;
    private Scotter scotter;
    private Persona comprador;
    private String ciudadDestinoEnvioScotter;
    private double flete;
    private double descuento;
    private double total;

    public Compra(Long id, LocalDate fecha, Scotter scotter, Persona comprador, String ciudadDestinoEnvioScotter) {
        validarCampoFecha(fecha);
        validarCampoCiudadDestino(ciudadDestinoEnvioScotter);
        validarCampoScotter(scotter);
        validarCampoComprador(comprador);

        this.id = id;
        this.fecha = fecha;
        this.scotter = scotter;
        this.comprador = comprador;
        this.ciudadDestinoEnvioScotter = ciudadDestinoEnvioScotter;
        this.flete = this.valorFlete(scotter.getCiudad(), ciudadDestinoEnvioScotter);
        this.descuento = this.valorDescuento(this.fecha, scotter.getPrecio());
        this.total = this.valorTotal(scotter.getPrecio(), this.flete, this.descuento);
    }

    private void validarCampoFecha(LocalDate fecha) {
        if (fecha == null) {
            throw new ExcepcionValorObligatorio(CAMPO_FECHA_ES_OBLIGATORIO);
        }
    }

    private void validarCampoScotter(Scotter scotter){
        if (scotter == null){
            throw new ExcepcionValorObligatorio(CAMPO_SCOTTER_ES_OBLIGATORIO);
        }
    }

    private void validarCampoComprador(Persona comprador){
        if (comprador == null){
            throw new ExcepcionValorObligatorio(CAMPO_COMPRADOR_ES_OBLIGATORIO);
        }
    }

    private void validarCampoCiudadDestino(String ciudadDestinoEnvioScotter) {
        if (ciudadDestinoEnvioScotter == null || ciudadDestinoEnvioScotter.trim().length() <= 0) {
            throw new ExcepcionValorObligatorio(CAMPO_CIUDAD_DESTINO_SCOTTER_ES_OBLIGATORIO);
        }
    }

    private double valorTotal(double precio, double flete, double descuento) {
        double valor_total = precio + flete - descuento;
        return this.total = valor_total;
    }

    private double valorDescuento(LocalDate fecha, double precio) {
        int diferenciaFechas = fecha.compareTo(LocalDate.now());
        if (diferenciaFechas == 0) {
            double calcularDescuento = Math.round(precio * VALOR_DE_DESCUENTO);
            return this.descuento = calcularDescuento;
        } else if (diferenciaFechas < 0) {
            throw new ExcepcionValorInvalido(CAMPO_FECHA_NO_PUEDE_SER_MENOR_A_LA_FECHA_ACTUAL);
        } else if (diferenciaFechas > 0 && diferenciaFechas <= 5) {
            return this.descuento = SIN_DESCUENTO;
        } else if (diferenciaFechas > 5) {
            throw new ExcepcionValorInvalido(CAMPO_FECHA_NO_PUEDE_SER_MAYOR_A_5_DIAS_DE_LA_FECHA_ACTUAL);
        }else{
            return this.descuento = SIN_DESCUENTO;
        }
    }

    private double valorFlete(String ciudad, String destino) {
        if (ciudad.equals(destino)) {
            return this.flete = VALOR_FLETE_MISMA_CIUDAD;
        } else {
            return this.flete = VALOR_FLETE_DIFERENTE_CIUDAD;
        }
    }


}


