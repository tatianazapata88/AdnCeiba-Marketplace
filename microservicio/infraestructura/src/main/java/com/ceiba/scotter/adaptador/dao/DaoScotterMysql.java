package com.ceiba.scotter.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.scotter.modelo.dto.DtoScotter;
import com.ceiba.scotter.puerto.dao.DaoScotter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoScotterMysql implements DaoScotter {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "scotter", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "scotter", value = "buscarId")
    private static String sqlBuscar;

    @SqlStatement(namespace = "scotter", value = "buscarCiudad")
    private static String sqlBuscarCiudad;

    @SqlStatement(namespace = "scotter", value = "buscarPrecio")
    private static String sqlBuscarPrecio;

    @SqlStatement(namespace = "scotter", value = "buscarIdVendedor")
    private static String sqlBuscarIdVendedor;

    public DaoScotterMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoScotter> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoScotter());
    }

    @Override
    public DtoScotter buscarId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscar, paramSource, new MapeoScotter());
    }

    @Override
    public List<DtoScotter> buscarIdVendedor(Long vendedor) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("vendedor", vendedor);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlBuscarIdVendedor, paramSource, new MapeoScotter());
    }
    @Override
    public List<DtoScotter> buscarCiudad(String ciudad) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("ciudad", ciudad);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlBuscarCiudad, parameterSource, new MapeoScotter());
    }

    @Override
    public List<DtoScotter> buscarPrecio(double precio) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("precio", precio);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlBuscarPrecio, parameterSource, new MapeoScotter());
    }
}
