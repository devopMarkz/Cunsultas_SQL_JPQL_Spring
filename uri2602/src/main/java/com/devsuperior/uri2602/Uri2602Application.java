package com.devsuperior.uri2602;

import com.devsuperior.uri2602.dto.CustomerMinDto;
import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerMinProjection;
import com.devsuperior.uri2602.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//List<CustomerMinProjection> customer = customerRepository.search1("RS");
		//customer.forEach(customerMinProjection -> System.out.println(customerMinProjection.getName()));

		//List<CustomerMinDto> customer = customerRepository.search2("RS");
		//customer.forEach(customerMinProjection -> System.out.println(customerMinProjection.getName()));

		List<Customer> customer = customerRepository.search2("RS");
		customer.forEach(System.out::println);
	}
}
