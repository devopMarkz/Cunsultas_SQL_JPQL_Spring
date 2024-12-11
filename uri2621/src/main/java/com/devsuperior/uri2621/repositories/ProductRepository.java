package com.devsuperior.uri2621.repositories;

import com.devsuperior.uri2621.dto.ProductMinDto;
import com.devsuperior.uri2621.projections.ProductMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2621.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(nativeQuery = true, value = "SELECT products.name " +
            "FROM products " +
            "INNER JOIN providers " +
            "ON products.id_providers = providers.id " +
            "WHERE products.amount >= 10 AND products.amount <= 20 AND providers.name LIKE 'P%'")
    List<ProductMinProjection> search1(@Param("initial") String initial);

    @Query("SELECT new com.devsuperior.uri2621.dto.ProductMinDto(obj.name) " +
            "FROM Product obj " +
            "WHERE obj.amount BETWEEN 10 AND 20 " +
            "AND obj.provider.name LIKE 'P%'")
    List<ProductMinDto> search2(@Param("initial") String initial);

}
