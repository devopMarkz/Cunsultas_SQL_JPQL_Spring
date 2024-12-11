package com.devsuperior.uri2609;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2609.repositories.CategoryRepository;

import java.util.List;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<CategorySumProjection> testSearch1 = repository.search1();
		testSearch1.forEach(categorySumProjection -> System.out.println(categorySumProjection.getName() + ", " + categorySumProjection.getSum()));

		List<CategorySumDTO> testSearch2 = repository.testSearch2();
		testSearch2.forEach(categorySumProjection -> System.out.println(categorySumProjection.getName() + ", " + categorySumProjection.getSum()));
	}
}
