package org.cpl_cursos.ejercicioClase_VII_spring_jdbc;

import lombok.RequiredArgsConstructor;
import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.repositorios.OficinaRepo;
import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.repositorios.OficinaRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EjercicioClaseViiSpringJdbcApplication implements ApplicationRunner {

	@Autowired
	private OficinaRepo oficinaRepo;

	public static void main(String[] args) {SpringApplication.run(EjercicioClaseViiSpringJdbcApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("\n\n******* Nro. de oficinas: " + oficinaRepo.listaOficinas().size() + "\n\n");
		System.out.println("\n\n******* Ciudad de MAD-ES: " + oficinaRepo.ciudadOficina("MAD-ES") + "\n\n");
	}
}
