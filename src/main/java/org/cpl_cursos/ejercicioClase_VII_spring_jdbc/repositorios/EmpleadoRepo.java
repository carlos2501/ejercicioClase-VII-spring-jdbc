package org.cpl_cursos.ejercicioClase_VII_spring_jdbc.repositorios;

import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.DTOs.EmpleadoDTOLista;

import java.util.List;

public interface EmpleadoRepo {
    List<EmpleadoDTOLista> findAll();

}
