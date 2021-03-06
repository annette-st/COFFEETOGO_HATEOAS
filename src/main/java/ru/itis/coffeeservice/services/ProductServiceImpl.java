package ru.itis.coffeeservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.coffeeservice.models.Product;
import ru.itis.coffeeservice.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product post(Long id) {
        Product p  = productRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        p.postProduct();
        productRepository.save(p);
        return p;
    }
}
