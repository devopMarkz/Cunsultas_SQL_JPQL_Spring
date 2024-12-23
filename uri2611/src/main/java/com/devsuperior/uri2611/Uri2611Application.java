package com.devsuperior.uri2611;

import com.devsuperior.uri2611.dto.MovieMinDto;
import com.devsuperior.uri2611.projections.MovieProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {

	@Autowired
	private MovieRepository movieRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("\n-------------------- CONSULTA 1 COM SQL NATIVO --------------------");

		List<MovieProjection> testSearch1 = movieRepository.search1("Action");
		testSearch1.forEach(movieProjection -> System.out.println(movieProjection.getId() + ", " + movieProjection.getName()));

		System.out.println("\n-------------------- CONSULTA 2 COM JPQL --------------------");
		List<MovieMinDto> testSearch2 = movieRepository.search2("Action");
		testSearch2.forEach(System.out::println);

	}
}
