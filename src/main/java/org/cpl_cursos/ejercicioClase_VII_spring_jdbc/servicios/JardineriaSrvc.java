package org.cpl_cursos.ejercicioClase_VII_spring_jdbc.servicios;

import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.DTOs.EmpleadoDTOLista;
import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.DTOs.OficinaDTOLista;
import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.DTOs.VentasEmpleadoDTO;
import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.repositorios.EmpleadoRepo;
import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.repositorios.OficinaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JardineriaSrvc {

    private final OficinaRepo oficinaRepo;
    private final EmpleadoRepo empleadoRepo;

    public JardineriaSrvc(OficinaRepo oficinaRepo, EmpleadoRepo empleadoRepo) {
        this.oficinaRepo = oficinaRepo;
        this.empleadoRepo = empleadoRepo;
    }

    public List<EmpleadoDTOLista> listarEmpleados() {
        return empleadoRepo.findAll();
    }

    public List<OficinaDTOLista> listarOficinas() {
        return oficinaRepo.listaOficinas();
    }

    public List<VentasEmpleadoDTO> listarVentasEmpleados() {
        return empleadoRepo.findAllVentas();
    }
}
