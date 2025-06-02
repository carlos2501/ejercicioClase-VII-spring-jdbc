package org.cpl_cursos.ejercicioClase_VII_spring_jdbc.mapeadores;

import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.modelos.Oficina;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OficinaMapper implements RowMapper<Oficina> {
    @Override
    public Oficina mapRow(ResultSet rs, int rowNum) throws SQLException {
        Oficina ofi = new Oficina();
        ofi.setCodigoOficina(rs.getString("codigo_oficina"));
        ofi.setCiudad(rs.getString("ciudad"));
        ofi.setTelefono(rs.getString("telefono"));
        ofi.setLineaDireccion1(rs.getString("linea_direccion1"));
        return ofi;
    }
}
