package com.example.Ecommerce.controller;

import com.example.Ecommerce.model.Product;
import com.example.Ecommerce.model.User;
import com.example.Ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.OK)
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProductService(product);
    }

    @GetMapping("/findproduct/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product findProduct(@PathVariable int id){
        return productService.findProductService(id);
    }

    @DeleteMapping("/deleteproduct/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable int id){
        productService.deleteProductService(id);
    }

    @PostMapping("/updateproduct/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct(@RequestBody Product product, @PathVariable int id){
        return productService.updateProductService(product, id);
    }


}
