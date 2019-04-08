package com.allegro.trade.services;

import com.allegro.trade.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> listAllProducts();

    Optional<Product> getProductById(Integer id);

    Product saveOrUpdateProduct(Product product);

    void deleteProduct(Integer id);

    List<Product> listAllProductsWithDescription(String description);
}
