package com.allegro.trade.repository;

import com.allegro.trade.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    Iterable<Product> findByDescriptionContaining(String description);
}
