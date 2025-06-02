package org.cpl_cursos.ejercicioClase_VII_spring_jdbc;

import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.mapeadores.OficinaMapper;
import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.modelos.Oficina;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class EjercicioClaseViiSpringJdbcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext contexto = SpringApplication.run(EjercicioClaseViiSpringJdbcApplication.class, args);
		JdbcTemplate jdbcTemplate = contexto.getBean(JdbcTemplate.class);
		String qry ="SELECT * FROM oficina";
		List<Oficina> listaOficinas =  jdbcTemplate.query(qry, new OficinaMapper());
		System.out.println(listaOficinas);
	}

}
