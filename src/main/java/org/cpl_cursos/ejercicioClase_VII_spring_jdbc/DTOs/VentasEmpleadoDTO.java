package org.cpl_cursos.ejercicioClase_VII_spring_jdbc.DTOs;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VentasEmpleadoDTO {
    private Integer codigoEmpleado;
    private String nombreCompleto;
    private String ciudadOficina;
    private String puesto;
    private BigDecimal totalVentas;
}
