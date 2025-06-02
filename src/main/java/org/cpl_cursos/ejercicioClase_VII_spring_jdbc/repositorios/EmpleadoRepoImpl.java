package org.cpl_cursos.ejercicioClase_VII_spring_jdbc.repositorios;

import lombok.RequiredArgsConstructor;
import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.DTOs.EmpleadoDTOLista;
import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.mapeadores.EmpleadoMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpleadoRepoImpl implements EmpleadoRepo {

    private final JdbcTemplate jdbcTemplate;
    private final EmpleadoMapper empleadoMapper;

    public EmpleadoRepoImpl(JdbcTemplate jdbcTemplate, EmpleadoMapper empleadoMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.empleadoMapper = empleadoMapper;
    }

    @Override
    public List<EmpleadoDTOLista> findAll() {
        String qry = """
            SELECT e.codigo_empleado, e.nombre, e.apellido1, e.apellido2,
                   e.email, e.puesto, o.ciudad as ciudad_oficina
            FROM empleado e
            INNER JOIN oficina o ON e.codigo_oficina = o.codigo_oficina
            ORDER BY o.ciudad, e.apellido1, e.nombre
            """;
        List<EmpleadoDTOLista> listaEmpleados = jdbcTemplate.query(qry, empleadoMapper::toDTO);
        return listaEmpleados;
    }
}
