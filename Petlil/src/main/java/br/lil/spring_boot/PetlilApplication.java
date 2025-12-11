package br.lil.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.lil.spring_boot", "br.lil.service", "br.lil.dao"})
@EnableJpaRepositories(basePackages = "br.lil.dao")
@EntityScan(basePackages = "br.lil.model")
public class PetlilApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetlilApplication.class, args);
	}

}
