package com.devsuperior.uri2621;

import com.devsuperior.uri2621.dto.ProductMinDto;
import com.devsuperior.uri2621.projections.ProductMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2621.repositories.ProductRepository;

import java.util.List;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<ProductMinProjection> testSearch1 = repository.search1(10, 20, "P");
		System.out.println("------------------------- CONSULTA COM SQL NATIVO -------------------------");
		testSearch1.forEach(productMinProjection -> System.out.println(productMinProjection.getName()));

		List<ProductMinDto> testSearch2 = repository.search2(10, 20, "P");
		System.out.println("------------------------- CONSULTA COM JPQL -------------------------");
		testSearch2.forEach(productMinProjection -> System.out.println(productMinProjection.getName()));
	}
}
