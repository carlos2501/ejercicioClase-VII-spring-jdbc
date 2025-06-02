package org.cpl_cursos.ejercicioClase_VII_spring_jdbc.mapeadores;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.DTOs.EmpleadoDTOLista;
import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.modelos.Empleado;
import org.springframework.stereotype.Component;


@Component
public class EmpleadoMapper {

    public EmpleadoDTOLista toDTO(Empleado empleado) {
        EmpleadoDTOLista empleDTO = new EmpleadoDTOLista();
        empleDTO.setCodigoEmpleado(empleado.getCodigoEmpleado());
        empleDTO.setNombre(empleado.getNombre());
        empleDTO.setApellido1(empleado.getApellido1());
        empleDTO.setApellido2(empleado.getApellido2());
        empleDTO.setEmail(empleado.getEmail());
        empleDTO.setPuesto(empleado.getPuesto());
        // necesitamos obtener la ciudad de su oficina

        return empleDTO;

    }
}
