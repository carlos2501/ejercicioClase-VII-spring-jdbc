package org.cpl_cursos.ejercicioClase_VII_spring_jdbc;

import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.DTOs.EmpleadoDTOLista;
import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.DTOs.VentasEmpleadoDTO;
import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.controladores.JardineriaCtrl;
import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.repositorios.EmpleadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class EjercicioClaseViiSpringJdbcApplication implements ApplicationRunner {

	/*@Autowired
	private EmpleadoRepo empleadoRepo;*/

	@Autowired
	private JardineriaCtrl jardineriaCtrl;

	public static void main(String[] args) {SpringApplication.run(EjercicioClaseViiSpringJdbcApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
		jardineriaCtrl.iniciarAplicacion();
	}
}
