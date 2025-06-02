package org.cpl_cursos.ejercicioClase_VII_spring_jdbc.repositorios;

import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.DTOs.EmpleadoDTOLista;
import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.DTOs.VentasEmpleadoDTO;
import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.mapeadores.EmpleadoMapper;
import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.mapeadores.VentasMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpleadoRepoImpl implements EmpleadoRepo {

    private final JdbcTemplate jdbcTemplate;
    private final EmpleadoMapper empleadoMapper;
    private final VentasMapper ventasMapper;

    public EmpleadoRepoImpl(JdbcTemplate jdbcTemplate, EmpleadoMapper empleadoMapper, VentasMapper ventasMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.empleadoMapper = empleadoMapper;
        this.ventasMapper = ventasMapper;
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
        return jdbcTemplate.query(qry, empleadoMapper::toDTO);
    }

    @Override
    public List<VentasEmpleadoDTO> findAllVentas() {
        // Usamos la función COALESCE para devolver un valor alternativo si el campo es NULL
        String qry = """
            SELECT e.codigo_empleado,
                   CONCAT(e.nombre, ' ', e.apellido1, ' ', COALESCE(e.apellido2, '')) as nombre_completo,
                   o.ciudad as ciudad_oficina,
                   e.puesto,
                   COALESCE(SUM(p.cantidad * p.precio_unidad), 0) as total_ventas
            FROM empleado e
            INNER JOIN oficina o ON e.codigo_oficina = o.codigo_oficina
            LEFT JOIN cliente c ON e.codigo_empleado = c.codigo_empleado_rep_ventas
            LEFT JOIN pedido pe ON c.codigo_cliente = pe.codigo_cliente
            LEFT JOIN detalle_pedido p ON pe.codigo_pedido = p.codigo_pedido
            GROUP BY e.codigo_empleado, e.nombre, e.apellido1, e.apellido2, o.ciudad, e.puesto
            ORDER BY total_ventas DESC, e.apellido1, e.nombre
            """;
        return jdbcTemplate.query(qry,ventasMapper::toDTO );
    }
}
