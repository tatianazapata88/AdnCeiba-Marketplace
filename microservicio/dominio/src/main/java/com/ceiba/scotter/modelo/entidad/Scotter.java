package com.ceiba.scotter.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Scotter {
    private static final String CAMPO_MARCA_ES_OBLIGATORIO = "El campo marca es obligatorio no puede ir vacio";
    private static final String CAMPO_MODELO_ES_OBLIGATORIO = "El campo modelo es obligatorio no puede ir vacio";
    private static final String CAMPO_PRECIO_ES_OBLIGATORIO = "El campo precio es obligatorio no puede ir vacio";
    private static final String CAMPO_CIUDAD_ES_OBLIGATORIO = "El campo ciudad es obligatorio no puede ir vacio";
    private static final String CAMPO_VENDEDOR_ES_OBLIGATORIO = "El campo vendedor es obligatorio no puede ir vacio";
    private static final String CAMPO_ESTADO_ES_OBLIGATORIO = "El campo estado es obligatorio no puede ir vacio";
    private static final String CAMPO_FOTO_ES_OBLIGATORIO = "El campo foto es obligatorio no puede ir vacio";


    private Long id;
    private String marca;
    private String modelo;
    private Integer precio;
    private String ciudad;
    private Long vendedor;
    private String estado;
    private String foto;


    public Scotter(Long id, String marca, String modelo, Integer precio, String ciudad, Long vendedor, String estado, String foto) {
        validarCampoMarcaVacio(marca);
        validarCampoModeloVacio(modelo);
        validarCampoPrecioVacio(precio);
        validarCampoCiudadVacio(ciudad);
        validarCampoVendedorVacio(vendedor);
        validarCampoEstadoVacio(estado);
        validarCampoFotoVacio(foto);

        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.ciudad = ciudad;
        this.vendedor = vendedor;
        this.estado = "disponible";
        this.foto = foto;
    }

    private void validarCampoMarcaVacio(String marca){
        if (marca == null) {
            throw new ExcepcionValorObligatorio(CAMPO_MARCA_ES_OBLIGATORIO);
        }
    }

    private void validarCampoModeloVacio(String modelo) {
        if (modelo == null) {
            throw new ExcepcionValorObligatorio(CAMPO_MODELO_ES_OBLIGATORIO);
        }
    }

    private void validarCampoPrecioVacio(Integer precio) {

        if (precio == null){
            throw new ExcepcionValorObligatorio(CAMPO_PRECIO_ES_OBLIGATORIO);
        }
    }

    private void validarCampoCiudadVacio(String ciudad) {
        if (ciudad == null) {
            throw new ExcepcionValorObligatorio(CAMPO_CIUDAD_ES_OBLIGATORIO);
        }
    }

    private void validarCampoVendedorVacio(Long vendedor) {
        if (vendedor == null) {
            throw new ExcepcionValorObligatorio(CAMPO_VENDEDOR_ES_OBLIGATORIO);
        }
    }

    private void validarCampoEstadoVacio(String estado) {
        if (estado == null){
            throw new ExcepcionValorObligatorio(CAMPO_ESTADO_ES_OBLIGATORIO);
        }
    }

    private void validarCampoFotoVacio(String foto) {
        if (foto == null) {
            throw new ExcepcionValorObligatorio(CAMPO_FOTO_ES_OBLIGATORIO);
        }
    }
}
