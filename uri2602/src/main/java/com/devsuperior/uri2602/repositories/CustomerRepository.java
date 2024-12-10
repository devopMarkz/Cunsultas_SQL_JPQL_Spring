package com.devsuperior.uri2602.repositories;

import com.devsuperior.uri2602.dto.CustomerMinDto;
import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(nativeQuery = true, value = "SELECT name from customers WHERE state = :state")
    List<CustomerMinProjection> search1(@Param("state") String state);


    @Query("SELECT obj FROM Customer obj WHERE obj.state = :state")
    List<Customer> search2(@Param("state") String state);

}
