package com.example.Ecommerce.service;

import com.example.Ecommerce.model.Product;
import com.example.Ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    //create
    public Product saveProductService(Product product){
        return productRepository.save(product);
    }

    // Read
    public Product findProductService(int id){
        Optional<Product> productRes = productRepository.findById(id);
        return productRes.orElse(null);
    }

    // Delete
    public void deleteProductService(int id){
        Optional<Product> productRes = productRepository.findById(id);
        if(productRes.isEmpty()){
            return;
        }
        productRepository.deleteById(id);
    }

    //update
    public Product updateProductService(Product product, int id){
        Optional<Product> productRes = productRepository.findById(id);
        if(productRes.isEmpty()){
            deleteProductService(id);
        }
        Product res = saveProductService(product);
        res.setId(id);
        return res;
    }

    // saveAll()

    // saveAll an flush()
}
