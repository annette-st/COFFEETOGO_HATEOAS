package ru.itis.coffeeservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.coffeeservice.services.ProductService;

@RepositoryRestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products/{product-id}/publish", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<?> publish(@PathVariable("product-id") Long productId) {
        return ResponseEntity.ok(
                new EntityModel<>(
                        productService.post(productId)));
    }

}
