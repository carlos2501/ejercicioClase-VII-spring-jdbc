package org.cpl_cursos.ejercicioClase_VII_spring_jdbc;

import lombok.RequiredArgsConstructor;
import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.DTOs.EmpleadoDTOLista;
import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.repositorios.EmpleadoRepo;
import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.repositorios.OficinaRepo;
import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.repositorios.OficinaRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class EjercicioClaseViiSpringJdbcApplication implements ApplicationRunner {

	@Autowired
	private OficinaRepo oficinaRepo;
	@Autowired
	private EmpleadoRepo empleadoRepo;

	public static void main(String[] args) {SpringApplication.run(EjercicioClaseViiSpringJdbcApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//System.out.println("\n\n******* Lista empleados: " + oficinaRepo.listaOficinas().size() + "\n\n");
		//System.out.println("\n\n******* Ciudad de MAD-ES: " + oficinaRepo.ciudadOficina("MAD-ES") + "\n\n");
		// Creamos un Map para poder poner una cabecera con el nombre de la ciudad
		List<EmpleadoDTOLista> listaEmpleados = empleadoRepo.findAll();
		// Procesamos la lista de empleados para rellenar el Map
		Map<String, List<EmpleadoDTOLista>> mapEmpleados = listaEmpleados.stream()
				.collect(Collectors.groupingBy(EmpleadoDTOLista::getCiudadOficina));
		// Listamos los empleados de la oficina de cada ciudad
		mapEmpleados.forEach((ciudad, empleados) -> {
			System.out.println("*** " + ciudad.toUpperCase() + " ***");
			empleados.forEach(empleado -> {
				System.out.printf("  - %s %s %s (%s) - %s%n",
						empleado.getNombre(),
						empleado.getApellido1(),
						empleado.getApellido2() != null ? empleado.getApellido2() : "",
						empleado.getPuesto(),
						empleado.getEmail());
			});
			System.out.println();
		});
	}
}
