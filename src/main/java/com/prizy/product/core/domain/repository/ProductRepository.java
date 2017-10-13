package com.prizy.product.core.domain.repository;

import com.prizy.product.core.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
}
