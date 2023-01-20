package com.rodriguez.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rodriguez.db.repository.IEstudianteRepository;
import com.rodriguez.db.repository.IUniversidadRepository;

@SpringBootApplication
public class DbApplication {
	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(
				DbApplication.class,
				args
		);
		IEstudianteRepository estudianteRepository =
			appContext.getBean(
				IEstudianteRepository.class
		);
		IUniversidadRepository universidadRepository =
			appContext.getBean(
				IUniversidadRepository.class
		);
		
		
	}
}
// https://codebun.com/spring-data-jpa-one-to-many-mapping-example/
//https://codebun.com/spring-data-jpa-one-to-many-mapping-example/
//https://codebun.com/spring-data-jpa-one-to-many-mapping-example/
//https://codebun.com/spring-data-jpa-one-to-many-mapping-example/
//https://codebun.com/spring-data-jpa-one-to-many-mapping-example/
