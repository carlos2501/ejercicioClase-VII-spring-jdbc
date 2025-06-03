package org.cpl_cursos.ejercicioClase_VII_spring_jdbc.repositorios;

import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.DTOs.OficinaDTOLista;

import java.util.List;

/**
 * Esta interfaz publica los métodos que se usarán
 */
public interface OficinaRepo {
    List<OficinaDTOLista> listaOficinas();
    String ciudadOficina(String codigoOficina);

}
