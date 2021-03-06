package com.ceiba.scotter.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.persona.adaptador.repositorio.RepositorioPersonaMysql;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.scotter.modelo.entidad.Scotter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoScotterObjeto implements RowMapper<Scotter>, MapperResult {

    private RepositorioPersonaMysql repositorioPersonaMysql;

    public MapeoScotterObjeto(RepositorioPersonaMysql repositorioPersonaMysql) {
        this.repositorioPersonaMysql = repositorioPersonaMysql;
    }

    @Override
    public Scotter mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String marca = resultSet.getString("marca");
        String modelo = resultSet.getString("modelo");
        double precio = resultSet.getDouble("precio");
        String ciudad = resultSet.getString("ciudad");
        Long id_vendedor = resultSet.getLong("vendedor");
       String estadobd = resultSet.getString("estado");
        String foto = resultSet.getString("foto");

        Persona vendedor=  repositorioPersonaMysql.obtenerPersonaPorId(id_vendedor);
        Scotter.Estado estado = Scotter.Estado.valueOf(estadobd);
        return new Scotter(id,marca, modelo, precio, ciudad, vendedor, foto);
    }
}
