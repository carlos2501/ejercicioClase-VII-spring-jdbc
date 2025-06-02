package org.cpl_cursos.ejercicioClase_VII_spring_jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;

@SpringBootApplication
public class EjercicioClaseViiSpringJdbcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext contexto = SpringApplication.run(EjercicioClaseViiSpringJdbcApplication.class, args);
		DataSource ds = contexto.getBean(DataSource.class);
		System.out.println("Implementación de DataSource de Spring: " + ds.getClass().getSimpleName());
	}

}
