package com.allegro.trade.controllers.rest;

import com.allegro.trade.models.Product;
import com.allegro.trade.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/product")
public class ApiProduct {

    private final ProductService productService;

    @Autowired
    public ApiProduct(ProductService productService) {
        this.productService = productService;
    }

    //produces = MediaType. .... - ustawienie zwracanych danych na konkretny typ//consumes podajemy przez COntentType w headers(np Postmanem)
    @RequestMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAllProductsJSON() {
        return productService.listAllProducts();
    }

    @RequestMapping(value = "/all", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
    public List<Product> getAllProductsXML() {
        return productService.listAllProducts();
    }

    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProductJSON(@PathVariable Integer id) {
        Optional<Product> product = productService.getProductById(id);

        if (product.isPresent()) {
            return product.get();
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void addProduct(@RequestBody Product product) {
        productService.saveOrUpdateProduct(product);
    }
}
